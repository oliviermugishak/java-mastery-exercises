# Feature Flagging & Experimentation Platform

## Goal
Build a lightweight feature flagging and A/B experimentation platform: define flags, evaluate them in low-latency server-side flows (Java), and measure experiment metrics with dashboards. Support rollout/targeting and fast kill switches.

## Stack
- Java backend (low-latency evaluation path)
- Storage: Postgres for config and event store; Redis for fast caches
- React UI for flag management and experiment dashboards

## Milestones
1. Core flag evaluation API and SDK (Java) with low overhead
2. UI to create flags and targeting rules
3. Event capture and metrics aggregation for experiments
4. Rollout and kill-switch endpoints with safety

## Acceptance criteria
- A flag can be created and evaluated in under N microseconds in a simple benchmark.
- Experiment metrics (conversion rate) show in dashboard for sample traffic.

## Resources
**Books**
- *Trustworthy Online Controlled Experiments* — Kohavi et al.
- *Designing Data-Intensive Applications* — experiment telemetry

**Papers**
- Papers on experimental design, false discovery rate, and sequential testing

**Libraries**
- LaunchDarkly docs (as inspiration)
- Apache Commons Math (for statistics)

## Ethics & guidance
- Include guidance on sample size, p-hacking, and data privacy.
- Provide conservative defaults and require manual sign-off for large rollouts.

