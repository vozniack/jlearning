package dev.vozniack.jlearning.neural.model.structure;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Neuron {

    public Neuron() {
        this.inputs = new ArrayList<>();
        this.outputs = new ArrayList<>();
    }

    private Double output;

    private Double error;

    private Double errorSignal;

    private List<Connection> inputs;

    private List<Connection> outputs;
}
