package dev.vozniack.jlearning.neural.util;

import dev.vozniack.jlearning.neural.learning.Learning;
import dev.vozniack.jlearning.neural.model.structure.Connection;
import dev.vozniack.jlearning.neural.model.structure.Neuron;

public class CountUtil {

    public static Double countNet(Connection connection) {
        return connection.getWeight() * connection.getInput().getOutput();
    }

    public static Double countError(Neuron neuron, Double correctAnswer) {
        return Math.pow(correctAnswer - neuron.getOutput(), 2);
    }

    public static Double countOutputErrorSignal(Neuron neuron, Double correctAnswer) {
        return neuron.getOutput() * (1d - neuron.getOutput()) * (correctAnswer - neuron.getOutput());
    }

    public static Double countHiddenErrorSignal(Neuron neuron) {
        return (neuron.getOutput() * (1d - neuron.getOutput())) * (neuron.getOutputs().stream().mapToDouble(connection -> connection.getWeight() * connection.getOutput().getErrorSignal()).sum());
    }

    public static Double countWeight(Learning learning, Connection connection) {
        return connection.getWeight() + (learning.getFactor() * connection.getOutput().getErrorSignal() * connection.getInput().getOutput());
    }
}
