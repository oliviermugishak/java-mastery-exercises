# Distributed Task Queue & Scheduler

## Goal
Design and implement a fault-tolerant distributed task queue with retries, backoff, scheduling, and exactly-once/at-least-once semantics options for workers.

## Use-cases
- Periodic jobs (cron-like)
- Background work (image processing, notifications)
- Pipelines with back-pressure

## Stack & suggestions
- Java backend services using Spring Boot / Quarkus
- Messaging/storage: Kafka for durable queue; Redis (streams) or custom DB-backed queue for simplified PoC
- Leader election: ZooKeeper / etcd / Raft (or use Kafka consumer groups for partitioned workers)

## Milestones
1. Simple durable queue using Kafka topics + worker consumer + ack system.
2. Implement retries and exponential backoff.
3. Add scheduling layer: schedule tasks for future execution with persistence.
4. Graceful worker shutdown and idempotent task handling.
5. Optional: implement lightweight Raft consensus to coordinate leader for scheduling.

## Acceptance criteria
- Worker processes tasks and can resume after restart without losing tasks.
- Retries and delay scheduling work as expected.
- Demonstrated at-least-once / idempotent handler pattern in tests.

## Resources
**Books**
- *Designing Data-Intensive Applications* — Martin Kleppmann
- *Distributed Systems: Principles and Paradigms*

**Papers**
- *The log as a storage abstraction* (Kafka's design rationale)
- Raft paper: *In Search of an Understandable Consensus Algorithm* — Diego Ongaro & John Ousterhout

**Libraries & Tools**
- Kafka, Redis Streams, Spring Kafka
- Testcontainers for integration testing

## Tips
- Make handlers idempotent for safety.
- Use partitioning keys for distribution of related tasks.
- Benchmark large-enqueue scenarios and plan retention/compaction.

