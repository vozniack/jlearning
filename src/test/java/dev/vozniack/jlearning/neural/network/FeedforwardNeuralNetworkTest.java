package dev.vozniack.jlearning.neural.network;

import dev.vozniack.jlearning.neural.learning.Learning;
import dev.vozniack.jlearning.neural.learning.LearningType;
import dev.vozniack.jlearning.neural.model.operational.Dataset;
import dev.vozniack.jlearning.neural.structure.Structure;
import dev.vozniack.jlearning.neural.structure.StructureType;
import dev.vozniack.jlearning.neural.util.DatasetUtil;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FeedforwardNeuralNetworkTest {
    private final static String FILENAME = "src/test/resources/jLearning.csv";

    @Test
    public void initNeuralNetworkTest() {
        NeuralNetwork neuralNetwork = FeedforwardNeuralNetwork.builder()
                .structure(Structure.create(StructureType.FEEDFORWARD, true, 4, 12, 8))
                .learning(Learning.create(LearningType.BACKPROPAGATION, 1024, 0.1, 1.0, false))
                .build();

        neuralNetwork.init();

        assertNotNull(neuralNetwork);
    }

    @Test
    public void learnNeuralNetworkTest() throws IOException {
        NeuralNetwork neuralNetwork = FeedforwardNeuralNetwork.builder()
                .structure(Structure.create(StructureType.FEEDFORWARD, true, 2, 4))
                .learning(Learning.create(LearningType.BACKPROPAGATION, 128, 0.1, 1.0, true))
                .build();

        neuralNetwork.init();

        Dataset dataset = DatasetUtil.create(new File(FILENAME), ";");

        neuralNetwork.learn(dataset);
    }

    @Test
    public void launchNeuralNetworkTest() {
        NeuralNetwork neuralNetwork = FeedforwardNeuralNetwork.builder()
                .structure(Structure.create(StructureType.FEEDFORWARD, false, 4, 2))
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
