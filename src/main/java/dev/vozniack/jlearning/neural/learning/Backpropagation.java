package dev.vozniack.jlearning.neural.learning;

import dev.vozniack.jlearning.neural.model.operational.Dataset;
import dev.vozniack.jlearning.neural.model.operational.Record;
import dev.vozniack.jlearning.neural.model.structure.Layer;
import dev.vozniack.jlearning.neural.model.structure.Neuron;
import dev.vozniack.jlearning.neural.structure.Structure;
import dev.vozniack.jlearning.neural.util.CountUtil;
import lombok.Builder;

import java.util.Collections;
import java.util.List;

public class Backpropagation extends Learning {

    public Backpropagation(Integer iterations, Double tolerance, Double factor, Boolean shuffleRecords) {
        super(iterations, tolerance, factor, shuffleRecords);
    }

    @Builder
    public static Backpropagation buildLearning(Integer iterations, Double tolerance, Double factor, Boolean shuffleRecords) {
        return new Backpropagation(iterations, tolerance, factor, shuffleRecords);
    }

    @Override
    public void learn(Dataset dataset) {
        Structure structure = neuralNetwork.getStructure();

        iteration = 1;

        while (learningConditions()) {
            List<Record> records = dataset.getRecords();

            if (shuffleRecords) {
                Collections.shuffle(records);
            }

            records.forEach(record -> {
                neuralNetwork.getLauncher().launch(record.getInputValues());

                countError(structure, record.getCorrectOutput());
                propagateError(structure);
            });

            iteration++;
        }
    }

    private Boolean learningConditions() {
        return iteration <= iterations;
    }

    private void countError(Structure structure, List<Double> correctOutput) {
        List<Neuron> neurons = structure.getLayers().getLast().getNeurons();

        for (int i = 0; i < neurons.size(); i++) {
            neurons.get(i).setError(CountUtil.countError(neurons.get(i), correctOutput.get(i)));
            neurons.get(i).setErrorSignal(CountUtil.countOutputErrorSignal(neurons.get(i), correctOutput.get(i)));
        }
    }

    private void propagateError(Structure structure) {
        List<Layer> layers = structure.getLayers();

        for (int i = layers.size() - 2; i >= 0; i--) {
            layers.get(i).getNeurons().forEach(neuron -> neuron.setErrorSignal(CountUtil.countHiddenErrorSignal(neuron)));
        }
    }
}
