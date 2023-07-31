package engine;

import engine.world.entity.Entity;

public class TemporaryInterface {
    public static void main(String[] args) {
        Engine currEngine = new Engine();
        System.out.println(currEngine.getWorld());


        //showSimulationData(currEngine.createNewSimulation());

    }

    private static void showSimulationData(SimulationOutcome newSimulation) {

    }
}
