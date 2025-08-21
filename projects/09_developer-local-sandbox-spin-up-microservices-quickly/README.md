# Local Microservice Sandbox — boost developer productivity

## What
A CLI + Java service that spins up a local sandbox environment for multi-service testing: lightweight mocks, local service discovery, patched configs, and hot-reload. Aim: developer runs `sandbox start` and gets a multi-service environment in seconds.

## Why revolutionary
Developers lose hours configuring local stacks. This tool automates reproducible local environments with deterministic ports, seeded data, and health checks.

## Stack
- Core: Java CLI (Picocli) that orchestrates Docker Compose or lightweight process-based services
- Optional: small React UI to visualize running services

## Milestones
1. CLI to start and stop composed services (Docker Compose wrapper)
2. Add seeding scripts and deterministic test data loading
3. Hot-reload configuration on file change
4. Add snapshot/restore support for fast resets

## Acceptance criteria
- `sandbox start` boots up a composed stack for a sample app and all services become reachable.
- Snapshot & restore reduces environment reset time by >50%.

## Resources
- Docker Compose docs, Testcontainers
- Articles on dev productivity (Kent Beck, Martin Fowler)
