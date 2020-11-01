package dev.vozniack.jlearning.neural.structure.feedforward;

import dev.vozniack.jlearning.neural.structure.Structure;

import java.util.Arrays;

public class FeedforwardStructure extends Structure {

    public FeedforwardStructure(Boolean bias, Integer... neurons) {
        super(bias);

        Arrays.stream(neurons).forEach(this::addLayer);
        createConnections();
    }

    @Override
    public void addLayer(Integer neurons) {
        FeedforwardStructureUtil.createLayer(this, neurons);
    }

    @Override
    public void addHiddenLayer(Integer neurons) {
        FeedforwardStructureUtil.createHiddenLayer(this, neurons);
    }

    @Override
    public void createConnections() {
        FeedforwardStructureUtil.createConnections(this);
    }
}
