package engine.world.rule.Condition;

public class ConditionTicks implements Condition{

    private int ticksToEnd;
    private int ticksPass;

    public ConditionTicks(int numOfTicks){
        ticksToEnd = numOfTicks;
        ticksPass = 0;
    }
    @Override
    public boolean isConditionTrue() {
        return (ticksPass - ticksToEnd >= 0);
    }


}
