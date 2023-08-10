package engine.world.design.impl;

import engine.SimulationOutcome;
import engine.world.design.api.World;
import engine.world.design.definition.entity.api.EntityDefinition;
import engine.world.design.definition.environment.api.EnvVariablesManager;
import engine.world.design.rule.Rule;

import java.util.List;
import java.util.Map;

public class WorldImpl implements World {

    private Map<String, EntityDefinition> nameToEntityDefinition;
    private EnvVariablesManager envVariablesManager;
    private List<Rule> rules;


// TODO: 10/08/2023 List<Termination> terminationConditions;


    public WorldImpl() {

    }

    @Override
    public EntityDefinition getEntityDefinitionByName() {
        return null;
    }

    @Override
    public EnvVariablesManager getEnvVariables() {
        return null;
    }

    @Override
    public SimulationOutcome runSimulation() {
        return null;
    }

    @Override
    public void setEntities(Map<String, EntityDefinition> entities) {
        nameToEntityDefinition = entities;
    }

    @Override
    public void setEnvVariablesManager(EnvVariablesManager envVariablesManager) {
        this.envVariablesManager = envVariablesManager;
    }

}
