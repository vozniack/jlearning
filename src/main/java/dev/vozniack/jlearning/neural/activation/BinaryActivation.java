package dev.vozniack.jlearning.neural.activation;

public class BinaryActivation extends ActivationFunction {

    @Override
    public Double activate(Double value) {
        return value >= 0 ? 1d : 0d;
    }
}
