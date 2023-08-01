package engine.world;

import engine.world.property.Property;

public interface HasProperties {

    public Property getPropertyByName(String propertyName);
}
