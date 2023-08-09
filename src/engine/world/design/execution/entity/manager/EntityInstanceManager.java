package engine.world.design.execution.entity.manager;

import engine.world.design.definition.entity.api.EntityDefinition;
import engine.world.design.execution.entity.impl.EntityInstance;

import java.util.List;

public interface EntityInstanceManager {

    EntityInstance create(EntityDefinition entityDefinition);
    List<EntityInstance> getInstances();

}
