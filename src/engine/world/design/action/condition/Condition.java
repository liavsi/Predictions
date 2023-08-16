package engine.world.design.action.condition;

import engine.world.design.action.api.Action;
import engine.world.design.execution.context.Context;

public interface Condition {

    public boolean evaluate(Context context);

}
