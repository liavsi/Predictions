package engine.world.rule;

import engine.world.rule.Condition.Activation;
import engine.world.rule.action.Actionable;
import schema.generated.PRDRule;

import java.util.List;

public class Rule {
    private String name;
    private Activation activateCondition;
    private int actionsCount;
    List<Actionable> actions;

    public Rule(PRDRule prdRule)
    {
        name = prdRule.getName();
        activateCondition = new Activation(prdRule.getPRDActivation());

    }
}
