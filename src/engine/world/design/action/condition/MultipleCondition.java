package engine.world.design.action.condition;

import engine.world.design.action.api.AbstractAction;
import engine.world.design.action.api.Action;
import engine.world.design.action.api.ActionType;
import engine.world.design.definition.entity.api.EntityDefinition;
import engine.world.design.execution.context.Context;

import java.util.List;
import java.util.Objects;

public class MultipleCondition extends AbstractCondition{

    private List<Condition> conditions;
    String logical;

    public MultipleCondition(ActionType actionType, EntityDefinition entityDefinition) {// TODO: 15/08/2023
        super(actionType, entityDefinition);
    }

    @Override
    public boolean evaluate() {
        if (Objects.equals(logical, "Or")){
            for(Condition condition: conditions){ // TODO: 15/08/2023
                if(condition.evaluate()){
                    return true;
                }
            }
            return false;
        }
        else if(Objects.equals(logical,"And")){
            for(Condition condition: conditions){ // TODO: 15/08/2023
                if(!condition.evaluate()){
                    return false;
                }
            }
            return true;
        }
        else {
            throw new RuntimeException("invalid logical sign");
        }
    }
}