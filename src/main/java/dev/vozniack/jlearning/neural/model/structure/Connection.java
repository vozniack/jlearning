package dev.vozniack.jlearning.neural.model.structure;

import dev.vozniack.jlearning.neural.util.RandUtil;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Connection {

    public Connection(Neuron input, Neuron output) {
        this.weight = RandUtil.randomWeight();
        this.input = input;
        this.output = output;
    }

    private Double weight;

    private Neuron input;

    private Neuron output;
}
