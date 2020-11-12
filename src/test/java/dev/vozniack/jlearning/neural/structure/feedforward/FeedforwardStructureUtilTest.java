package dev.vozniack.jlearning.neural.structure.feedforward;

import dev.vozniack.jlearning.neural.activation.ActivationFunction;
import dev.vozniack.jlearning.neural.model.structure.Layer;
import dev.vozniack.jlearning.neural.model.structure.Neuron;
import dev.vozniack.jlearning.neural.structure.Structure;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FeedforwardStructureUtilTest {

    @Test
    public void createLayerTest() {
        Structure structure = new FeedforwardStructure(true);

        FeedforwardStructureUtil.createLayer(structure, 4);

        assertEquals(1, structure.getLayers().size());
        assertEquals(4, structure.getLayers().get(0).getNeurons().size());

        FeedforwardStructureUtil.createLayer(structure, 8);

        assertEquals(2, structure.getLayers().size());
        assertEquals(8, structure.getLayers().get(1).getNeurons().size());
    }

    @Test
    public void createHiddenLayerTest() {
        Structure structure = new FeedforwardStructure(true);

        FeedforwardStructureUtil.createLayer(structure, 4);
        FeedforwardStructureUtil.createLayer(structure, 8);
        FeedforwardStructureUtil.createHiddenLayer(structure, 12);

        assertEquals(3, structure.getLayers().size());
        assertEquals(12, structure.getLayers().get(1).getNeurons().size());
    }

    @Test
    public void createConnectionsTest() {
        Structure structure = new FeedforwardStructure(false);

        LinkedList<Layer> layers = new LinkedList<>();

        layers.add(new Layer(IntStream.range(0, 4).mapToObj(iterator -> new Neuron()).collect(Collectors.toList()), ActivationFunction.SIGMOID));
        layers.add(new Layer(IntStream.range(0, 8).mapToObj(iterator -> new Neuron()).collect(Collectors.toList()), ActivationFunction.SIGMOID));

        structure.setLayers(layers);
        assertEquals(2, structure.getLayers().size());

        structure.createConnections();

        assertEquals(32, structure.getConnections().size());
        structure.getLayers().get(0).getNeurons().forEach(neuron -> assertEquals(8, neuron.getOutputs().size()));
        structure.getLayers().get(1).getNeurons().forEach(neuron -> assertEquals(4, neuron.getInputs().size()));
    }
}
