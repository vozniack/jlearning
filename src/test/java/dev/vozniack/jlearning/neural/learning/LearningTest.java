package dev.vozniack.jlearning.neural.learning;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LearningTest {

    @Test
    public void createBackpropagationLearningTest() {
        Learning learning = Learning.create(LearningType.BACKPROPAGATION, 1024, 0.1, 1.0, false);

        assertNotNull(learning);

        assertEquals(Integer.valueOf(1024), learning.getIterations());
        assertEquals(Double.valueOf(0.1), learning.getTolerance());
        assertEquals(Double.valueOf(1.0), learning.getFactor());
        assertEquals(Boolean.FALSE, learning.getShuffleRecords());
    }
}
