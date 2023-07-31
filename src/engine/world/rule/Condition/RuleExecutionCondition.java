package engine.world.rule.Condition;

public class RuleExecutionCondition implements Condition {
    private int ticks = 0;
    private float probability = 1;

    @Override
    public boolean isConditionTrue() {
        return false;
    }
}
