package dev.vozniack.jlearning.neural.util;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandUtilTest {

    @Test
    public void randomWeightTest() {
        IntStream.range(0, 100).forEach(iteration -> {
            double weight = RandUtil.randomWeight();

            assertTrue(weight <= 1d);
            assertTrue(weight >= -1d);
        });
    }
}
