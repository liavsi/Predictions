package engine.world.property;

public enum Type {
    INT {
        @Override
        public String toString() {
            return "Int";
        }
    },
    FLOAT {
        @Override
        public String toString() {
            return "Double";
        }
    },
    BOOLEAN {
        @Override
        public String toString() {
            return "Boolean";
        }
    },
    STRING {
        @Override
        public String toString() {
            return "String";
        }
    };

    public abstract String toString();

}
