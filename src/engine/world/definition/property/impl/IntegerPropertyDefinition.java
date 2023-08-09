package engine.world.definition.property.impl;

import engine.world.definition.property.api.AbstractPropertyDefinition;
import engine.world.definition.value.generator.api.ValueGenerator;
import engine.world.definition.property.api.PropertyType;


public class IntegerPropertyDefinition extends AbstractPropertyDefinition<Integer> {

        public IntegerPropertyDefinition(String name, ValueGenerator<Integer> valueGenerator) {
            super(name, PropertyType.DECIMAL, valueGenerator);
        }

}
