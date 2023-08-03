package engine.world;

import engine.SimulationOutcome;
import engine.world.entity.Entity;
import engine.world.property.ActualProperty;
import engine.world.property.Property;
import engine.world.rule.Rule;
import engine.world.utils.Expression;
import schema.generated.*;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class World implements HasProperties {
    Map<String,Entity> entities;// TODO: 03/08/2023 map?
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
    } // TODO: 03/08/2023

    public void buildWorldFromGeneratedWorld(PRDWorld prdWorld) {
        buildEntitiesFromGenerated(prdWorld.getPRDEntities());
        buildEnvironmentFromGenerated(prdWorld.getPRDEvironment());
        buildRulesFromGenerated(prdWorld.getPRDRules());
    }

    private void buildRulesFromGenerated(PRDRules prdRules) {
    }// TODO: 03/08/2023

    private void buildEnvironmentFromGenerated(PRDEvironment prdEvironment) {
    }// TODO: 03/08/2023

    private void buildEntitiesFromGenerated(PRDEntities prdEntities) {
        entities = new HashMap<>();
        for (PRDEntity entity: prdEntities.getPRDEntity()){
            Entity currEntity = Entity.createInstanceFromPRD(entity);
            String entityName = entity.getName();
            entities.put(entityName,currEntity);
        }
    }

}