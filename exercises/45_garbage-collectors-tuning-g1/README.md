# Garbage Collectors & Tuning (G1)

**Difficulty:** Medium

**Topics:** gc

## Description

Run a stress program under different GC flags (`-XX:+UseG1GC`, `-Xmx`) and collect GC logs for analysis.


## Learning objectives

- Understand the concept
- Provide working code or proof-of-concept
- Add tests or verification steps

## Acceptance criteria

- Module builds with `mvn test` (for code tasks)
- README documents approach and pitfalls

## Hints & pitfalls

- Think about edge cases and JVM concerns.

## How to test

Run `mvn test` in this module. For env tasks run `./verify.sh` if present.
