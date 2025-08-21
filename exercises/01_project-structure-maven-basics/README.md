# Project Structure & Maven Basics

**Difficulty:** Easy

**Topics:** tooling, maven

## Description

Create a multi-module Maven skeleton: root aggregator, two modules (library and app).
App depends on library; produce jar for library and runnable jar for app.


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
