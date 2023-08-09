package engine.world.design.definition.value.generator.api;

import engine.world.design.definition.value.generator.fixed.FixedValueGenerator;
import engine.world.design.definition.value.generator.random.impl.bool.RandomBooleanValueGenerator;
import engine.world.design.definition.value.generator.random.impl.numeric.RandomIntegerGenerator;

public interface ValueGeneratorFactory {

    static <T> ValueGenerator<T> createFixed(T value) {
        return new FixedValueGenerator<>(value);
    }

    static ValueGenerator<Boolean> createRandomBoolean() {
        return new RandomBooleanValueGenerator();
    }

    static ValueGenerator<Integer> createRandomInteger(Integer from, Integer to) {
        return new RandomIntegerGenerator(from, to);
    }

}
