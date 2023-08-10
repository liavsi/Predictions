package engine.world.design.action.impl;

import engine.world.design.action.api.AbstractAction;
import engine.world.design.action.api.ActionType;
import engine.world.design.definition.entity.api.EntityDefinition;
import engine.world.design.execution.context.Context;

public class ConditionAction extends AbstractAction {
    // TODO: 10/08/2023 to implement the class 
    protected ConditionAction( EntityDefinition entityDefinition) {
        super(ActionType.CONDITION, entityDefinition);
    }

    @Override
    public void invoke(Context context) {
        
    }
}
