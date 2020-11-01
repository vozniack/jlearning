package dev.vozniack.jlearning.neural.model.structure;

import dev.vozniack.jlearning.neural.types.ActivationFunction;
import lombok.Data;

import java.util.List;

@Data
public class Layer {

    public Layer(List<Neuron> neurons, ActivationFunction activationFunction) {
        this.neurons = neurons;
        this.activationFunction = activationFunction;
    }

    private List<Neuron> neurons;

    private ActivationFunction activationFunction;
}
