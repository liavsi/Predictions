package engine.world.design.api;

import engine.SimulationOutcome;
import engine.world.design.definition.entity.api.EntityDefinition;
import engine.world.design.definition.environment.api.EnvVariablesManager;

public interface World {


    EntityDefinition getEntityDefinitionByName();
    EnvVariablesManager getEnvVariables();
    SimulationOutcome runSimulation();
}
