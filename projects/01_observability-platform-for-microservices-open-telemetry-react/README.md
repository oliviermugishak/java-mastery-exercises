# Observability Platform — lightweight, open, actionable

## What this project is
A small but powerful observability platform tailored for microservices: ingest traces, metrics, and logs from multiple services, store them efficiently, and present actionable insights in a fast React dashboard. Focus on signal (SLOs, latency percentiles, error budgets) rather than dumping every metric.

## Problem it solves
Many teams spin up Prometheus + Jaeger + ELK and drown in noise. This project builds a curated observability layer with:
- Tracing-based latency analysis (distributed traces, flamegraphs)
- Alert-ready metrics with SLO policies
- Correlated logs linked to traces
- A React UI that surfaces slow endpoints, top offenders, and heatmaps

## What to build (stack & boundaries)
- Backend: Java (Spring Boot / Micronaut / Quarkus), REST + gRPC ingress
- Ingest: OTLP (OpenTelemetry) receiver; store traces/metrics in a lightweight storage (e.g., ClickHouse, Timescale, or local file store + simple index for PoC)
- Processing: aggregation pipeline (windowed percentile calculations)
- UI: React (Vite + TypeScript) showing traces, latency histograms, error rates over time, service map
- Optional: instrument a sample microservice set (Java) to produce telemetry

## Why this is revolutionary
- Focus on *SLO-driven* observability and automated prioritization of issues.
- Small footprint alternative to giant stacks — designed for teams that want meaningful insight fast.

## Milestones (incremental)
1. PoC OTLP receiver: accept traces via HTTP and persist minimal trace model to disk.
2. Query layer: API to fetch traces by traceId and latency histograms by service+endpoint.
3. Simple React UI: list recent slow traces, show flamegraph (collapsed view).
4. Metrics pipeline: ingest OTLP metrics, compute p50/p95/p99 sliding windows and store.
5. Correlate logs: store logs with traceId; in UI click trace -> show logs.
6. Add SLO definitions and schedule: compute burn rate and show alerts.

## Acceptance criteria
- Ingests traces and metrics from a sample Java service.
- React UI lists traces and displays p95 latency for endpoints.
- Basic SLO configured with alert flags in UI.
- Documented run guide and Docker development compose for local testing.

## Suggested tech
- Java: Spring Boot / Quarkus, OpenTelemetry Java SDK
- Storage: ClickHouse / Timescale (or in-memory for PoC)
- Web: React + Vite + TypeScript
- Tools: Docker, Testcontainers for integration tests, Prometheus for comparison

## Resources (books, papers, articles, implementations)
**Books**
- *Seeking SRE* (SRE practices and SLOs) — Google
- *Distributed Systems Observability* — Cindy Sridharan
- *Site Reliability Engineering* — Google SRE book (chapters on monitoring & alerting)

**Papers & docs**
- OpenTelemetry Spec & OTLP: https://opentelemetry.io
- *SLOs — what they are and why they matter* (blog posts by Google / Honeycomb)
- *Latency is Everywhere* — systems analysis articles

**Libraries & examples**
- OpenTelemetry Java: https://github.com/open-telemetry/opentelemetry-java
- Jaeger, Tempo, ClickHouse examples

**Courses**
- Monitoring & observability courses on O’Reilly / Udemy
- CNCF webinars about OpenTelemetry

---

## Tips & pitfalls
- Start small: store traces minimally (service, span, start, duration, parent).
- Avoid high-cardinality labels in metrics until you design cardinality strategy.
- Use Testcontainers to test data ingestion and query pipeline.

