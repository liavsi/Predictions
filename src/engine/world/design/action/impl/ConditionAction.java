package engine.world.design.action.impl;

import engine.world.design.action.api.AbstractAction;
import engine.world.design.action.api.ActionType;
import engine.world.design.definition.entity.api.EntityDefinition;
import engine.world.design.execution.context.Context;
import engine.world.rule.Condition.Condition;

import java.util.List;

public class ConditionAction extends AbstractAction {

//    List<Condition>

    // TODO: 10/08/2023 to implement the class needs to build a system that figure that out..
    protected ConditionAction( EntityDefinition entityDefinition) {
        super(ActionType.CONDITION, entityDefinition);
    }

    @Override
    public void invoke(Context context) {
        
    }
}
