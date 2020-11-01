package dev.vozniack.jlearning.neural.structure;

import dev.vozniack.jlearning.neural.model.structure.Connection;
import dev.vozniack.jlearning.neural.model.structure.Layer;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public abstract class Structure {

    public Structure(Boolean bias) {
        this.bias = bias;
        this.layers = new ArrayList<>();
        this.connections = new ArrayList<>();
    }

    protected Boolean bias;

    protected List<Layer> layers;

    protected List<Connection> connections;

    public abstract void addLayer(Integer neurons, Boolean isHidden);

    public abstract void createConnections();
}
