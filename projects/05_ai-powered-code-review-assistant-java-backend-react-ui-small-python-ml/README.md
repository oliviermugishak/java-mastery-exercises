# AI Code Review Assistant — review suggestions, safety checks, and actionable comments

## Overview
This project builds a lightweight code-review assistant: analyze Java diffs and produce comments with suggestions (style, potential bugs, security checks). ML/NLP model components may use Python (only for model inferencing); core orchestration and rule-based checks should be Java.

## Boundaries & languages
- Java: ingestion, rule-based checks, plugin for GitHub/GitLab webhooks, REST API
- React: UI to show suggestions & allow accept/reject
- Python: optional model for semantic suggestions (use a small transformer or open-source embedding model) — isolate ML as a service

## Milestones
1. Build a static analysis engine with rules (PMD/Checkstyle like) to spot common issues.
2. Build plugin to receive PR events and run checks producing review comments.
3. Add ML-based suggestion endpoint (Python microservice) optionally using open models.
4. UI: show PR with inline suggestions and ability to accept/fix via quick fixes.

## Acceptance criteria
- Runs on a sample repo PR and posts comments via GitHub API or simulated UI.
- Rule-based checks detect a set of anti-patterns and provide remediation suggestions.

## Resources
**Papers**
- Recent papers on code representation and program synthesis (e.g., CodeBERT, GraphCodeBERT)
- Research on automated program repair

**Books**
- *Working Effectively with Legacy Code* — Michael Feathers (for refactoring use-cases)
- *Refactoring* — Martin Fowler

**Libraries**
- PMD, SpotBugs for quick wins
- Open-source models: CodeBERT, CodeT5 (run via Python service)
- GitHub API docs

## Ethics & safety
- Ensure suggestions are conservative and include confidence scores.
- Provide a human-in-the-loop to avoid erroneous auto-fixes.

