package dev.vozniack.jlearning.neural.launcher;

import dev.vozniack.jlearning.neural.network.NeuralNetwork;

import java.util.List;

public interface Launcher {

    void setNeuralNetwork(NeuralNetwork neuralNetwork);

    void launch(List<Double> input);
}
