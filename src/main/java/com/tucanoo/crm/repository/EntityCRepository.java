package com.tucanoo.crm.repository;

import java.util.Optional;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import com.tucanoo.crm.config.DynamoDbTableProperties;
import com.tucanoo.crm.model.EntityC;

@Repository
public class EntityCRepository {
    private final DynamoDbTable<EntityC> table;

    public EntityCRepository(DynamoDbEnhancedClient client, DynamoDbTableProperties.Tables tables) {
        this.table = client.table(tables.entityCTable(), TableSchema.fromBean(EntityC.class));
    }

    public EntityC save(EntityC entityC) {
        table.putItem(entityC);
        return entityC;
    }

    public Optional<EntityC> findById(String id) {
        EntityC entityC = table.getItem(Key.builder().partitionValue(id).build());
        return Optional.ofNullable(entityC);
    }
}
