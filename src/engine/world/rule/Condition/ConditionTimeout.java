package engine.world.rule.Condition;

public class ConditionTimeout implements Condition{

    private final int secondsToEnd;
    private long realTime;
    private final long startTime;

    public ConditionTimeout(int seconds)
    {
        secondsToEnd = seconds;
        realTime = System.currentTimeMillis()/1000;
        startTime = System.currentTimeMillis()/1000;
    }
    @Override
    public boolean isConditionTrue() {
        return (realTime - startTime > secondsToEnd);
    }
    public void updateRealTime() {
        realTime = System.currentTimeMillis()/1000;
    }
}
