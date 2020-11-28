package dev.vozniack.jlearning.genetic.util;

import java.util.concurrent.ThreadLocalRandom;

public class RandUtil {

    public static int randomBit() {
        return ThreadLocalRandom.current().nextInt(0, 100) > 50 ? 1 : 0;
    }

    public static double randomChance() {
        return ThreadLocalRandom.current().nextDouble(0d, 1d);
    }

    public static int randomIndex(int bound) {
        return ThreadLocalRandom.current().nextInt(bound);
    }
}
