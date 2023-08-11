package engine.world.design.action.impl;

import engine.world.design.action.api.AbstractAction;
import engine.world.design.action.api.ActionType;
import engine.world.design.action.calculation.CalculationType;
import engine.world.design.definition.entity.api.EntityDefinition;
import engine.world.design.execution.context.Context;
import engine.world.design.execution.property.PropertyInstance;

public class CalculationAction extends AbstractAction {

    private CalculationType calculationType;
    private String property;
    private String arg1, arg2;


    protected CalculationAction(EntityDefinition entityDefinition, String property, String arg1, String arg2) {
        super(ActionType.CALCULATION, entityDefinition);
        this.property = property;
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    @Override
    public void invoke(Context context) {
        PropertyInstance propertyInstance = context.getPrimaryEntityInstance().getPropertyByName(property);
        if (!verifyNumericPropertyTYpe(propertyInstance)) {
            throw new IllegalArgumentException("increase action can't operate on a none number property [" + property);
        }

        // TODO: 11/08/2023 res is always null
        Float res = null;
//        Float res = calculationType.evaluate(arg1, arg2);
        propertyInstance.updateValue(res);

    }
}
