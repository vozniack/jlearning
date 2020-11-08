package dev.vozniack.jlearning.neural.validator;

import dev.vozniack.jlearning.neural.learning.Learning;
import dev.vozniack.jlearning.neural.model.operational.Dataset;
import dev.vozniack.jlearning.neural.network.NeuralNetwork;
import dev.vozniack.jlearning.neural.structure.Structure;

import java.util.List;

public abstract class Validator {

    public abstract void validateStructure(Structure structure);

    public abstract void validateLearning(Learning learning);

    public abstract void validateDataset(NeuralNetwork neuralNetwork, Dataset dataset);

    public abstract void validateInput(NeuralNetwork neuralNetwork, List<Double> input);
}
