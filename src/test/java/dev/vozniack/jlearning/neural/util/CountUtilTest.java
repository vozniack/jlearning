package dev.vozniack.jlearning.neural.util;

import dev.vozniack.jlearning.neural.learning.LearningFactory;
import dev.vozniack.jlearning.neural.model.structure.Connection;
import dev.vozniack.jlearning.neural.model.structure.Neuron;
import dev.vozniack.jlearning.neural.network.FeedforwardNeuralNetwork;
import dev.vozniack.jlearning.neural.network.NeuralNetwork;
import dev.vozniack.jlearning.neural.structure.StructureFactory;
import dev.vozniack.jlearning.neural.types.LearningType;
import dev.vozniack.jlearning.neural.types.StructureType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountUtilTest {

    @Test
    public void countNetTest() {
        Neuron input = new Neuron();
        input.setOutput(1.28d);

        Connection connection = new Connection(input, new Neuron());
        connection.setWeight(2.48d);

        assertEquals(Double.valueOf(3.1744), CountUtil.countNet(connection));
    }

    @Test
    public void countErrorTest() {
        Neuron neuron = new Neuron();
        neuron.setOutput(0.64d);

        Double correctAnswer = 0.48d;

        assertEquals(Double.valueOf(0.02560000000000001), CountUtil.countError(neuron, correctAnswer));
    }

    @Test
    public void countOutputErrorSignalTest() {
        Neuron neuron = new Neuron();
        neuron.setOutput(0.64d);

        Double correctAnswer = 0.48d;

        assertEquals(Double.valueOf(-0.03686400000000001), CountUtil.countOutputErrorSignal(neuron, correctAnswer));
    }

    @Test
    public void countHiddenErrorTest() {
        Neuron neuron = new Neuron();
        neuron.setOutput(0.64d);

        Neuron firstOutput = new Neuron();
        firstOutput.setErrorSignal(1.28d);

        Neuron secondOutput = new Neuron();
        secondOutput.setErrorSignal(-0.64d);

        Connection firstConnection = new Connection(neuron, firstOutput);
        firstConnection.setWeight(0.22d);

        Connection secondConnection = new Connection(neuron, secondOutput);
        secondConnection.setWeight(-1.44d);

        neuron.setOutputs(List.of(firstConnection, secondConnection));

        assertEquals(Double.valueOf(0.27721728), CountUtil.countHiddenErrorSignal(neuron));
    }

    @Test
    public void countWeightTest() {
        NeuralNetwork neuralNetwork = FeedforwardNeuralNetwork.builder()
                .structure(StructureFactory.createStructure(StructureType.FEEDFORWARD, true, 4, 12, 8))
                .learning(LearningFactory.createLearning(LearningType.BACKPROPAGATION, 1024, 0.1, 0.34d))
                .build();

        Neuron input = new Neuron();
        input.setOutput(1.28d);

        Neuron output = new Neuron();
        output.setErrorSignal(-0.32d);

        Connection connection = new Connection(input, output);
        connection.setWeight(0.64d);

        assertEquals(Double.valueOf(0.500736), CountUtil.countWeight(neuralNetwork, connection));
    }
}
