package dev.vozniack.jlearning.neural.network;

import dev.vozniack.jlearning.neural.learning.Learning;
import dev.vozniack.jlearning.neural.model.operational.Dataset;
import dev.vozniack.jlearning.neural.model.operational.Output;
import dev.vozniack.jlearning.neural.structure.Structure;
import dev.vozniack.jlearning.neural.util.RandUtil;
import dev.vozniack.jlearning.neural.validator.FeedforwardValidator;
import lombok.Builder;

import java.util.List;

public class FeedforwardNeuralNetwork extends NeuralNetwork {

    public FeedforwardNeuralNetwork(Structure structure, Learning learning) {
        super(structure, learning, new FeedforwardValidator());
    }

    @Builder
    public static FeedforwardNeuralNetwork buildNetwork(Structure structure, Learning learning) {
        return new FeedforwardNeuralNetwork(structure, learning);
    }

    @Override
    public void init() {
        structure.getConnections().forEach(connection -> connection.setWeight(RandUtil.randomWeight()));
    }

    @Override
    public void learn(Dataset dataset) {
        validate(dataset);
    }

    @Override
    public List<Double> run(List<Double> input) {
        validate(input);

        return null;
    }

    @Override
    public Output getOutput() {
        return null;
    }
}
