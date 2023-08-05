package engine.world.rule;

import engine.world.World;
import engine.world.entity.Entity;
import engine.world.rule.Condition.Activation;
import engine.world.rule.action.Action;
import engine.world.rule.action.Actionable;
import schema.generated.PRDAction;
import schema.generated.PRDActions;
import schema.generated.PRDRule;

import java.util.List;
import java.util.Map;

public class Rule {
    private String name;
    private Activation activateCondition;
    private int actionsCount;
    List<Action> actions;

    public Rule(PRDRule prdRule, World myWorld)
    {
        int count = 0;
        name = prdRule.getName();
        activateCondition = new Activation(prdRule.getPRDActivation());
        for (PRDAction prdAction: prdRule.getPRDActions().getPRDAction()){
            Entity mainEntity = myWorld.getEntityByName(prdAction.getEntity());
            Action action = new Action(prdAction,mainEntity);
            actions.add(action);
            count ++;
        }
        actionsCount = count;
    }
}
