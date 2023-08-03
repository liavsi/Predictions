package engine.world.entity;

import engine.world.property.Property;
import schema.generated.PRDEntity;
import schema.generated.PRDProperties;
import schema.generated.PRDProperty;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Entity {

    private String name;
    private int quantityInPopulation;
    private Map<String,Property> properties;

    public static Entity createInstanceFromPRD(PRDEntity prdEntity) {
        Entity newEntity = new Entity();
        newEntity.properties = new HashMap<>();
        newEntity.name = prdEntity.getName();
        newEntity.quantityInPopulation = prdEntity.getPRDPopulation();
        for (PRDProperty prdProperty:prdEntity.getPRDProperties().getPRDProperty()){
            Property newProperty = Property.createPropertyFromPRD(prdProperty);
            String newPropertyName = prdProperty.getPRDName();
            newEntity.properties.put(newPropertyName,newProperty);
        }
        return newEntity;
    }

    @Override
    public String toString() {
        return "\nName: " + name + "\nQuantity in population: " + quantityInPopulation + "\n Properties: " + properties.toString();
    }

    public Property getPropertyByName(String propertyName) {
        Property resultProperty = null;
        for (Property environmentVar : properties.values()) {
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
