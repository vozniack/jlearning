package dev.vozniack.jlearning.genetic.util;

import java.util.concurrent.ThreadLocalRandom;

public class RandUtil {

    public static int randomBit() {
        return ThreadLocalRandom.current().nextInt(0, 100) > 50 ? 1 : 0;
    }
}
