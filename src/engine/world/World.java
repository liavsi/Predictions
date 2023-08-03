package engine.world;

import engine.SimulationOutcome;
import engine.world.entity.Entity;
import engine.world.property.ActualProperty;
import engine.world.property.EntityProperty;
import engine.world.property.EnvironmentProperty;
import engine.world.rule.Rule;
import engine.world.utils.Expression;
import schema.generated.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class World implements HasProperties {
    Map<String,Entity> entities;// TODO: 03/08/2023 map?
    Map<String,Rule> rules;
    Map<String, EnvironmentProperty> environmentVars;

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

    EnvironmentProperty getEnvironmentVarByName(Expression envName) {
        EnvironmentProperty resultProperty = null;
        String propertyName = (String) envName.evaluate();
        if(propertyName == null) {
            throw new RuntimeException("Not a valid string");
        }
        for (EnvironmentProperty environmentVar : environmentVars.values()) {
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
        buildEntitiesFromPRD(prdWorld.getPRDEntities());
        buildEnvironmentFromPRD(prdWorld.getPRDEvironment());
        buildRulesFromPRD(prdWorld.getPRDRules());
    }

    private void buildRulesFromPRD(PRDRules prdRules) {
        rules = new HashMap<>();
        for (PRDRule prdRule: prdRules.getPRDRule()){
            String ruleName = prdRule.getName();
            Rule rule = new Rule(prdRule);
            rules.put(ruleName,rule);
        }
    }

    private void buildEnvironmentFromPRD(PRDEvironment prdEvironment) {
        environmentVars = new HashMap<>();
        for(PRDEnvProperty prdEnvProperty : prdEvironment.getPRDEnvProperty()){
            String name = prdEnvProperty.getPRDName();
            EnvironmentProperty environmentProperty = EnvironmentProperty.createPropertyFromPRD(prdEnvProperty);
            environmentVars.put(name,environmentProperty);
        }
    }

    private void buildEntitiesFromPRD(PRDEntities prdEntities) {
        entities = new HashMap<>();
        for (PRDEntity entity: prdEntities.getPRDEntity()){
            Entity currEntity = Entity.createInstanceFromPRD(entity);
            String entityName = entity.getName();
            entities.put(entityName,currEntity);
        }
    }

}