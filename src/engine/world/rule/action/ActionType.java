package engine.world.rule.action;

import engine.world.HasProperties;
import engine.world.property.ActualProperty;
import engine.world.property.Property;
import engine.world.utils.NumericExpression;

import java.util.List;
import java.util.Map;

public enum ActionType implements Action{
    INCREASE{
        @Override
        public void ExecuteAction(Map<String,String> arguments) {
            Float by = new NumericExpression(arguments.get("by")).evaluate();
            ActualProperty property = mainEntity.getPropertyByName(arguments.get("property"));
//            property.increaseValue(by);
        }
    };
//    DECREASE {
//        @Override
//        public void ExecuteAction(Map<String,String> arguments) {
//            Float by = new NumericExpression(arguments.get("by")).evaluate();
//            Property property = mainEntity.getPropertyByName(arguments.get("property"));
//        }
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


    public abstract void ExecuteAction(Map<String, String> arguments);
}
