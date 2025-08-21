# Secret Manager Service — secure secrets for apps

## Objective
Implement a secure secret storage and distribution service with:
- Encrypted-at-rest secrets
- Fine-grained access control
- Short-lived secrets/tokens issuance
- Auditing and rotation

## Why important
Secrets leakage is a root cause of many breaches. This project demonstrates a production-ready approach.

## Stack & components
- Java backend (Spring Security)
- Crypto: use JCE AES-GCM, secrets derived via HKDF; don't roll your own crypto
- Storage: encrypted blobs in DB (Postgres)
- AuthN/AuthZ: JWT + RBAC or OAuth2 introspection
- Optional UI: React dashboard for secrets & rotation workflows

## Milestones
1. Define data model and KMS abstraction (Key Management Service)
2. Implement master key wrapping (master key stored in OS keystore or cloud KMS)
3. REST API: create/get/list secrets with permission checks
4. Audit trail and rotation endpoint
5. Client library to fetch secrets and cache with TTL

## Acceptance criteria
- Secrets are stored encrypted and cannot be read from the DB without KMS.
- ACLs enforced for read/write operations.
- Rotation mechanism rotates underlying encryption keys and rewraps secrets.

## Resources (security-first)
**Guides**
- NIST guidelines for key management
- OWASP cryptographic storage cheat sheet

**Books**
- *Cryptography Engineering* — practical crypto
- *Serious Cryptography* — details modern ciphers and KDFs

**Libraries**
- BouncyCastle, Java Cryptography (JCE), Spring Security
- Cloud KMS docs (GCP/AWS/Azure) — for optional production tying

## Notes
- For PoC use a secure local keystore; for production rely on cloud HSM or KMS.
- Add exhaustive integration tests ensuring keys cannot be derived from storage alone.

