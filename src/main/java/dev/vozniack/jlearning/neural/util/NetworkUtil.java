package dev.vozniack.jlearning.neural.util;

import dev.vozniack.jlearning.neural.model.structure.Connection;
import dev.vozniack.jlearning.neural.network.NeuralNetwork;

public class NetworkUtil {

    public static Double modifyWeight(NeuralNetwork neuralNetwork, Connection connection) {
        return connection.getWeight() + (neuralNetwork.getLearning().getFactor() * connection.getOutput().getErrorSignal() * connection.getInput().getOutput());
    }
}
