package engine;

import engine.world.World;
import engine.world.design.reader.api.Reader;
import schema.generated.PRDWorld;

import java.util.List;
import java.util.Map;

public class Engine {

    private Reader myReader;
    private World myWorld;
    private Integer countId = 0;
    private Map<Integer, SimulationOutcome> pastSimulations; // TODO: 03/08/2023 map?

    public World getWorld() {
        return myWorld;
    }

    public SimulationOutcome createNewSimulation() {
        SimulationOutcome currSimulation = myWorld.runSimulation();
        pastSimulations.put(countId++, currSimulation);
        return currSimulation;
    }

    public void loadWorldFromPRDWorld(PRDWorld prdWorld) {

        myReader.readPRDWorld(prdWorld);

    }
}
