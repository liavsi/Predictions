package engine.world.rule.action;

import engine.world.entity.Entity;

public abstract class Action {
    protected Entity mainEntity;
    protected ActionType actionType;


//    public Action(Entity mainEntity,ActionType actionType) {
//        this.mainEntity = mainEntity;
//        this.actionType = actionType;
//    }
    public abstract void executeAction();
}
