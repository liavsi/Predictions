package engine.world;

import engine.SimulationOutcome;
import engine.world.entity.Entity;
import engine.world.property.Property;
import engine.world.rule.Rule;

import java.util.Collection;

public class World implements HasProperties {
    Collection<Entity> entities;
    Collection<Rule> rules;
    Collection<Property> environmentVars;

    @Override
    public String toString() {
        return "Entities: " + entities.toString() + "\nRules: " +rules.toString()
                +"\nEnvironment Variables: " +environmentVars.toString();
    }

    public Property getPropertyByName(String propertyName) {
        Property resultProperty = null;
        for (Property environmentVar : environmentVars) {
            if (environmentVar.getName() == propertyName) {
                resultProperty = environmentVar;
            }
        }
        if (resultProperty == null) {
            throw new RuntimeException("did not find This Environment variable");
        }
        return resultProperty;
    }

    public SimulationOutcome runSimulation() {
        return new SimulationOutcome();
    }
}