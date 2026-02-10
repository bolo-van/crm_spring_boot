package com.tucanoo.crm.repository;

import java.util.Optional;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import com.tucanoo.crm.config.DynamoDbTableProperties;
import com.tucanoo.crm.model.EntityB;

@Repository
public class EntityBRepository {
    private final DynamoDbTable<EntityB> table;

    public EntityBRepository(DynamoDbEnhancedClient client, DynamoDbTableProperties.Tables tables) {
        this.table = client.table(tables.entityBTable(), TableSchema.fromBean(EntityB.class));
    }

    public EntityB save(EntityB entityB) {
        table.putItem(entityB);
        return entityB;
    }

    public Optional<EntityB> findById(String id) {
        EntityB entityB = table.getItem(Key.builder().partitionValue(id).build());
        return Optional.ofNullable(entityB);
    }
}
