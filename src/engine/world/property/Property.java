package engine.world.property;

import schema.generated.PRDProperty;
import schema.generated.PRDRange;
import schema.generated.PRDValue;

import java.util.List;

public class Property {

    private String name;
    private Type type;
    private Restriction restrictions;
    private RandomInitializer randomInitializer;


    public static Property createPropertyFromPRD(PRDProperty prdProperty) {
        Property newProperty = new Property();
        newProperty.name = prdProperty.getPRDName();
        newProperty.type = Type.valueOf(prdProperty.getType().toUpperCase());// TODO: 03/08/2023 exception(?)
        PRDRange prdRange = prdProperty.getPRDRange();
        newProperty.restrictions = new Restriction(prdRange.getFrom(),prdRange.getTo());
        PRDValue prdValue = prdProperty.getPRDValue();
        newProperty.randomInitializer = new RandomInitializer(prdValue.isRandomInitialize(),prdValue.getInit());
        return newProperty;
    }

    @Override
    public String toString() {
        return "\nName: " + name + "\nType: " + type.toString() + "\nRestrictions: " +  restrictions.toString() + "\n Is Random Initialized: " + randomInitializer.toString();
    }

    public String getName() {
        return name;
    }

    public Type getType(){
        return type;
    }
}