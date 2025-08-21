# Java Mastery Exercises — repository README

**A complete, concept-first curriculum of 100 Java mastery exercises** (language, JVM, tooling, architecture, concurrency, memory, NIO, security, testing, deployment and more).
This repo is a scaffold & course: each exercise is a self-contained Maven module with a README, starter code (for code tasks), tests (where applicable), and verification stubs for environment/tasks.

---

# Quick summary / purpose

This repo’s goal is to teach _real_ Java mastery — not just algorithm puzzles. Exercises focus on Java _concepts_ and _ecosystem_:

- Java language features: generics, type erasure, annotations, reflection.
- JVM internals: classloading, bytecode, GC, memory model.
- Concurrency & parallelism: thread pools, ForkJoin, JMM.
- I/O & NIO, networking, web & reactive stacks.
- Tooling & ops: Maven/Gradle, JMH, JFR, profiling, Docker, Graal.
- Testing, CI, security and production readiness.

Each exercise includes learning objectives, acceptance criteria, hints, and — when appropriate — JUnit tests or `verify.sh` scripts so you (or CI) can automatically verify work.

---

# Who I am

Hi — I’m **Olivier (Kwizera Mugisha Olivier)**. I’m building this repo as a hands-on path to become a senior, production-ready Java engineer: practical exercises, reproducible tests, and real-world tooling. If you use this repo, I hope it accelerates your learning as it does mine.

---

# Prerequisites

To generate modules and run the exercises you’ll need:

- Java JDK 17+ (or the JDK version you choose to target)
- Apache Maven 3.6+/3.8+
- Python 3.8+ (for the generator)
- `pyyaml` Python package (`pip install pyyaml`)
- Optional: Docker, GraalVM, native toolchains for advanced environment exercises

---

# Quickstart (generate & run)

1. Clone the repo:

   ```bash
   git clone https://github.com/<your-username>/java-mastery-exercises.git
   cd java-mastery-exercises
   ```

2. Install the small Python dependency:

   ```bash
   pip install pyyaml
   ```

3. Generate modules from the YAML source (creates `exercises/*` modules):

   ```bash
   python generate_exercises.py
   ```

4. Run tests (runs all module tests — may take a while):

   ```bash
   mvn -DskipTests=false test
   ```

5. Run or test a single exercise (faster during development):

   ```bash
   # run tests only for module 05_... (example)
   mvn -pl exercises/05_generics-type-erasure -am test
   ```

6. For an `env` module with a `verify.sh` stub:

   ```bash
   cd exercises/72_spring-boot-minimal-app-actuator
   ./verify.sh
   ```

---

# Repo structure (what you’ll find)

```
.
├─ exercises.yml                # master metadata: 100 exercises (id, type, desc, tests)
├─ generate_exercises.py        # generator: creates modules from the YAML
├─ pom.xml                      # root aggregator (generated)
├─ exercises/
│  ├─ 01_project-structure.../
│  │  ├─ pom.xml
│  │  ├─ README.md
│  │  ├─ src/main/java/...
│  │  └─ src/test/java/...
│  └─ ...
└─ README.md                    # this file
```

Notes:

- `type` may be `code`, `env`, `design`, or `essay`. Only `code` modules generate Java stubs & JUnit tests automatically.
- Code stubs follow package `org.javamastery.ex<ID>` and include `src/main/java` and `src/test/java` with JUnit 5 tests where `test_cases` are provided.
- `env` modules get a `verify.sh` (executable) as a place to add automated checks (useful for CI).

---

# How to use this repo (learning workflow)

1. Pick an exercise (folders are numbered 01–100). Read its module `README.md`.
2. For `code` exercises: implement the method in `src/main/java/...` and run `mvn -pl <module> -am test`. Fix until tests pass.
3. For `env` exercises: follow README instructions, implement verification steps in `verify.sh`, and run it locally or in CI.
4. Create a branch `work/ex<ID>-yourname`, push your solution, open a Pull Request. Add test coverage and a clear PR description of your approach and trade-offs.
5. Optionally, add a short write-up of pitfalls/lessons learned inside the module README.

---

# Contributing

Contributions are welcome — improvements, new exercises, better tests and real solutions.

Simple contribution steps:

1. Fork the repo → create a new branch `feature/<what-you-did>`.
2. Edit `exercises.yml` to add or improve exercises (or fix tests).
3. Run `python generate_exercises.py` locally to produce module scaffolding.
4. Implement and test your solution for `code` exercises or add `verify.sh` for `env` tasks.
5. Commit, push and open a PR. In your PR description include which exercise(s) you implemented and why.

Recommendations:

- For code exercises, include JUnit tests (assert edge-cases).
- Make tests deterministic and small (CI will run many of them).
- Update README of the module with learning objectives and pitfalls if you add new content.

---

# CI / Automation

Add a GitHub Actions workflow to run `mvn test` on PRs. Suggested workflow:

- Run on `push` and `pull_request`.
- Use `actions/checkout`, `setup-java` with JDK 17, and `mvn -B -DskipTests=false test`.

If you’d like, I can create a ready-to-commit `.github/workflows/ci.yml` file for you.

---

# Design & decisions (why this repo is organized this way)

- **YAML-driven source of truth**: exercises are maintained in `exercises.yml` so content and metadata are easy to edit and review.
- **Generator**: the `generate_exercises.py` script creates reproducible module scaffolds, README templates and JUnit tests (when applicable). This keeps the repo DRY and friendly for programmatic updates.
- **Mix of code + env + design tasks**: mastery requires both machine-checkable code and manual/tooling work; both are supported.
- **CI-friendly**: tests live inside modules so CI can verify solutions in an automated fashion.

---

# Roadmap & future improvements

- Add example **solutions** branch (or separate `solutions/` folder) with reference implementations.
- Add a GitHub Actions workflow that runs `mvn -pl` per-module in parallel for faster CI.
- Add auto-grading scripts and templates to accept student submissions via GitHub Classroom or automated PR checks.
- Expand exercise metadata with `learning_objectives`, `time_estimate`, `difficulty_tags`, and badges.

---

# License & Code of Conduct

This repository is intended to be open and permissive. Recommended defaults:

- License: Read the `licence.md` for reference

# Contact & support

- Open an issue on this repo with questions, suggestions or errors in exercises.
- When opening issues/PRs, please include: exercise id, a short description of the problem, and reproduction steps (if any).
