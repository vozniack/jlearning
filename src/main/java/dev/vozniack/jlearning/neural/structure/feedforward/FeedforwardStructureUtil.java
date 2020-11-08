package dev.vozniack.jlearning.neural.structure.feedforward;

import dev.vozniack.jlearning.neural.activation.ActivationFunction;
import dev.vozniack.jlearning.neural.model.structure.Connection;
import dev.vozniack.jlearning.neural.model.structure.Layer;
import dev.vozniack.jlearning.neural.model.structure.Neuron;
import dev.vozniack.jlearning.neural.structure.Structure;
import dev.vozniack.jlearning.neural.types.ActivationType;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FeedforwardStructureUtil {

    /* Layers */

    public static void createLayer(Structure structure, Integer neurons) {
        LinkedList<Layer> layers = structure.getLayers();
        layers.addLast(createLayer(neurons));

        createConnections(structure);
    }

    public static void createHiddenLayer(Structure structure, Integer neurons) {
        LinkedList<Layer> layers = structure.getLayers();

        Layer lastLayer = layers.getLast();
        layers.removeLast();

        layers.addLast(createLayer(neurons));
        layers.addLast(lastLayer);

        createConnections(structure);
    }

    private static Layer createLayer(Integer neurons) {
        return new Layer(IntStream.range(0, neurons).mapToObj(iterator -> new Neuron()).collect(Collectors.toList()), ActivationFunction.get(ActivationType.SIGMOID));
    }

    /* Connections */

    public static void createConnections(Structure structure) {
        clearConnections(structure);

        if (structure.getBias()) {
            createConnectionsWithBias(structure);
        } else {
            createConnectionsWithoutBias(structure);
        }
    }

    private static void clearConnections(Structure structure) {
        LinkedList<Layer> layers = structure.getLayers();

        layers.forEach(layer -> layer.getNeurons().forEach(neuron -> {
            neuron.setInputs(new ArrayList<>());
            neuron.setOutputs(new ArrayList<>());
        }));

        structure.setLayers(layers);
        structure.setConnections(new ArrayList<>());
    }

    private static void createConnectionsWithBias(Structure structure) {
        LinkedList<Layer> layers = structure.getLayers();
        List<Connection> connections = structure.getConnections();

        if (layers.size() > 1) {
            for (int i = 0; i < layers.size() - 2; i++) {
                for (Neuron input : layers.get(i).getNeurons()) {
                    List<Neuron> output = layers.get(i + 1).getNeurons();

                    for (int k = 0; k < output.size() - 1; k++) {
                        connections.add(createConnection(input, output.get(k)));
                    }
                }
            }

            for (Neuron input : layers.get(layers.size() - 2).getNeurons()) {
                for (Neuron output : layers.get(layers.size() - 1).getNeurons()) {
                    connections.add(createConnection(input, output));
                }
            }
        }
    }

    private static void createConnectionsWithoutBias(Structure structure) {
        LinkedList<Layer> layers = structure.getLayers();
        List<Connection> connections = structure.getConnections();

        if (layers.size() > 1) {
            for (int i = 0; i < layers.size() - 1; i++) {
                for (Neuron input : layers.get(i).getNeurons()) {
                    for (Neuron output : layers.get(i + 1).getNeurons()) {
                        connections.add(createConnection(input, output));
                    }
                }
            }
        }
    }

    private static Connection createConnection(Neuron input, Neuron output) {
        Connection connection = new Connection(input, output);

        input.getOutputs().add(connection);
        output.getInputs().add(connection);

        return connection;
    }
}
