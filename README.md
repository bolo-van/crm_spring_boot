# CRM Spring Boot + DynamoDB

Production-ready Spring Boot 3.5.7 service (Java 21) for storing and fetching three distinct entity types (Entity A/B/C) in AWS DynamoDB. Each entity has different attributes and access patterns, so the project models them as **separate tables** to keep capacity planning, indexes, and TTL policies independent.

## Why multiple tables?
Single-table design is great when entities share access patterns or must be fetched together. In this case the entities do not resemble each other and have different access rates, so separate tables reduce hot partitions, keep RCUs/WCUs isolated, and simplify operations.

## Configuration
Set the AWS region and table names in `application.properties`:

```properties
app.dynamodb.region=us-east-1
app.dynamodb.entity-a-table=entity_a
app.dynamodb.entity-b-table=entity_b
app.dynamodb.entity-c-table=entity_c
```

Optionally set `app.dynamodb.endpoint` for local DynamoDB testing.

## API
All endpoints are JSON-based.

### Entity A
```
POST /api/entity-a
GET  /api/entity-a/{id}
```

Create request:
```json
{
  "displayName": "Example A",
  "status": "ACTIVE"
}
```

### Entity B
```
POST /api/entity-b
GET  /api/entity-b/{id}
```

Create request:
```json
{
  "title": "Subscription",
  "amount": 12.99,
  "active": true
}
```

### Entity C
```
POST /api/entity-c
GET  /api/entity-c/{id}
```

Create request:
```json
{
  "category": "priority",
  "description": "Escalation note",
  "priorityScore": 80
}
```

## Notes
- Tables must exist in DynamoDB with a string partition key named `id`.
- The service uses AWS SDK v2 `DynamoDbEnhancedClient` and AWS Default Credentials Provider.
