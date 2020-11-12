package dev.vozniack.jlearning.neural.activation;

public class SigmoidActivation implements Activation {

    @Override
    public Double activate(Double value) {
        return 1d / (1d + Math.exp(-value));
    }
}
