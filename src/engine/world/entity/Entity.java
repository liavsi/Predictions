package engine.world.entity;

import engine.world.property.Property;

import java.util.Set;

public class Entity {

    private String name;
    private int quantityInPopulation;
    private Set<Property> properties; //ToDo change to map

    @Override
    public String toString() {
        return "\nName: " + name + "\nQuantity in population: " + quantityInPopulation + "\n Properties: " + properties.toString();
    }

    public Property getPropertyByName(String propertyName) {
        Property resultProperty = null;
        for (Property environmentVar : properties) {
            if (environmentVar.getName() == propertyName) {
                resultProperty = environmentVar;
            }
        }
        if (resultProperty == null) {
            throw new RuntimeException("did not find This Environment variable");
        }
        return resultProperty;
    }
}
