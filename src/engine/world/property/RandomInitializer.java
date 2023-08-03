package engine.world.property;

public class RandomInitializer {

    private boolean isRandomInitialized = false; //default value
    private Object value; // TODO: 03/08/2023 or string(?)

    public RandomInitializer(boolean isRandomInitialized, String value){
        this.isRandomInitialized = isRandomInitialized;
        this.value = value;
    }
    @Override
    public String toString() {
        String s = "\nIs Random Initialized: " + isRandomInitialized;
        if(!isRandomInitialized)
            s += value.toString();
        return s;
    }
}
