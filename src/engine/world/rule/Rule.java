package engine.world.rule;

import engine.world.rule.Condition.Condition;
import engine.world.rule.action.Action;

import java.util.List;

public class Rule {
    private String name;
    private Condition executionCondition;
    private int actionsCount;
    List<Action> actions;
}
