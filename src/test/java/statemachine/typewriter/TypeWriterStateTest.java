package statemachine.typewriter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TypeWriterStateTest {

    @Test
    void nextLine() {

        Assertions.assertEquals(TypeWriterState.LOWERCASE, TypeWriterState.UPPERCASE.nextLine());
        assertEquals(TypeWriterState.UPPERCASE, TypeWriterState.LOWERCASE.nextLine());

    }
}