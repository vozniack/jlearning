package dev.vozniack.jlearning.genetic.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandUtilTest {

    @Test
    public void randomBitTest() {
        for (int i = 0; i < 100; i++) {
            int bit = RandUtil.randomBit();
            assertTrue(bit == 0 || bit == 1);
        }
    }

    @Test
    public void randomChanceTest() {
        for (int i = 0; i < 100; i++) {
            double chance = RandUtil.randomChance();
            assertTrue(chance >= 0d && chance <= 1d);
        }
    }

    @Test
    public void randomIndexTest() {
        for (int i = 0; i < 100; i++) {
            int index = RandUtil.randomIndex(i + 10);
            assertTrue(index >= 0 && index <= (i + 10));
        }
    }
}