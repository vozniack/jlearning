package dev.vozniack.jlearning.neural.util;

import java.util.concurrent.ThreadLocalRandom;

public class RandUtil {

    public static Double randomWeight() {
        return ThreadLocalRandom.current().nextDouble(-1d, 1d);
    }
}
