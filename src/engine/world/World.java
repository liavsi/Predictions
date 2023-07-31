package engine.world;

import engine.world.entity.Entity;
import engine.world.property.Property;
import engine.world.rule.Rule;

import java.util.Collection;

public class World {
    Collection<Entity> entities;
    Collection<Rule> rules;
    Collection<Property> environmentVars;
}