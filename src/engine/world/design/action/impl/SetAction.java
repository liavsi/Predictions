package engine.world.design.action.impl;

import engine.world.design.action.api.AbstractAction;
import engine.world.design.action.api.ActionType;
import engine.world.design.definition.entity.api.EntityDefinition;
import engine.world.design.definition.property.api.PropertyType;
import engine.world.design.execution.context.Context;
import engine.world.design.execution.property.PropertyInstance;
import engine.world.utils.Expression;

public class SetAction extends AbstractAction {

    private String property;
    private String value;
    protected SetAction(EntityDefinition entityDefinition, String property, String value) {
        super(ActionType.SET, entityDefinition);
        this.property = property;
        this.value = value;
    }

    @Override
    public void invoke(Context context) {
        PropertyInstance propertyInstance = context.getPrimaryEntityInstance().getPropertyByName(property);
        if(PropertyType.FLOAT ==propertyInstance.getPropertyDefinition().getType()) {
//            Expression.FLOAT.evaluate(value);
        }


        //Object res = Expression.evaluate(value)
        // TODO: 11/08/2023 evaluate the expression
        Object result = value;
        // updating result on the property
        propertyInstance.updateValue(result);

    }
}
