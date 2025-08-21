# Modular Java Build Tool — experimental lightweight package manager

## Idea
Design a tiny modular build tool focused on modular Java apps (JPMS) with reproducible builds, fast local caching and a simple plugin model. Think of a focused "fast" alternative to full Gradle/Maven for microservices.

## Why build this
Understanding packaging and build complexity reveals much about module boundaries and reproducible releases.

## Components
- CLI tool in Java that resolves dependencies from Maven Central or local cache
- Local module graph resolution and caching layer
- Plugin API for tasks (compile, test, package)
- Optional React UI for exploring dependency graphs

## Milestones
1. Build simple CLI to download a jar and cache it.
2. Implement module graph resolution for a set of modules (local POM-like descriptors).
3. Add build tasks: compile via javac, package jar.
4. Integrate simple plugin API and basic unit tests.

## Acceptance criteria
- CLI can build a minimal multi-module project reproducibly and faster than the baseline.

## Resources
**Papers & docs**
- Maven / Gradle internals articles
- JPMS module system docs

**Books**
- *Java Performance* — for compiling and packaging choices
- *Building Java Projects with Gradle* (for reference)

