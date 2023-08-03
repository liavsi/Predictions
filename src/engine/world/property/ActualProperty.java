package engine.world.property;

import engine.world.rule.action.ActionType;

public class ActualProperty {

    private Property propertyDetails;
    private Object value;

    public String getName() {
        return propertyDetails.getName();
    }
    public void increaseValue(Float num){
        Float temp;
        Type propertyType = propertyDetails.getType();
        if (Type.FLOAT == propertyType || Type.DECIMAL == propertyType){
            temp = (Float) value + num;
            value = temp;
        }
        else{
            throw new RuntimeException("trying to increase not a numeric value");
        }
    }
    public void decreaseValue(Float num){
        Float temp;
        if (Type.FLOAT == propertyDetails.getType() || Type.DECIMAL == propertyDetails.getType()){
            temp = (Float) value - num;
            value = temp;
        }
        else{
            throw new RuntimeException("trying to decrease not a numeric value");
        }
    }
}
