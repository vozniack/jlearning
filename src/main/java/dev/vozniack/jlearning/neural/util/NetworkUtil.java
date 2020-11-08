package dev.vozniack.jlearning.neural.util;

import dev.vozniack.jlearning.neural.model.structure.Layer;
import dev.vozniack.jlearning.neural.model.structure.Neuron;
import dev.vozniack.jlearning.neural.structure.Structure;

import java.util.List;

public class NetworkUtil {

    public static void initInput(Structure structure, List<Double> values) {
        List<Neuron> neurons = structure.getLayers().getFirst().getNeurons();

        for (int i = 0; i < neurons.size(); i++) {
            neurons.get(i).setOutput(values.get(i));
        }
    }

    public static void countOutputs(Structure structure) {
        List<Layer> layers = structure.getLayers();

        for (int i = 1; i < layers.size(); i++) {
            Layer layer = layers.get(i);

            layer.getNeurons().forEach(neuron -> neuron.setOutput(layer.getActivationFunction()
                    .activate(neuron.getInputs().stream().mapToDouble(CountUtil::countNet).sum())));
        }
    }
}
