package engine.world;

import engine.SimulationOutcome;
import engine.world.entity.Entity;
import engine.world.property.Property;
import engine.world.rule.Rule;

import java.util.Collection;

public class World {
    Collection<Entity> entities;
    Collection<Rule> rules;
    Collection<Property> environmentVars;

    @Override
    public String toString() {
        return "Entities: " + entities.toString() + "\nRules: " +rules.toString()
                +"\nEnvironment Variables: " +environmentVars.toString();
    }

    public SimulationOutcome runSimulation() {
        return new SimulationOutcome();
    }
}