package engine.world.rule.action;

import engine.world.property.Property;
import engine.world.utils.Expression;

public class ActionDecrease extends Action{
    private Property property;
    private Expression by;


    @Override
    public void executeAction() {
//        mainEntity.findProperty(property) -= by.evaluation();
    }
}
