package engine.world.property;

import java.util.List;

public class Property {

    private String name;
    private Type type;
    private List<Restriction> restrictions;
    private Boolean isRandomInitialized = false; //default value

    @Override
    public String toString() {
        return "\nName: " + name + "\nType: " + type.toString() + "\nRestrictions: " +  restrictions.toString() + "\n Is Random Initialized: " + isRandomInitialized.toString();
    }
}