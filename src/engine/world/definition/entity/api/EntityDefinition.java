package engine.world.definition.entity.api;

import engine.world.definition.property.api.PropertyDefinition;

import java.util.List;

public interface EntityDefinition {
    String getName();
    int getPopulation();
    List<PropertyDefinition> getProps();
}
