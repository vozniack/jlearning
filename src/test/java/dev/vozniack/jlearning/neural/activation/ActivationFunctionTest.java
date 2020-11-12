package dev.vozniack.jlearning.neural.activation;

import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActivationFunctionTest {

    @Test
    public void binaryActivationTest() {
        assertEquals(Double.valueOf(1d), ActivationFunction.BINARY.activate(2d));
        assertEquals(Double.valueOf(1d), ActivationFunction.BINARY.activate(0.01d));
        assertEquals(Double.valueOf(1d), ActivationFunction.BINARY.activate(0d));
        assertEquals(Double.valueOf(0d), ActivationFunction.BINARY.activate(-0.01d));
        assertEquals(Double.valueOf(0d), ActivationFunction.BINARY.activate(-0.5d));
    }

    @Test
    public void sigmoidActivationTest() {
        Activation activation = new SigmoidActivation();

        DecimalFormat decimalFormat = new DecimalFormat("#.#####");

        assertEquals(decimalFormat.format(Double.valueOf(0.99995)), decimalFormat.format(ActivationFunction.SIGMOID.activate(10d)));
        assertEquals(decimalFormat.format(Double.valueOf(0.73106)), decimalFormat.format(ActivationFunction.SIGMOID.activate(1d)));
        assertEquals(decimalFormat.format(Double.valueOf(0.62246)), decimalFormat.format(ActivationFunction.SIGMOID.activate(0.5d)));
        assertEquals(decimalFormat.format(Double.valueOf(0.37754)), decimalFormat.format(ActivationFunction.SIGMOID.activate(-0.5d)));
        assertEquals(decimalFormat.format(Double.valueOf(0.26894)), decimalFormat.format(ActivationFunction.SIGMOID.activate(-1d)));
        assertEquals(decimalFormat.format(Double.valueOf(0.00005)), decimalFormat.format(ActivationFunction.SIGMOID.activate(-10d)));
    }
}
