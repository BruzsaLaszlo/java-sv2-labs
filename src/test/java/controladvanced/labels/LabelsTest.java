package controladvanced.labels;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LabelsTest {

    @Test
    void getTableOfNumbers() {

        Labels labels = new Labels();

        assertEquals(0,labels.getTableOfNumbers(10)[5][0]);
        assertEquals(0,labels.getTableOfNumbers(10)[5][5]);

        assertEquals(0,labels.getTableOfNumbers(10)[0][7]);
        assertEquals(0,labels.getTableOfNumbers(10)[8][7]);

    }
}