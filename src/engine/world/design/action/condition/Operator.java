package engine.world.design.action.condition;

import engine.world.design.action.api.Action;
import engine.world.design.execution.property.PropertyInstance;

public enum Operator {
    EQUAL{
        @Override
        public boolean runOperator(PropertyInstance propertyInstance, String value) {
            if(propertyInstance.getValue() == propertyInstance.getPropertyDefinition().getType().convert(value)){
                return true;
            }
            else {
                return false;
            }
        }
    },DIFFERENT{
        @Override
        public boolean runOperator(PropertyInstance propertyInstance, String value) {
            if(propertyInstance.getValue() != propertyInstance.getPropertyDefinition().getType().convert(value)){
                return true;
            }
            else {
                return false;
            }
        }
    },BT{
        @Override
        public boolean runOperator(PropertyInstance propertyInstance, String value) {
            if((float) propertyInstance.getValue() > (float) propertyInstance.getPropertyDefinition().getType().convert(value)){
                return true;
            }
            else {
                return false;
            }
        }
    }, LT{
        @Override
        public boolean runOperator(PropertyInstance propertyInstance, String value) {
            if((float) propertyInstance.getValue() < (float) propertyInstance.getPropertyDefinition().getType().convert(value)){
                return true;
            }
            else {
                return false;
            }
        }
    };

    public abstract boolean runOperator(PropertyInstance propertyInstance,String value);
}
