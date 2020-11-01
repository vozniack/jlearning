package dev.vozniack.jlearning.neural.structure;

public class FeedforwardStructure extends Structure {

    public FeedforwardStructure(Boolean bias, Integer... neurons) {
        super(bias);
    }

    @Override
    public void addLayer(Integer neurons, Boolean isHidden) {
    }

    @Override
    public void createConnections() {

    }
}
