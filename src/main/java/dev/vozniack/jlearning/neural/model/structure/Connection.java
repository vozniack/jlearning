package dev.vozniack.jlearning.neural.model.structure;

import lombok.Data;

@Data
public class Connection {

    private Double weight;

    private Neuron input;

    private Neuron output;
}
