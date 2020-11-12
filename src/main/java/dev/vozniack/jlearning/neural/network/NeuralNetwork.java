package dev.vozniack.jlearning.neural.network;

import dev.vozniack.jlearning.neural.launcher.Launcher;
import dev.vozniack.jlearning.neural.learning.Learning;
import dev.vozniack.jlearning.neural.model.operational.Dataset;
import dev.vozniack.jlearning.neural.structure.Structure;
import dev.vozniack.jlearning.neural.validator.Validator;
import lombok.Getter;

import java.util.List;

public abstract class NeuralNetwork {

    public NeuralNetwork(Structure structure, Learning learning, Validator validator, Launcher launcher) {
        this.structure = structure;
        this.learning = learning;
        this.validator = validator;
        this.launcher = launcher;
    }

    @Getter
    protected Structure structure;

    @Getter
    protected Learning learning;

    protected Validator validator;

    @Getter
    protected Launcher launcher;

    /* To implement */

    public abstract void init();

    public abstract void learn(Dataset dataset);

    public abstract void launch(List<Double> values);

    public abstract List<Double> getOutput();

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
