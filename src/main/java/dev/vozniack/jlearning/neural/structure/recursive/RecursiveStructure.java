package dev.vozniack.jlearning.neural.structure.recursive;

import dev.vozniack.jlearning.neural.structure.Structure;

import java.util.Arrays;

public class RecursiveStructure extends Structure {

    public RecursiveStructure(Boolean bias, Integer... neurons) {
        super(bias);

        Arrays.stream(neurons).forEach(this::addLayer);
        createConnections();
    }

    @Override
    public void addLayer(Integer neurons) {
        RecursiveStructureUtil.createLayer(this, neurons);
    }

    @Override
    public void addHiddenLayer(Integer neurons) {
        RecursiveStructureUtil.createHiddenLayer(this, neurons);
    }

    @Override
    public void createConnections() {
        RecursiveStructureUtil.createConnections(this);
    }
}
