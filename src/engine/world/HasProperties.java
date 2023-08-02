package engine.world;

import engine.world.property.ActualProperty;
import engine.world.property.Property;

public interface HasProperties {

    public ActualProperty getPropertyByName(String propertyName);
}
