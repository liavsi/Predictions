package engine;

import engine.world.World;
import schema.generated.PRDWorld;

import java.util.List;

public class Engine {
    private World myWorld;

    private List<SimulationOutcome> pastSimulations; // TODO: 03/08/2023 map? 

    public World getWorld() {
        return myWorld;
    }

    public SimulationOutcome createNewSimulation() {
        SimulationOutcome currSimulation = myWorld.runSimulation();
        pastSimulations.add(currSimulation);
        return currSimulation;
    }

    public void loadWorldFromPRDWorld(PRDWorld prdWorld) {

        myWorld.buildWorldFromPRDWorld(prdWorld);
    }
}
