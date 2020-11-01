package dev.vozniack.jlearning.neural.network;

import dev.vozniack.jlearning.neural.learning.Learning;
import dev.vozniack.jlearning.neural.model.operational.Dataset;
import dev.vozniack.jlearning.neural.model.operational.Output;
import dev.vozniack.jlearning.neural.structure.Structure;
import dev.vozniack.jlearning.neural.validator.Validator;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class NeuralNetwork {

    protected Structure structure;

    protected Learning learning;

    protected Dataset dataset;

    protected Validator validator;

    public abstract void init();

    public abstract void run();

    public abstract void learn();

    public abstract Output getOutput();
}
