package engine.world;

import engine.world.property.Property;
import engine.world.utils.Expression;

public interface EnvironmentWorld {

    public Property getEnvironmentVarByName(Expression envName);
}
