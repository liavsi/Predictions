package engine.world.rule;

import engine.world.rule.Condition.Condition;
import engine.world.rule.action.ActionDemo;

import java.util.List;

public class Rule {
    private String name;
    private Condition executionCondition;
    private int actionsCount;
    List<ActionDemo> actionDemos;
}
