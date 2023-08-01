package engine.world.utils;

import engine.world.HasProperties;
import engine.world.property.Property;

import java.util.Random;

public enum EnvironmentFunction implements Expression {

    ENVIRONMENT{
        @Override
        public Property evaluate() {
            Property environmentVariable = null;
            if (argument instanceof PropertyExpression) {
                // TODO: 01/08/2023
                // have to check if this is the right way to write this type of code
                PropertyExpression propertyExpression = (PropertyExpression)argument;
                environmentVariable =  myWorld.getPropertyByName(propertyExpression.evaluate());
            }
            else {
                throw new RuntimeException("not Property Expression delivered");
            }
            return environmentVariable;
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
    protected HasProperties myWorld;
    // EVALUATE{},
    // PRECENT{},
    // TICKS{};

}
