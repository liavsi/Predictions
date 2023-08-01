package engine.world.utils;

public class PropertyExpression implements Expression{

    private String propertyName;

    public PropertyExpression(String PropertyName) {
        this.propertyName = PropertyName;
    }
    @Override
    public String evaluate() {
        return propertyName;
    }
}
