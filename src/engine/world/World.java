package engine.world;

import engine.SimulationOutcome;
import engine.world.entity.Entity;
import engine.world.property.ActualProperty;
import engine.world.property.Property;
import engine.world.rule.Rule;
import engine.world.utils.Expression;

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

    @Override
    public ActualProperty getPropertyByName(String propertyName) {
        // TODO: 02/08/2023 change to actual property
        return null;
    }

    Property getEnvironmentVarByName(Expression envName) {
        Property resultProperty = null;
        String propertyName = (String) envName.evaluate();
        if(propertyName == null) {
            throw new RuntimeException("Not a valid string");
        }
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