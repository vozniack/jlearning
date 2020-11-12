package dev.vozniack.jlearning.neural.network;

import dev.vozniack.jlearning.neural.launcher.FeedforwardLauncher;
import dev.vozniack.jlearning.neural.learning.Learning;
import dev.vozniack.jlearning.neural.model.operational.Dataset;
import dev.vozniack.jlearning.neural.model.structure.Neuron;
import dev.vozniack.jlearning.neural.structure.Structure;
import dev.vozniack.jlearning.neural.util.RandUtil;
import dev.vozniack.jlearning.neural.validator.FeedforwardValidator;
import lombok.Builder;

import java.util.List;
import java.util.stream.Collectors;

public class FeedforwardNeuralNetwork extends NeuralNetwork {

    public FeedforwardNeuralNetwork(Structure structure, Learning learning) {
        super(structure, learning, new FeedforwardValidator(), new FeedforwardLauncher());

        if (this.learning != null) {
            this.learning.setNeuralNetwork(this);
        }

        this.launcher.setNeuralNetwork(this);
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
        learning.learn(dataset);
    }

    @Override
    public void launch(List<Double> input) {
        validate(input);
        launcher.launch(input);
    }

    @Override
    public List<Double> getOutput() {
        return structure.getLayers().getLast().getNeurons().stream().map(Neuron::getOutput).collect(Collectors.toList());
    }
}
