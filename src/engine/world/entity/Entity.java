package engine.world.entity;

import engine.world.property.Property;

import java.util.Set;

public class Entity {

    private String name;
    private int quantityInPopulation;
    private Set<Property> propertyList;

    @Override
    public String toString() {
        return "\nName: " + name + "\nQuantity in population: " + quantityInPopulation + "\n Properties: " + propertyList.toString();
    }
}
