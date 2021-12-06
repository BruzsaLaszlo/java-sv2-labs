package statemachine.typewriter;

public enum TypeWriterState {

    UPPERCASE{
        @Override
        TypeWriterState nextLine() {
            return TypeWriterState.LOWERCASE;
        }
    },

    LOWERCASE {
        @Override
        TypeWriterState nextLine() {
            return TypeWriterState.UPPERCASE;
        }
    };

    abstract TypeWriterState nextLine();

}
