package engine.world.rule.action;

import engine.world.HasProperties;
import engine.world.property.Property;
import engine.world.utils.NumericExpression;

import java.util.Map;

public enum ActionType implements Action{
    INCREASE{
        @Override
        public void ExecuteAction() {
            Float by = new NumericExpression(arguments.get("by")).evaluate();
            Property property = mainEntity.getPropertyByName(arguments.get("property"));
        }
    };
//    DECREASE {
//
//    },
//    CALCULATION {
//
//    },
//    CONDITION {
//
//    },
//    SET {
//
//    },
//    KILL {
//
//    },
//    REPLACE{
////         EXE 2
//    },
//    PROXIMITY {
////        EXE 2
//    };


    protected HasProperties mainEntity;
    protected Map<String, String> arguments;


}
