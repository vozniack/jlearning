package dev.vozniack.jlearning.neural.validator;

import dev.vozniack.jlearning.neural.exception.DatasetException;
import dev.vozniack.jlearning.neural.exception.LearningException;
import dev.vozniack.jlearning.neural.exception.StructureException;
import dev.vozniack.jlearning.neural.learning.LearningFactory;
import dev.vozniack.jlearning.neural.model.operational.Dataset;
import dev.vozniack.jlearning.neural.network.FeedforwardNeuralNetwork;
import dev.vozniack.jlearning.neural.network.NeuralNetwork;
import dev.vozniack.jlearning.neural.structure.StructureFactory;
import dev.vozniack.jlearning.neural.types.LearningType;
import dev.vozniack.jlearning.neural.types.StructureType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FeedforwardValidatorTest {

    @Test
    public void validateCorrectNetworkTest() {
        NeuralNetwork neuralNetwork = FeedforwardNeuralNetwork.builder()
                .structure(StructureFactory.createStructure(StructureType.FEEDFORWARD, true, 4, 12, 8))
                .learning(LearningFactory.createLearning(LearningType.BACKPROPAGATION, 1024, 0.1, 1.0))
                .dataset(Dataset.builder().inputs(4).outputs(8).build())
                .build();

        neuralNetwork.init();

        FeedforwardValidator feedforwardValidator = new FeedforwardValidator();
        feedforwardValidator.validate(neuralNetwork);
    }

    @Test
    public void validateNetworkWithoutStructureTest() {
        NeuralNetwork neuralNetwork = FeedforwardNeuralNetwork.builder()
                .learning(LearningFactory.createLearning(LearningType.BACKPROPAGATION, 1024, 0.1, 1.0))
                .dataset(Dataset.builder().inputs(4).outputs(8).build())
                .build();

        FeedforwardValidator feedforwardValidator = new FeedforwardValidator();
        StructureException structureException = assertThrows(StructureException.class, () -> feedforwardValidator.validate(neuralNetwork));

        assertEquals("Structure is not initialized yet", structureException.getMessage());
    }

    @Test
    public void validateStructureWithoutLayersTest() {
        NeuralNetwork neuralNetwork = FeedforwardNeuralNetwork.builder()
                .structure(StructureFactory.createStructure(StructureType.FEEDFORWARD, true))
                .learning(LearningFactory.createLearning(LearningType.BACKPROPAGATION, 1024, 0.1, 1.0))
                .dataset(Dataset.builder().inputs(4).outputs(8).build())
                .build();

        FeedforwardValidator feedforwardValidator = new FeedforwardValidator();
        StructureException structureException = assertThrows(StructureException.class, () -> feedforwardValidator.validate(neuralNetwork));

        assertEquals("Neural network does not have layers", structureException.getMessage());
    }

    @Test
    public void validateStructureWithoutConnectionsTest() {
        NeuralNetwork neuralNetwork = FeedforwardNeuralNetwork.builder()
                .structure(StructureFactory.createStructure(StructureType.FEEDFORWARD, true, 4, 12, 8))
                .learning(LearningFactory.createLearning(LearningType.BACKPROPAGATION, 1024, 0.1, 1.0))
                .dataset(Dataset.builder().inputs(4).outputs(8).build())
                .build();

        neuralNetwork.getStructure().setConnections(null);

        FeedforwardValidator feedforwardValidator = new FeedforwardValidator();
        StructureException structureException = assertThrows(StructureException.class, () -> feedforwardValidator.validate(neuralNetwork));

        assertEquals("Neural network does not have connections", structureException.getMessage());
    }

    @Test
    public void validateStructureWithoutConnectionsWeightsTest() {
        NeuralNetwork neuralNetwork = FeedforwardNeuralNetwork.builder()
                .structure(StructureFactory.createStructure(StructureType.FEEDFORWARD, true, 4, 12, 8))
                .learning(LearningFactory.createLearning(LearningType.BACKPROPAGATION, 1024, 0.1, 1.0))
                .dataset(Dataset.builder().inputs(4).outputs(8).build())
                .build();

        neuralNetwork.getStructure().getConnections().get(12).setWeight(null);

        FeedforwardValidator feedforwardValidator = new FeedforwardValidator();
        StructureException structureException = assertThrows(StructureException.class, () -> feedforwardValidator.validate(neuralNetwork));

        assertEquals("Connections weights are not initialized yet", structureException.getMessage());
    }

    @Test
    public void validateNetworkWithoutLearningTest() {
        NeuralNetwork neuralNetwork = FeedforwardNeuralNetwork.builder()
                .structure(StructureFactory.createStructure(StructureType.FEEDFORWARD, true, 4, 12, 8))
                .dataset(Dataset.builder().inputs(4).outputs(8).build())
                .build();

        FeedforwardValidator feedforwardValidator = new FeedforwardValidator();
        LearningException learningException = assertThrows(LearningException.class, () -> feedforwardValidator.validate(neuralNetwork));

        assertEquals("Learning method is not initialized yet", learningException.getMessage());
    }

    @Test
    public void validateLearningWithoutPropertiesTest() {
        NeuralNetwork neuralNetwork = FeedforwardNeuralNetwork.builder()
                .structure(StructureFactory.createStructure(StructureType.FEEDFORWARD, true, 4, 12, 8))
                .learning(LearningFactory.createLearning(LearningType.BACKPROPAGATION, null, 0.1, 1.0))
                .dataset(Dataset.builder().inputs(4).outputs(8).build())
                .build();

        FeedforwardValidator feedforwardValidator = new FeedforwardValidator();
        LearningException learningException = assertThrows(LearningException.class, () -> feedforwardValidator.validate(neuralNetwork));

        assertEquals("Learning method properties are not initialized yet", learningException.getMessage());
    }

    @Test
    public void validateNetworkWithoutDatasetTest() {
        NeuralNetwork neuralNetwork = FeedforwardNeuralNetwork.builder()
                .structure(StructureFactory.createStructure(StructureType.FEEDFORWARD, true, 4, 12, 8))
                .learning(LearningFactory.createLearning(LearningType.BACKPROPAGATION, 1024, 0.1, 1.0))
                .build();

        FeedforwardValidator feedforwardValidator = new FeedforwardValidator();
        DatasetException datasetException = assertThrows(DatasetException.class, () -> feedforwardValidator.validate(neuralNetwork));

        assertEquals("Dataset is not initialized yet", datasetException.getMessage());
    }

    @Test
    public void validateNetworkWithZeroInputsTest() {
        NeuralNetwork neuralNetwork = FeedforwardNeuralNetwork.builder()
                .structure(StructureFactory.createStructure(StructureType.FEEDFORWARD, true, 4, 12, 8))
                .learning(LearningFactory.createLearning(LearningType.BACKPROPAGATION, 1024, 0.1, 1.0))
                .dataset(Dataset.builder().inputs(0).outputs(8).build())
                .build();

        FeedforwardValidator feedforwardValidator = new FeedforwardValidator();
        DatasetException datasetException = assertThrows(DatasetException.class, () -> feedforwardValidator.validate(neuralNetwork));

        assertEquals("It must have at least one input", datasetException.getMessage());
    }

    @Test
    public void validateNetworkWithZeroOutputsTest() {
        NeuralNetwork neuralNetwork = FeedforwardNeuralNetwork.builder()
                .structure(StructureFactory.createStructure(StructureType.FEEDFORWARD, true, 4, 12, 8))
                .learning(LearningFactory.createLearning(LearningType.BACKPROPAGATION, 1024, 0.1, 1.0))
                .dataset(Dataset.builder().inputs(4).outputs(0).build())
                .build();

        FeedforwardValidator feedforwardValidator = new FeedforwardValidator();
        DatasetException datasetException = assertThrows(DatasetException.class, () -> feedforwardValidator.validate(neuralNetwork));

        assertEquals("It must have at least one output", datasetException.getMessage());
    }
}
