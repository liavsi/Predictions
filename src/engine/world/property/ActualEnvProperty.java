package engine.world.property;

public class ActualEnvProperty {

    private EnvironmentProperty environmentProperty;
    private Object value;

    public void setActualEnvProperty(EnvironmentProperty environmentProperty,Object value) {
        this.environmentProperty = environmentProperty;
        if(value == null){
            value = environmentProperty.type.randomValue(environmentProperty.restrictions);
        }
        else{
            this.value = value;
        }
    }
}
