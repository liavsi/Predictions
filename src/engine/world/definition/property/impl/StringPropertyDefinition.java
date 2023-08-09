package engine.world.definition.property.impl;

import engine.world.definition.property.api.AbstractPropertyDefinition;
import engine.world.definition.value.generator.api.ValueGenerator;
import engine.world.definition.property.api.PropertyType;

public class StringPropertyDefinition extends AbstractPropertyDefinition<String> {

    public StringPropertyDefinition(String name, ValueGenerator<String> valueGenerator) {
        super(name, PropertyType.STRING, valueGenerator);
    }

}