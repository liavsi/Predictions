package engine.world.property;

public enum Type {
    DECIMAL {
        @Override
        public String toString() {
            return "decimal";
        }
    },
    FLOAT {
        @Override
        public String toString() {
            return "float";
        }
    },
    BOOLEAN {
        @Override
        public String toString() {
            return "boolean";
        }
    },
    STRING {
        @Override
        public String toString() {
            return "string";
        }
    };

    public abstract String toString();

}
