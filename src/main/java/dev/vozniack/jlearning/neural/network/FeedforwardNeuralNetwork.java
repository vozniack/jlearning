package dev.vozniack.jlearning.neural.network;

import dev.vozniack.jlearning.neural.learning.Learning;
import dev.vozniack.jlearning.neural.model.operational.Dataset;
import dev.vozniack.jlearning.neural.model.operational.Output;
import dev.vozniack.jlearning.neural.structure.Structure;
import dev.vozniack.jlearning.neural.validator.FeedforwardValidator;
import lombok.Builder;

public class FeedforwardNeuralNetwork extends NeuralNetwork {

    public FeedforwardNeuralNetwork(Structure structure, Learning learning, Dataset dataset) {
        super(structure, learning, dataset, new FeedforwardValidator());
    }

    @Builder
    public static FeedforwardNeuralNetwork buildNetwork(Structure structure, Learning learning, Dataset dataset) {
        return new FeedforwardNeuralNetwork(structure, learning, dataset);
    }

    @Override
    public void init() {
    }

    @Override
    public void run() {
    }

    @Override
    public void learn() {
    }

    @Override
    public Output getOutput() {
        return null;
    }
}