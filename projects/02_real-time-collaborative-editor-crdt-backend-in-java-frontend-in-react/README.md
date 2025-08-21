# Real-Time Collaborative Editor (CRDT-based)

## Overview
Build a collaborative text editor with real-time multi-user editing using CRDTs (Conflict-free Replicated Data Types). Backend is responsible for presence, persistence, authentication and optional offline sync. Frontend is React with operational update streaming via WebSocket.

## Problem solved
Most naive realtime editors use OT (operational transform) or central locks. CRDTs allow decentralised, conflict-free edits and natural offline-first behavior.

## Components & stack
- Backend: Java (Spring Boot / Quarkus) + WebSocket for real-time events
- Persistence: document state snapshots in durable store (Postgres / RocksDB)
- Sync protocol: chosen CRDT algorithm (RGA, Logoot, Yjs-CRDT ideas)
- Frontend: React + WebSocket client with cursor/selection sync

## Milestones
1. Implement a simple CRDT type (RGA or sequence CRDT) that applies inserts/deletes deterministically on operations.
2. Build a WebSocket channel to broadcast operations from a client to others.
3. Persist operations; add snapshot and compaction.
4. Cursor and presence sync.
5. Handle offline edits: client queues ops, replays on reconnect.

## Acceptance criteria
- Two browser clients can edit same doc live and observe consistent converged state.
- Offline edits are merged correctly on reconnect.
- Tests include property-based tests asserting convergence.

## Why revolutionary
- Enables offline-first collaboration with eventual consistency.
- Focus on correctness; CRDTs open path to decentralized editors without central authority.

## Resources (must-read)
**Research papers**
- *A Comprehensive Study of Convergent and Commutative Replicated Data Types* — Shapiro et al. (CRDT foundational paper)
- *Logoot: a distributed collaborative editing algorithm* — Ruiz & Steiner

**Books**
- *Designing Data-Intensive Applications* — Martin Kleppmann (esp. chapters on consistency)
- *Real-time Systems and CRDT tutorials* (online)

**Libraries & references**
- Yjs (JS CRDT implementation) — good for algorithmic study
- Automerge — reference OT/CRDT behavior

**Articles**
- Martin Kleppmann blog on CRDTs and distributed data

**Implementation tips**
- Write unit tests that randomize sequences of operations and assert that two replicas converge.
- Consider binary or efficient encoding for network ops.

