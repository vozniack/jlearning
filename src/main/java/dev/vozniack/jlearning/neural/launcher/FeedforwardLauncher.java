package dev.vozniack.jlearning.neural.launcher;

import dev.vozniack.jlearning.neural.model.structure.Layer;
import dev.vozniack.jlearning.neural.model.structure.Neuron;
import dev.vozniack.jlearning.neural.network.NeuralNetwork;
import dev.vozniack.jlearning.neural.util.CountUtil;
import lombok.Setter;

import java.util.List;

@Setter
public class FeedforwardLauncher implements Launcher {
    private NeuralNetwork neuralNetwork;

    @Override
    public void launch(List<Double> input) {
        initInput(input);
        countOutputs();
    }

    private void initInput(List<Double> input) {
        List<Neuron> neurons = neuralNetwork.getStructure().getLayers().getFirst().getNeurons();

        for (int i = 0; i < neurons.size(); i++) {
            neurons.get(i).setOutput(input.get(i));
        }
    }

    private void countOutputs() {
        List<Layer> layers = neuralNetwork.getStructure().getLayers();

        for (int i = 1; i < layers.size(); i++) {
            Layer layer = layers.get(i);

            layer.getNeurons().forEach(neuron -> neuron.setOutput(layer.getActivationFunction()
                    .activate(neuron.getInputs().stream().mapToDouble(CountUtil::countNet).sum())));
        }
    }
}
