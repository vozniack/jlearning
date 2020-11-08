package dev.vozniack.jlearning.neural.model.structure;

import dev.vozniack.jlearning.neural.types.ActivationFunction;
import lombok.Getter;

import java.util.List;

@Getter
public class Layer {

    public Layer(List<Neuron> neurons, ActivationFunction activationFunction) {
        this.neurons = neurons;
        this.activationFunction = activationFunction;
    }

    private final List<Neuron> neurons;

    private final ActivationFunction activationFunction;

    public Integer size() {
        return neurons.size();
    }
}
