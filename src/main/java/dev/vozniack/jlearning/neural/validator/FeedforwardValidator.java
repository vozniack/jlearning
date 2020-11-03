package dev.vozniack.jlearning.neural.validator;

import dev.vozniack.jlearning.neural.exception.DatasetException;
import dev.vozniack.jlearning.neural.exception.LearningException;
import dev.vozniack.jlearning.neural.exception.StructureException;
import dev.vozniack.jlearning.neural.learning.Learning;
import dev.vozniack.jlearning.neural.model.operational.Dataset;
import dev.vozniack.jlearning.neural.network.NeuralNetwork;
import dev.vozniack.jlearning.neural.structure.Structure;

public class FeedforwardValidator extends Validator {

    @Override
    public void validate(NeuralNetwork neuralNetwork) {
        validateStructure(neuralNetwork.getStructure());
        validateLearning(neuralNetwork.getLearning());
        validateDataset(neuralNetwork.getDataset());
    }

    private void validateStructure(Structure structure) {
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

    private void validateLearning(Learning learning) {
        if (learning == null) {
            throw new LearningException("Learning method is not initialized yet");
        }

        if (learning.getIterations() == null || learning.getTolerance() == null || learning.getFactor() == null) {
            throw new LearningException("Learning method properties are not initialized yet");
        }
    }

    private void validateDataset(Dataset dataset) {
        if (dataset == null) {
            throw new DatasetException("Dataset is not initialized yet");
        }

        if (dataset.getInputs() < 1) {
            throw new DatasetException("It must have at least one input");
        }

        if (dataset.getOutputs() < 1) {
            throw new DatasetException("It must have at least one output");
        }
    }
}
