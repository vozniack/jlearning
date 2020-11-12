package dev.vozniack.jlearning.neural.activation;

public enum ActivationFunction {
    BINARY(new BinaryActivation()),
    SIGMOID(new SigmoidActivation());

    private final Activation activation;

    ActivationFunction(Activation activation) {
        this.activation = activation;
    }

    public Double activate(Double value) {
        return activation.activate(value);
    }
}
