package engine.world.design.action.condition;

import engine.world.design.action.api.AbstractAction;
import engine.world.design.action.api.Action;
import engine.world.design.action.api.ActionType;
import engine.world.design.definition.entity.api.EntityDefinition;
import engine.world.design.execution.context.Context;
import engine.world.design.execution.entity.impl.EntityInstanceImpl;
import engine.world.design.execution.property.PropertyInstance;

import java.util.List;

public class SingleCondition extends AbstractCondition{

    private EntityInstanceImpl entityInstance;
    private String property;
    private Operator operaton1;
    private String operator;
    private String value;
    private List<Action> thanActions;
    private List<Action> elseActions;

    protected SingleCondition(ActionType actionType, EntityDefinition entityDefinition, EntityInstanceImpl entityInstance) {// TODO: 15/08/2023
        super(actionType, entityDefinition);
        this.entityInstance = entityInstance;
    }

    @Override
    public boolean evaluate() {
        PropertyInstance propertyInstance =  entityInstance.getPropertyByName(property);
        return operaton1.runOperator(propertyInstance,value);
//        switch (operator){
//            case ("="):{
//               if(propertyInstance.getValue() == propertyInstance.getPropertyDefinition().getType().convert(value)){
//                   return true;
//               }
//               else {
//                   return false;
//               }
//            }
//            case("!="):{
//                if(propertyInstance.getValue() != propertyInstance.getPropertyDefinition().getType().convert(value)){
//                    return true;
//                }
//                else {
//                    return false;
//                }
//            }
//            case("Bt"):{
//                if(verifyNumericPropertyTYpe(propertyInstance)){
//                    if((float) propertyInstance.getValue() > (float) propertyInstance.getPropertyDefinition().getType().convert(value)){
//                        return true;
//                    }
//                    else {
//                        return false;
//                    }
//                }
//                else {
//                    throw new RuntimeException("Bt can't be done on non numeric values");
//                }
//            }
//            case ("Lt"):{
//                if(verifyNumericPropertyTYpe(propertyInstance)){
//                    if((float) propertyInstance.getValue() < (float) propertyInstance.getPropertyDefinition().getType().convert(value)){
//                        return true;
//                    }
//                    else {
//                        return false;
//                    }
//                }
//                else{
//                    throw new RuntimeException("Lt can't be done on non numeric values");
//                }
//            }
//            default:{
//                throw new RuntimeException("Invalid operator");
//            }
//        }
    }

}
