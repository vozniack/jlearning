package dev.vozniack.jlearning.neural.validator;

import dev.vozniack.jlearning.neural.exception.DatasetException;
import dev.vozniack.jlearning.neural.exception.LearningException;
import dev.vozniack.jlearning.neural.exception.NetworkException;
import dev.vozniack.jlearning.neural.exception.StructureException;
import dev.vozniack.jlearning.neural.learning.Learning;
import dev.vozniack.jlearning.neural.model.operational.Dataset;
import dev.vozniack.jlearning.neural.network.NeuralNetwork;
import dev.vozniack.jlearning.neural.structure.Structure;

import java.util.List;

public class FeedforwardValidator extends Validator {

    @Override
    public void validateStructure(Structure structure) {
        if (structure == null) {
            throw new StructureException("Structure is not initialized yet");
        }

        if (structure.getLayers() == null || structure.getLayers().size() < 1) {
            throw new StructureException("Neural network does not have layers");
        }

        if (structure.getConnections() == null || structure.getConnections().size() < 1) {
            throw new StructureException("Neural network does not have connections");
        }

        structure.getConnections().forEach(connection -> {
            if (connection.getWeight() == null) {
                throw new StructureException("Connections weights are not initialized yet");
            }
        });
    }

    @Override
    public void validateLearning(Learning learning) {
        if (learning == null) {
            throw new LearningException("Learning method is not initialized yet");
        }

        if (learning.getIterations() == null || learning.getTolerance() == null || learning.getFactor() == null) {
            throw new LearningException("Learning method properties are not initialized yet");
        }
    }

    @Override
    public void validateDataset(NeuralNetwork neuralNetwork, Dataset dataset) {
        if (dataset == null) {
            throw new DatasetException("Dataset is empty");
        }

        if (dataset.getInputs() == null || dataset.getInputs() < 1) {
            throw new DatasetException("Dataset must have at least one input");
        }

        if (dataset.getOutputs() == null || dataset.getOutputs() < 1) {
            throw new DatasetException("Dataset must have at least one output");
        }

        if (!neuralNetwork.getStructure().getLayers().getFirst().size().equals(dataset.getInputs())) {
            throw new DatasetException("Number of input values is different than input layer size");
        }

        if (!neuralNetwork.getStructure().getLayers().getLast().size().equals(dataset.getOutputs())) {
            throw new DatasetException("Number of output values is different than output layer size");
        }

        if (dataset.getRecords() == null) {
            throw new DatasetException("Dataset does not have any records");
        }

        dataset.getRecords().forEach(record -> {
            if (!dataset.getInputs().equals(record.getInputValues().size()) || !dataset.getOutputs().equals(record.getCorrectOutput().size())) {
                throw new DatasetException("Records in dataset are incorrect");
            }
        });
    }

    @Override
    public void validateInput(NeuralNetwork neuralNetwork, List<Double> input) {
        if (input == null || input.size() != neuralNetwork.getStructure().getLayers().getFirst().size()) {
            throw new NetworkException("Number of input values is different than input layer size");
        }
    }
}
