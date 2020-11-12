package dev.vozniack.jlearning.neural.network;

import dev.vozniack.jlearning.neural.learning.LearningFactory;
import dev.vozniack.jlearning.neural.learning.LearningType;
import dev.vozniack.jlearning.neural.model.operational.Dataset;
import dev.vozniack.jlearning.neural.model.operational.Record;
import dev.vozniack.jlearning.neural.structure.StructureFactory;
import dev.vozniack.jlearning.neural.structure.StructureType;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FeedforwardNeuralNetworkTest {

    @Test
    public void initNeuralNetworkTest() {
        NeuralNetwork neuralNetwork = FeedforwardNeuralNetwork.builder()
                .structure(StructureFactory.createStructure(StructureType.FEEDFORWARD, true, 4, 12, 8))
                .learning(LearningFactory.createLearning(LearningType.BACKPROPAGATION, 1024, 0.1, 1.0, false))
                .build();

        neuralNetwork.init();

        assertNotNull(neuralNetwork);
    }

    @Test
    public void learnNeuralNetworkTest() {
        NeuralNetwork neuralNetwork = FeedforwardNeuralNetwork.builder()
                .structure(StructureFactory.createStructure(StructureType.FEEDFORWARD, true, 4, 2))
                .learning(LearningFactory.createLearning(LearningType.BACKPROPAGATION, 128, 0.1, 1.0, true))
                .build();

        neuralNetwork.init();

        Dataset dataset = Dataset.builder()
                .inputs(4)
                .outputs(2)
                .records(List.of(Record.builder()
                        .inputValues(List.of(1d, 2d, 3d, 4d))
                        .correctOutput(List.of(1d, 2d))
                        .build()))
                .build();

        neuralNetwork.learn(dataset);

        // #todo prepare real data for test
    }

    @Test
    public void launchNeuralNetworkTest() {
        NeuralNetwork neuralNetwork = FeedforwardNeuralNetwork.builder()
                .structure(StructureFactory.createStructure(StructureType.FEEDFORWARD, false, 4, 2))
                .build();

        neuralNetwork.init();

        neuralNetwork.getStructure().initConnections(List.of(0.25d, 0.75d, -0.25d, 1d, -0.5d, 0.5d, -0.75d, 1d));
        neuralNetwork.launch(List.of(1d, 2d, -1.5d, 0.75d));
        List<Double> output = neuralNetwork.getOutput();

        DecimalFormat decimalFormat = new DecimalFormat("#.#####");

        assertEquals(decimalFormat.format(Double.valueOf(0.48438)), decimalFormat.format(output.get(0)));
        assertEquals(decimalFormat.format(Double.valueOf(0.93991)), decimalFormat.format(output.get(1)));

        assertEquals(8, neuralNetwork.getStructure().getConnections().size());
    }
}
