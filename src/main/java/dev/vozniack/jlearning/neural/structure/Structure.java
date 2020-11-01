package dev.vozniack.jlearning.neural.structure;

import dev.vozniack.jlearning.neural.model.structure.Connection;
import dev.vozniack.jlearning.neural.model.structure.Layer;
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

    protected Boolean bias;

    protected LinkedList<Layer> layers;

    protected List<Connection> connections;

    public abstract void addLayer(Integer neurons);

    public abstract void addHiddenLayer(Integer neurons);

    public abstract void createConnections();
}
