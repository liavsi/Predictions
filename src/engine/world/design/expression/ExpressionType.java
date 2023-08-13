package engine.world.design.expression;

import engine.world.design.execution.context.Context;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

public enum ExpressionType {

    FLOAT {
        @Override
        public Float evaluate(String expression, Context context) {
            // first try to find pattern of environment function using String.split if it is get the environment var or the random number
            // else try to read as a number
            return null;
        }
    },
    DECIMAL{
        @Override
        public Integer evaluate(String expression, Context context) {
            // first try to find pattern of environment function using String.split if it is get the environment var or the random number
            // else try to read as a number
            return null;
        }
    }
    // TODO: 13/08/2023 complete this implementation
    ;

    public abstract <T> T evaluate(String expression, Context context);
}
