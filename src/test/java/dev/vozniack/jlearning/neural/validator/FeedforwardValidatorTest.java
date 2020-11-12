package dev.vozniack.jlearning.neural.validator;

import dev.vozniack.jlearning.neural.exception.DatasetException;
import dev.vozniack.jlearning.neural.exception.LearningException;
import dev.vozniack.jlearning.neural.exception.NetworkException;
import dev.vozniack.jlearning.neural.exception.StructureException;
import dev.vozniack.jlearning.neural.learning.LearningFactory;
import dev.vozniack.jlearning.neural.learning.LearningType;
import dev.vozniack.jlearning.neural.model.operational.Dataset;
import dev.vozniack.jlearning.neural.model.operational.Record;
import dev.vozniack.jlearning.neural.network.FeedforwardNeuralNetwork;
import dev.vozniack.jlearning.neural.network.NeuralNetwork;
import dev.vozniack.jlearning.neural.structure.StructureFactory;
import dev.vozniack.jlearning.neural.structure.StructureType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FeedforwardValidatorTest {

    @Test
    public void validateNetworkWithCorrectStructureTest() {
        NeuralNetwork neuralNetwork = FeedforwardNeuralNetwork.builder()
                .structure(StructureFactory.createStructure(StructureType.FEEDFORWARD, true, 4, 12, 8))
                .learning(LearningFactory.createLearning(LearningType.BACKPROPAGATION, 1024, 0.1, 1.0, false))
                .build();

        neuralNetwork.init();

        FeedforwardValidator feedforwardValidator = new FeedforwardValidator();
        feedforwardValidator.validateStructure(neuralNetwork.getStructure());
    }

    @Test
    public void validateNetworkWithoutStructureTest() {
        NeuralNetwork neuralNetwork = FeedforwardNeuralNetwork.builder()
                .learning(LearningFactory.createLearning(LearningType.BACKPROPAGATION, 1024, 0.1, 1.0, false))
                .build();

        FeedforwardValidator feedforwardValidator = new FeedforwardValidator();
        StructureException structureException = assertThrows(StructureException.class, () -> feedforwardValidator.validateStructure(neuralNetwork.getStructure()));

        assertEquals("Structure is not initialized yet", structureException.getMessage());
    }

    @Test
    public void validateStructureWithoutLayersTest() {
        NeuralNetwork neuralNetwork = FeedforwardNeuralNetwork.builder()
                .structure(StructureFactory.createStructure(StructureType.FEEDFORWARD, true))
                .learning(LearningFactory.createLearning(LearningType.BACKPROPAGATION, 1024, 0.1, 1.0, false))
                .build();

        FeedforwardValidator feedforwardValidator = new FeedforwardValidator();
        StructureException structureException = assertThrows(StructureException.class, () -> feedforwardValidator.validateStructure(neuralNetwork.getStructure()));

        assertEquals("Neural network does not have layers", structureException.getMessage());
    }

    @Test
    public void validateStructureWithoutConnectionsTest() {
        NeuralNetwork neuralNetwork = FeedforwardNeuralNetwork.builder()
                .structure(StructureFactory.createStructure(StructureType.FEEDFORWARD, true, 4, 12, 8))
                .learning(LearningFactory.createLearning(LearningType.BACKPROPAGATION, 1024, 0.1, 1.0, false))
                .build();

        neuralNetwork.getStructure().setConnections(null);

        FeedforwardValidator feedforwardValidator = new FeedforwardValidator();
        StructureException structureException = assertThrows(StructureException.class, () -> feedforwardValidator.validateStructure(neuralNetwork.getStructure()));

        assertEquals("Neural network does not have connections", structureException.getMessage());
    }

    @Test
    public void validateStructureWithoutConnectionsWeightsTest() {
        NeuralNetwork neuralNetwork = FeedforwardNeuralNetwork.builder()
                .structure(StructureFactory.createStructure(StructureType.FEEDFORWARD, true, 4, 12, 8))
                .learning(LearningFactory.createLearning(LearningType.BACKPROPAGATION, 1024, 0.1, 1.0, false))
                .build();

        neuralNetwork.getStructure().getConnections().get(12).setWeight(null);

        FeedforwardValidator feedforwardValidator = new FeedforwardValidator();
        StructureException structureException = assertThrows(StructureException.class, () -> feedforwardValidator.validateStructure(neuralNetwork.getStructure()));

        assertEquals("Connections weights are not initialized yet", structureException.getMessage());
    }

    @Test
    public void validateNetworkWithCorrectLearningTest() {
        NeuralNetwork neuralNetwork = FeedforwardNeuralNetwork.builder()
                .structure(StructureFactory.createStructure(StructureType.FEEDFORWARD, true, 4, 12, 8))
                .learning(LearningFactory.createLearning(LearningType.BACKPROPAGATION, 1024, 0.1, 1.0, false))
                .build();

        neuralNetwork.init();

        FeedforwardValidator feedforwardValidator = new FeedforwardValidator();
        feedforwardValidator.validateLearning(neuralNetwork.getLearning());
    }

    @Test
    public void validateNetworkWithoutLearningTest() {
        NeuralNetwork neuralNetwork = FeedforwardNeuralNetwork.builder()
                .structure(StructureFactory.createStructure(StructureType.FEEDFORWARD, true, 4, 12, 8))
                .build();

        FeedforwardValidator feedforwardValidator = new FeedforwardValidator();
        LearningException learningException = assertThrows(LearningException.class, () -> feedforwardValidator.validateLearning(neuralNetwork.getLearning()));

        assertEquals("Learning method is not initialized yet", learningException.getMessage());
    }

    @Test
    public void validateLearningWithoutPropertiesTest() {
        NeuralNetwork neuralNetwork = FeedforwardNeuralNetwork.builder()
                .structure(StructureFactory.createStructure(StructureType.FEEDFORWARD, true, 4, 12, 8))
                .learning(LearningFactory.createLearning(LearningType.BACKPROPAGATION, null, 0.1, 1.0, false))
                .build();

        FeedforwardValidator feedforwardValidator = new FeedforwardValidator();
        LearningException learningException = assertThrows(LearningException.class, () -> feedforwardValidator.validateLearning(neuralNetwork.getLearning()));

        assertEquals("Learning method properties are not initialized yet", learningException.getMessage());
    }

    @Test
    public void validateNetworkWithCorrectDatasetTest() {
        NeuralNetwork neuralNetwork = FeedforwardNeuralNetwork.builder()
                .structure(StructureFactory.createStructure(StructureType.FEEDFORWARD, true, 4, 12, 8))
                .learning(LearningFactory.createLearning(LearningType.BACKPROPAGATION, 1024, 0.1, 1.0, false))
                .build();

        List<Record> records = List.of(Record.builder()
                .inputValues(List.of(1d, 2d, 3d, 4d))
                .correctOutput(List.of(1d, 2d, 3d, 4d, 5d, 6d, 7d, 8d))
                .build());

        Dataset dataset = Dataset.builder().inputs(4).outputs(8).records(records).build();

        FeedforwardValidator feedforwardValidator = new FeedforwardValidator();
        feedforwardValidator.validateDataset(neuralNetwork, dataset);
    }

    @Test
    public void validateNetworkWithoutDatasetTest() {
        NeuralNetwork neuralNetwork = FeedforwardNeuralNetwork.builder()
                .structure(StructureFactory.createStructure(StructureType.FEEDFORWARD, true, 4, 12, 8))
                .learning(LearningFactory.createLearning(LearningType.BACKPROPAGATION, 1024, 0.1, 1.0, false))
                .build();

        FeedforwardValidator feedforwardValidator = new FeedforwardValidator();
        DatasetException datasetException = assertThrows(DatasetException.class, () -> feedforwardValidator.validateDataset(neuralNetwork, null));

        assertEquals("Dataset is empty", datasetException.getMessage());
    }

    @Test
    public void validateNetworkWithZeroInputsTest() {
        NeuralNetwork neuralNetwork = FeedforwardNeuralNetwork.builder()
                .structure(StructureFactory.createStructure(StructureType.FEEDFORWARD, true, 4, 12, 8))
                .learning(LearningFactory.createLearning(LearningType.BACKPROPAGATION, 1024, 0.1, 1.0, false))
                .build();

        FeedforwardValidator feedforwardValidator = new FeedforwardValidator();
        DatasetException datasetException = assertThrows(DatasetException.class, () -> feedforwardValidator.validateDataset(neuralNetwork, Dataset.builder().inputs(0).outputs(8).build()));

        assertEquals("Dataset must have at least one input", datasetException.getMessage());
    }

    @Test
    public void validateNetworkWithZeroOutputsTest() {
        NeuralNetwork neuralNetwork = FeedforwardNeuralNetwork.builder()
                .structure(StructureFactory.createStructure(StructureType.FEEDFORWARD, true, 4, 12, 8))
                .learning(LearningFactory.createLearning(LearningType.BACKPROPAGATION, 1024, 0.1, 1.0, false))
                .build();

        FeedforwardValidator feedforwardValidator = new FeedforwardValidator();
        DatasetException datasetException = assertThrows(DatasetException.class, () -> feedforwardValidator.validateDataset(neuralNetwork, Dataset.builder().inputs(8).outputs(0).build()));

        assertEquals("Dataset must have at least one output", datasetException.getMessage());
    }

    @Test
    public void validateDatasetWithNotMatchingInputs() {
        NeuralNetwork neuralNetwork = FeedforwardNeuralNetwork.builder()
                .structure(StructureFactory.createStructure(StructureType.FEEDFORWARD, true, 4, 12, 8))
                .learning(LearningFactory.createLearning(LearningType.BACKPROPAGATION, 1024, 0.1, 1.0, false))
                .build();

        Dataset dataset = Dataset.builder().inputs(8).outputs(8).build();

        FeedforwardValidator feedforwardValidator = new FeedforwardValidator();
        DatasetException datasetException = assertThrows(DatasetException.class, () -> feedforwardValidator.validateDataset(neuralNetwork, dataset));

        assertEquals("Number of input values is different than input layer size", datasetException.getMessage());
    }

    @Test
    public void validateDatasetWithNotMatchingOutputs() {
        NeuralNetwork neuralNetwork = FeedforwardNeuralNetwork.builder()
                .structure(StructureFactory.createStructure(StructureType.FEEDFORWARD, true, 4, 12, 8))
                .learning(LearningFactory.createLearning(LearningType.BACKPROPAGATION, 1024, 0.1, 1.0, false))
                .build();

        Dataset dataset = Dataset.builder().inputs(4).outputs(4).build();

        FeedforwardValidator feedforwardValidator = new FeedforwardValidator();
        DatasetException datasetException = assertThrows(DatasetException.class, () -> feedforwardValidator.validateDataset(neuralNetwork, dataset));

        assertEquals("Number of output values is different than output layer size", datasetException.getMessage());
    }

    @Test
    public void validateDatasetWithoutRecordsTest() {
        NeuralNetwork neuralNetwork = FeedforwardNeuralNetwork.builder()
                .structure(StructureFactory.createStructure(StructureType.FEEDFORWARD, true, 4, 12, 8))
                .learning(LearningFactory.createLearning(LearningType.BACKPROPAGATION, 1024, 0.1, 1.0, false))
                .build();

        Dataset dataset = Dataset.builder().inputs(4).outputs(8).build();

        FeedforwardValidator feedforwardValidator = new FeedforwardValidator();
        DatasetException datasetException = assertThrows(DatasetException.class, () -> feedforwardValidator.validateDataset(neuralNetwork, dataset));

        assertEquals("Dataset does not have any records", datasetException.getMessage());
    }

    @Test
    public void validateDatasetWithIncorrectRecordsTest() {
        NeuralNetwork neuralNetwork = FeedforwardNeuralNetwork.builder()
                .structure(StructureFactory.createStructure(StructureType.FEEDFORWARD, true, 4, 12, 8))
                .learning(LearningFactory.createLearning(LearningType.BACKPROPAGATION, 1024, 0.1, 1.0, false))
                .build();

        List<Record> records = List.of(Record.builder()
                .inputValues(List.of(2d, 3d, 4d))
                .correctOutput(List.of(1d, 2d, 3d, 4d, 5d, 6d, 7d, 8d))
                .build());

        Dataset dataset = Dataset.builder().inputs(4).outputs(8).records(records).build();

        FeedforwardValidator feedforwardValidator = new FeedforwardValidator();
        DatasetException datasetException = assertThrows(DatasetException.class, () -> feedforwardValidator.validateDataset(neuralNetwork, dataset));

        assertEquals("Records in dataset are incorrect", datasetException.getMessage());
    }

    @Test
    public void validateNetworkWithCorrectInputTest() {
        NeuralNetwork neuralNetwork = FeedforwardNeuralNetwork.builder()
                .structure(StructureFactory.createStructure(StructureType.FEEDFORWARD, true, 4, 12, 8))
                .learning(LearningFactory.createLearning(LearningType.BACKPROPAGATION, 1024, 0.1, 1.0, false))
                .build();

        FeedforwardValidator feedforwardValidator = new FeedforwardValidator();
        feedforwardValidator.validateInput(neuralNetwork, List.of(1d, 2d, 3d, 4d));
    }

    @Test
    public void validateNetworkWithIncorrectInputTest() {
        NeuralNetwork neuralNetwork = FeedforwardNeuralNetwork.builder()
                .structure(StructureFactory.createStructure(StructureType.FEEDFORWARD, true, 4, 12, 8))
                .learning(LearningFactory.createLearning(LearningType.BACKPROPAGATION, 1024, 0.1, 1.0, false))
                .build();

        FeedforwardValidator feedforwardValidator = new FeedforwardValidator();
        NetworkException networkException = assertThrows(NetworkException.class, () -> feedforwardValidator.validateInput(neuralNetwork, List.of(1d, 2d, 4d)));

        assertEquals("Number of input values is different than input layer size", networkException.getMessage());
    }
}
