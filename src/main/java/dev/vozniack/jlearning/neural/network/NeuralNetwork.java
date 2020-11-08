package dev.vozniack.jlearning.neural.network;

import dev.vozniack.jlearning.neural.learning.Learning;
import dev.vozniack.jlearning.neural.model.operational.Dataset;
import dev.vozniack.jlearning.neural.structure.Structure;
import dev.vozniack.jlearning.neural.validator.Validator;
import lombok.Getter;

import java.util.List;

@Getter
public abstract class NeuralNetwork {

    public NeuralNetwork(Structure structure, Learning learning, Validator validator) {
        this.structure = structure;
        this.learning = learning;
        this.validator = validator;
    }

    protected Structure structure;

    protected Learning learning;

    protected Dataset dataset;

    protected Validator validator;

    /* To implement */

    public abstract void init();

    public abstract void learn(Dataset dataset);

    public abstract List<Double> launch(List<Double> values);

    /* Validation */

    protected void validate(Dataset dataset) {
        validator.validateStructure(structure);
        validator.validateLearning(learning);
        validator.validateDataset(this, dataset);
    }

    protected void validate(List<Double> input) {
        validator.validateStructure(structure);
        validator.validateInput(this, input);
    }
}
