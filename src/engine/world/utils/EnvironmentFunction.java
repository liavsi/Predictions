package engine.world.utils;

import engine.world.EnvironmentWorld;
import engine.world.World;
import engine.world.property.Property;

import java.util.Random;

public enum EnvironmentFunction implements Expression {

    ENVIRONMENT{
        @Override
        public Property evaluate() {
            return myWorld.getEnvironmentVarByName(argument);
        }
    },
    RANDOM{
        @Override
        public Integer evaluate() {
            // we would like to make a random number from 0 to this argument number - assuming it's a decimal Expression

            Integer maxRangeNumber  = (Integer) argument.evaluate();
            if(maxRangeNumber == null) {
                throw new RuntimeException("Not a valid Number to Random Function");
            }
            Random random = new Random();

            // Generate a random number between 0 (inclusive) and maxRange (exclusive)
            return  random.nextInt(maxRangeNumber);
        }
    };

    protected Expression argument;
    protected EnvironmentWorld myWorld;
    // EVALUATE{},
    // PRECENT{},
    // TICKS{};

}
