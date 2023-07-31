package engine;

import engine.world.World;

import java.util.List;

public class Engine {
    private World myWorld;

    private List<SimulationOutcome> pastSimulations;

    public World getWorld() {
        return myWorld;
    }

    public SimulationOutcome createNewSimulation() {
        SimulationOutcome currSimulation = myWorld.runSimulation();
        pastSimulations.add(currSimulation);
        return currSimulation;
    }
}
