package dev.vozniack.jlearning.neural.network;

import dev.vozniack.jlearning.neural.learning.LearningFactory;
import dev.vozniack.jlearning.neural.structure.StructureFactory;
import dev.vozniack.jlearning.neural.types.LearningType;
import dev.vozniack.jlearning.neural.types.StructureType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FeedforwardNeuralNetworkTest {

    @Test
    public void initNeuralNetwork() {
        NeuralNetwork neuralNetwork = FeedforwardNeuralNetwork.builder()
                .structure(StructureFactory.createStructure(StructureType.FEEDFORWARD, true, 4, 12, 8))
                .learning(LearningFactory.createLearning(LearningType.BACKPROPAGATION, 1024, 0.1, 1.0))
                .build();

        neuralNetwork.init();

        assertNotNull(neuralNetwork);
    }
}
