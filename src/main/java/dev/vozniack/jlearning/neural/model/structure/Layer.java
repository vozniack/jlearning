package dev.vozniack.jlearning.neural.model.structure;

import dev.vozniack.jlearning.neural.types.ActivationFunction;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Layer {

    public Layer() {
        this.neurons = new ArrayList<>();
    }

    private List<Neuron> neurons;

    private ActivationFunction activationFunction;
}
