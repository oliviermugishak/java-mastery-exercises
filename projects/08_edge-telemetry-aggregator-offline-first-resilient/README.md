# Edge Telemetry Aggregator — resilient telemetry for intermittent networks

## Overview
Collect telemetry from edge devices (IoT or mobile apps), support offline buffering, and implement case where devices sync when network is available. Backend aggregates and deduplicates telemetry and provides a React dashboard to view aggregated metrics.

## Key constraints
- intermittent connectivity
- minimal bandwidth and CPU on device side (client SDK must be lightweight)
- deduplication and idempotency

## Stack
- Backend: Java (Spring Boot), REST + push endpoints
- Device clients: small Java client (or JS/Android) for PoC
- Storage: time-series DB (InfluxDB/Timescale) or optimized append-only store

## Milestones
1. Design a compact binary wire format and implement client queueing.
2. Backend: ingest streamed batches with deduplication.
3. Dashboard: show device health and aggregated metrics by device/region.
4. Add data compression and retention policy.

## Acceptance criteria
- Device simulator can produce data while offline; data syncs and deduplicates on reconnect.
- Dashboard reflects correct aggregated counts.

## Resources
**Papers**
- Edge computing and syncing strategies (eventual consistency, CRDT ideas)
**Books**
- *Designing Data-Intensive Applications* (edge chapters)
**Tools**
- MQTT / HTTP clients, Protobuf for compact representation

