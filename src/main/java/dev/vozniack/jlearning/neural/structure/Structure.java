package dev.vozniack.jlearning.neural.structure;

import dev.vozniack.jlearning.neural.exception.StructureException;
import dev.vozniack.jlearning.neural.model.structure.Connection;
import dev.vozniack.jlearning.neural.model.structure.Layer;
import dev.vozniack.jlearning.neural.structure.feedforward.FeedforwardStructure;
import dev.vozniack.jlearning.neural.structure.recursive.RecursiveStructure;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
public abstract class Structure {

    public Structure(Boolean bias) {
        this.bias = bias;
        this.layers = new LinkedList<>();
        this.connections = new ArrayList<>();
    }

    /* Factory */

    public static Structure create(StructureType structureType, Boolean bias, Integer... neurons) {
        switch (structureType) {
            case FEEDFORWARD:
                return new FeedforwardStructure(bias, neurons);

            case RECURSIVE:
                return new RecursiveStructure(bias, neurons);

            default:
                throw new StructureException("How did you throw it?");
        }
    }

    /* Variables */

    protected Boolean bias;

    protected LinkedList<Layer> layers;

    protected List<Connection> connections;

    /* To implement */

    public abstract void addLayer(Integer neurons);

    public abstract void addHiddenLayer(Integer neurons);

    public abstract void createConnections();

    /* Initialization */

    public void initConnections(List<Double> weights) {
        if (connections.size() != weights.size()) {
            throw new StructureException("Number of connections is different than number of new weights");
        } else {
            for (int i = 0; i < connections.size(); i++) {
                connections.get(i).setWeight(weights.get(i));
            }
        }
    }
}
