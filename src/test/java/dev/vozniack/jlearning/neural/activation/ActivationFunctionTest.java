package dev.vozniack.jlearning.neural.activation;

import dev.vozniack.jlearning.neural.types.ActivationType;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActivationFunctionTest {

    @Test
    public void binaryActivationTest() {
        ActivationFunction activationFunction = ActivationFunction.get(ActivationType.BINARY);

        assertEquals(Double.valueOf(1d), activationFunction.activate(2d));
        assertEquals(Double.valueOf(1d), activationFunction.activate(0.01d));
        assertEquals(Double.valueOf(1d), activationFunction.activate(0d));
        assertEquals(Double.valueOf(0d), activationFunction.activate(-0.01d));
        assertEquals(Double.valueOf(0d), activationFunction.activate(-0.5d));
    }

    @Test
    public void sigmoidActivationTest() {
        ActivationFunction activationFunction = ActivationFunction.get(ActivationType.SIGMOID);

        DecimalFormat decimalFormat = new DecimalFormat("#.#####");

        assertEquals(decimalFormat.format(Double.valueOf(0.99995)), decimalFormat.format(activationFunction.activate(10d)));
        assertEquals(decimalFormat.format(Double.valueOf(0.73106)), decimalFormat.format(activationFunction.activate(1d)));
        assertEquals(decimalFormat.format(Double.valueOf(0.62246)), decimalFormat.format(activationFunction.activate(0.5d)));
        assertEquals(decimalFormat.format(Double.valueOf(0.37754)), decimalFormat.format(activationFunction.activate(-0.5d)));
        assertEquals(decimalFormat.format(Double.valueOf(0.26894)), decimalFormat.format(activationFunction.activate(-1d)));
        assertEquals(decimalFormat.format(Double.valueOf(0.00005)), decimalFormat.format(activationFunction.activate(-10d)));
    }
}
