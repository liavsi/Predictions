package engine.world.entity;

import engine.world.HasProperties;
import engine.world.property.ActualProperty;
import engine.world.property.Property;

import java.util.Set;

public class ActualEntity implements HasProperties {

    private  Entity entityDetails;
    private Set<ActualProperty> actualProperties;

    public ActualProperty getPropertyByName(String propertyName) {
        ActualProperty resultProperty = null;
        for (ActualProperty property : actualProperties) {
            if (property.getName() == propertyName) {
                resultProperty = property;
            }
        }
        if (resultProperty == null) {
            throw new RuntimeException("did not find This Environment variable");
        }
        return resultProperty;
    }
}

