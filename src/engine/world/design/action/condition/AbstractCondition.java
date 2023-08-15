package engine.world.design.action.condition;

import engine.world.design.action.api.AbstractAction;
import engine.world.design.action.api.Action;
import engine.world.design.action.api.ActionType;
import engine.world.design.definition.entity.api.EntityDefinition;
import engine.world.design.execution.context.Context;

import java.util.List;

public abstract class AbstractCondition extends AbstractAction implements Condition{

    private List<Action> thanActions;
    private List<Action> elseActions;

    protected AbstractCondition(ActionType actionType, EntityDefinition entityDefinition) {
        super(actionType, entityDefinition);
    }

    @Override
    public void invoke(Context context) {
        if(evaluate()){
            for (Action action: thanActions){ // TODO: 15/08/2023
                action.invoke(context);
            }
        }
        else{
            for (Action action: elseActions){
                action.invoke(context);
            }
        }
    }
}
