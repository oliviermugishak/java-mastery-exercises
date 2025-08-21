# Streaming Analytics — real-time insights

## Goal
Create a streaming analytics pipeline that computes real-time aggregations, sessionization, and anomaly detection on event streams (e.g., clickstream, sensor data). Push concise insights to dashboards or alerting endpoints.

## Stack
- Java: Kafka Streams or Flink (Java API)
- Kafka as ingestion backbone
- Storage for results: ElasticSearch / ClickHouse / materialized views
- Optional React dashboard for visualization

## Milestones
1. Producer simulation generating events (Java)
2. Build streaming job computing counts and sliding-window percentiles
3. Add sessionization and late-arrival handling
4. Anomaly detector (simple threshold + z-score) and alerting

## Acceptance criteria
- Stream job processes messages end-to-end with correct windowed aggregation.
- Handles late events and watermarking correctly (unit/integration tests).

## Resources
**Books**
- *Designing Data-Intensive Applications* — chapters on streaming
- *Streaming Systems* — Tyler Akidau, Slava Chernyak (for streaming primitives)

**Papers & sources**
- Google MillWheel / Flink docs
- Kafka Streams docs and examples

**Tools**
- Kafka, Kafka Streams API, Flink
- Confluent examples and Testcontainers

