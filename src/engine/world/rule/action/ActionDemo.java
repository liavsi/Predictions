package engine.world.rule.action;

import engine.world.entity.Entity;

public abstract class ActionDemo {
    protected Entity mainEntity;
    protected ActionType actionType;



    //    public ActionDemo(Entity mainEntity,ActionType actionType) {
//        this.mainEntity = mainEntity;
//        this.actionType = actionType;
//    }
    public abstract void executeAction();
}
