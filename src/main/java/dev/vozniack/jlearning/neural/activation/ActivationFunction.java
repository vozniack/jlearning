package dev.vozniack.jlearning.neural.activation;

import dev.vozniack.jlearning.neural.types.ActivationType;

public abstract class ActivationFunction {

    public static ActivationFunction get(ActivationType activationType) {
        switch (activationType) {
            case BINARY:
                return new BinaryActivation();

            case SIGMOID:
                return new SigmoidActivation();

            default:
                throw new RuntimeException();
        }
    }

    public abstract Double activate(Double value);
}
