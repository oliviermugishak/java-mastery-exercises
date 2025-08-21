#!/usr/bin/env python3
"""
Robust generator for Java Mastery exercises from exercises.yml

- Continues on errors (collects and reports them).
- Treats missing `type` as "env" by default.
- Auto-fills entry_class and method_signature when missing (logged).
- Skips test generation when test literals are unsupported (logged).
"""

import yaml
import re
import textwrap
import sys
from pathlib import Path

ROOT_GROUP = "org.javamastery"
ROOT_VERSION = "1.0-SNAPSHOT"
ROOT_PACKAGE_BASE = "org.javamastery"

OUT_DIR = Path(".")
EX_DIR = OUT_DIR / "exercises"

def slugify(text: str) -> str:
    s = text.lower()
    s = re.sub(r"[^\w\s-]", "", s)
    s = re.sub(r"[\s_]+", "-", s).strip("-")
    return s

def title_to_classname(title):
    s = ''.join(ch if ch.isalnum() else ' ' for ch in title).title().replace(' ', '')
    if not s or not s[0].isalpha():
        s = "Exercise" + s
    return s

def parse_method_signature(sig: str):
    """
    Parse a simple signature like:
      int foo(int a, String s)
    Returns (ret_type, name, [(ptype,pname), ...])
    Raises ValueError if not parseable.
    """
    m = re.match(r"\s*(\S+)\s+([A-Za-z_]\w*)\s*\((.*)\)\s*$", sig or "")
    if not m:
        raise ValueError(f"Can't parse method signature: {sig!r}")
    ret_type, name, params = m.group(1), m.group(2), m.group(3).strip()
    if params == "":
        return ret_type, name, []
    parts = [p.strip() for p in params.split(",")]
    parsed = []
    for p in parts:
        tokens = p.split()
        if len(tokens) < 2:
            raise ValueError(f"Can't parse parameter part: {p!r} in signature {sig!r}")
        ptype = " ".join(tokens[:-1])
        pname = tokens[-1]
        parsed.append((ptype, pname))
    return ret_type, name, parsed

def java_literal(value):
    """Render a Python value (from YAML) into a Java source literal string.
    Supports: None, bool, int, float, str, list (for int[] / String[] / int[][]).
    Raises ValueError if unsupported.
    """
    if value is None:
        return "null"
    if isinstance(value, bool):
        return "true" if value else "false"
    if isinstance(value, int):
        return str(value)
    if isinstance(value, float):
        return repr(value)
    if isinstance(value, str):
        s = value.replace("\\", "\\\\").replace("\"", "\\\"")
        return f"\"{s}\""
    if isinstance(value, list):
        # empty list: ambiguous; caller should provide parameter type, but we try int[] fallback
        if not value:
            return "new int[]{}"
        first = value[0]
        if isinstance(first, str):
            inner = ",".join(java_literal(x) for x in value)
            return f"new String[]{{{inner}}}"
        elif isinstance(first, int):
            inner = ",".join(java_literal(x) for x in value)
            return f"new int[]{{{inner}}}"
        elif isinstance(first, list):
            # nested arrays: assume int[][]
            rows = []
            for row in value:
                if not isinstance(row, list):
                    raise ValueError("Expected list of lists for nested arrays")
                rows.append("new int[]{" + ",".join(str(int(x)) for x in row) + "}")
            return "new int[][]{" + ",".join(rows) + "}"
    raise ValueError(f"Unsupported literal type: {value!r} ({type(value)})")

def render_child_pom(artifact_id):
    return textwrap.dedent(f"""\
    <project xmlns="http://maven.apache.org/POM/4.0.0"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
                                 http://maven.apache.org/xsd/maven-4.0.0.xsd">
      <modelVersion>4.0.0</modelVersion>
      <parent>
        <groupId>{ROOT_GROUP}</groupId>
        <artifactId>java-mastery-exercises</artifactId>
        <version>{ROOT_VERSION}</version>
      </parent>
      <artifactId>{artifact_id}</artifactId>
      <packaging>jar</packaging>
      <dependencies>
        <dependency>
          <groupId>org.junit.jupiter</groupId>
          <artifactId>junit-jupiter-api</artifactId>
          <version>5.10.0</version>
          <scope>test</scope>
        </dependency>
        <dependency>
          <groupId>org.junit.jupiter</groupId>
          <artifactId>junit-jupiter-engine</artifactId>
          <version>5.10.0</version>
          <scope>test</scope>
        </dependency>
      </dependencies>
      <build>
        <plugins>
          <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>3.0.0</version>
            <configuration>
              <useModulePath>false</useModulePath>
            </configuration>
          </plugin>
        </plugins>
      </build>
    </project>
    """)

def render_root_pom(modules):
    modules_entries = "\n".join(f"      <module>{m}</module>" for m in modules)
    return textwrap.dedent(f"""\
    <project xmlns="http://maven.apache.org/POM/4.0.0"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
                                 http://maven.apache.org/xsd/maven-4.0.0.xsd">
      <modelVersion>4.0.0</modelVersion>
      <groupId>{ROOT_GROUP}</groupId>
      <artifactId>java-mastery-exercises</artifactId>
      <version>{ROOT_VERSION}</version>
      <packaging>pom</packaging>
      <modules>
    {modules_entries}
      </modules>
    </project>
    """)

def render_solution_class(package, class_name, ret_type, method_name, params):
    params_str = ", ".join(f"{t} {n}" for t, n in params)
    default_return = "return 0;"
    if ret_type in ("void",):
        default_return = ""
    elif ret_type in ("boolean",):
        default_return = "return false;"
    elif ret_type in ("long",):
        default_return = "return 0L;"
    elif ret_type in ("double", "float"):
        default_return = "return 0.0;"
    elif ret_type == "String":
        default_return = 'return "";'
    elif ret_type.endswith("[]"):
        base = ret_type[:-2]
        default_return = f"return new {base}[]{{}};"
    else:
        default_return = "return 0;"

    return textwrap.dedent(f"""\
    package {package};

    public class {class_name} {{
        public static {ret_type} {method_name}({params_str}) {{
            // TODO: implement solution
            {default_return}
        }}
    }}
    """)

def render_test_class(package, class_name, test_cases, ret_type, method_name, params):
    header = textwrap.dedent(f"""\
    package {package};

    import org.junit.jupiter.api.Test;
    import static org.junit.jupiter.api.Assertions.*;

    public class {class_name}Test {{
    """)
    body = "    @Test\n    public void providedCases() {\n"
    for tc in test_cases:
        args = tc.get("args", [])
        expected = tc.get("expected", None)
        # build arg literals; if any arg can't be converted, raise ValueError
        arg_literals = []
        for idx, (ptype, pname) in enumerate(params):
            if idx >= len(args):
                raise ValueError(f"Test case args length {len(args)} < params {len(params)}")
            val = args[idx]
            lit = java_literal(val)  # may raise
            arg_literals.append(lit)
        call_args = ", ".join(arg_literals)
        if ret_type.endswith("[]"):
            body += f"        assertArrayEquals({java_literal(expected)}, {class_name}.{method_name}({call_args}));\n"
        elif ret_type == "boolean":
            if expected:
                body += f"        assertTrue({class_name}.{method_name}({call_args}));\n"
            else:
                body += f"        assertFalse({class_name}.{method_name}({call_args}));\n"
        elif ret_type in ("double","float"):
            body += f"        assertEquals({java_literal(expected)}, {class_name}.{method_name}({call_args}), 1e-9);\n"
        else:
            body += f"        assertEquals({java_literal(expected)}, {class_name}.{method_name}({call_args}));\n"
    body += "    }\n"
    footer = "}\n"
    return header + body + footer

def make_readme(module_dir, item):
    title = item.get("title","")
    desc = item.get("description","")
    topics = ", ".join(item.get("topics",[]))
    difficulty = item.get("difficulty","")
    objectives = item.get("learning_objectives", [
        "Understand the concept",
        "Provide working code or proof-of-concept",
        "Add tests or verification steps"
    ])
    acceptance = item.get("acceptance_criteria", [
        "Module builds with `mvn test` (for code tasks)",
        "README documents approach and pitfalls"
    ])
    content = f"# {title}\n\n**Difficulty:** {difficulty}\n\n**Topics:** {topics}\n\n## Description\n\n{desc}\n\n## Learning objectives\n\n"
    for o in objectives:
        content += f"- {o}\n"
    content += "\n## Acceptance criteria\n\n"
    for a in acceptance:
        content += f"- {a}\n"
    content += "\n## Hints & pitfalls\n\n- Think about edge cases and JVM concerns.\n\n"
    content += "## How to test\n\nRun `mvn test` in this module. For env tasks run `./verify.sh` if present.\n"
    (module_dir / "README.md").write_text(content, encoding="utf-8")

def main():
    try:
        import yaml
    except ImportError:
        print("Install PyYAML: pip install pyyaml")
        sys.exit(1)

    srcy = Path(".", "exercises.yml")
    if not srcy.exists():
        print("exercises.yml not found in current directory. Create it first.")
        sys.exit(1)

    data = yaml.safe_load(srcy.read_text())
    EX_DIR.mkdir(exist_ok=True)
    modules = []
    errors = []
    skipped_modules = []

    for item in data:
        idn = item.get("id", "<no-id>")
        title = item.get("title", "<no-title>")
        ttype = item.get("type")
        if ttype is None:
            # treat missing type as env so we don't require code keys
            ttype = "env"
            print(f"[warn] entry {idn} ('{title}') missing 'type' -> defaulting to 'env'")

        slug = f"{idn}_{slugify(title)}"
        module_dir = EX_DIR / slug

        try:
            module_dir.mkdir(parents=True, exist_ok=True)
            modules.append(f"exercises/{slug}")
            # write child pom
            child_pom = render_child_pom(slug)
            (module_dir / "pom.xml").write_text(child_pom, encoding="utf-8")
            # create README
            make_readme(module_dir, item)

            if ttype == "code":
                entry = item.get("entry_class")
                sig = item.get("method_signature")
                # auto-fill missing values (but log it)
                if not entry:
                    entry = title_to_classname(title)
                    print(f"[auto-fill] entry_class for '{title}' -> {entry}")
                if not sig:
                    sig = "void run()"
                    print(f"[auto-fill] method_signature for '{title}' -> {sig}")

                try:
                    ret_type, method_name, params = parse_method_signature(sig)
                except Exception as e:
                    msg = f"Failed to parse signature for {idn} '{title}': {e}"
                    print("[error]", msg)
                    errors.append(msg)
                    # still create stub class with a safe run method
                    ret_type, method_name, params = "void", "run", []
                pkg = f"{ROOT_PACKAGE_BASE}.ex{idn}"
                java_dir = module_dir / "src" / "main" / "java" / Path(*pkg.split("."))
                test_dir = module_dir / "src" / "test" / "java" / Path(*pkg.split("."))
                java_dir.mkdir(parents=True, exist_ok=True)
                test_dir.mkdir(parents=True, exist_ok=True)

                # solution stub
                sol = render_solution_class(pkg, entry, ret_type, method_name, params)
                (java_dir / f"{entry}.java").write_text(sol, encoding="utf-8")

                # tests: generate if test_cases present and convertible
                test_cases = item.get("test_cases", [])
                if test_cases:
                    try:
                        test_src = render_test_class(pkg, entry, test_cases, ret_type, method_name, params)
                        (test_dir / f"{entry}Test.java").write_text(test_src, encoding="utf-8")
                    except Exception as e:
                        msg = f"Skipping tests for {idn} '{title}': {e}"
                        print("[warn]", msg)
                        errors.append(msg)
                        # leave module without tests
                else:
                    print(f"[info] code module {idn} ('{title}') has no test_cases; generated stub only.")

            else:
                # env/design/essay: create verify.sh stub (executable)
                verify = module_dir / "verify.sh"
                if not verify.exists():
                    verify.write_text("#!/usr/bin/env bash\n\n# Verification script for environment task\n# Implement checks here, e.g., run a server, call endpoints, assert outputs\n\necho \"No automated checks implemented. Follow README instructions.\"\n", encoding="utf-8")
                    verify.chmod(0o755)

            print(f"[ok] created module: {module_dir}")

        except Exception as e:
            msg = f"Failed to create module for {idn} '{title}': {e}"
            print("[error]", msg)
            errors.append(msg)
            skipped_modules.append((idn, title))
            continue

    # write root pom and README
    try:
        root_pom = render_root_pom(modules)
        (OUT_DIR / "pom.xml").write_text(root_pom, encoding="utf-8")
        (OUT_DIR / "README.md").write_text("# Java Mastery Exercises\n\nRun `python generate_exercises.py` to re-generate modules from `exercises.yml`.\n\nBuild and test: `mvn -DskipTests=false test`\n", encoding="utf-8")
    except Exception as e:
        errors.append(f"Failed to write root pom/README: {e}")

    # Summary
    print("\n=== Generation summary ===")
    print(f"Modules created: {len(modules)}")
    if skipped_modules:
        print(f"Modules skipped due to errors: {len(skipped_modules)}")
        for idn, title in skipped_modules:
            print(f" - {idn}: {title}")
    if errors:
        print("\nErrors / Warnings:")
        for err in errors:
            print(" -", err)
        print("\nFix reported issues and re-run the generator if needed.")
    else:
        print("No errors reported. Generation completed successfully ✅")

if __name__ == "__main__":
    main()
