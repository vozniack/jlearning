package dev.vozniack.jlearning.neural.activation;

public class BinaryActivation implements Activation {

    @Override
    public Double activate(Double value) {
        return value >= 0 ? 1d : 0d;
    }
}
