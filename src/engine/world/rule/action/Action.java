package engine.world.rule.action;

import engine.world.HasProperties;

import java.util.Map;

public interface Action {
    public void ExecuteAction(Map<String,String> arguments, HasProperties mainEntity);
}
