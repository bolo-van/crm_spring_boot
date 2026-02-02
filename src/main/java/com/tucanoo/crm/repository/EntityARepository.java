package com.tucanoo.crm.repository;

import java.util.Optional;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import com.tucanoo.crm.config.DynamoDbTableProperties;
import com.tucanoo.crm.model.EntityA;

@Repository
public class EntityARepository {
    private final DynamoDbTable<EntityA> table;

    public EntityARepository(DynamoDbEnhancedClient client, DynamoDbTableProperties.Tables tables) {
        this.table = client.table(tables.entityATable(), TableSchema.fromBean(EntityA.class));
    }

    public EntityA save(EntityA entityA) {
        table.putItem(entityA);
        return entityA;
    }

    public Optional<EntityA> findById(String id) {
        EntityA entityA = table.getItem(Key.builder().partitionValue(id).build());
        return Optional.ofNullable(entityA);
    }
}
