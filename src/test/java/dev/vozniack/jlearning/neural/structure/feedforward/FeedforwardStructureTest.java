package dev.vozniack.jlearning.neural.structure.feedforward;

import dev.vozniack.jlearning.neural.activation.ActivationFunction;
import dev.vozniack.jlearning.neural.exception.StructureException;
import dev.vozniack.jlearning.neural.model.structure.Layer;
import dev.vozniack.jlearning.neural.structure.Structure;
import dev.vozniack.jlearning.neural.structure.StructureFactory;
import dev.vozniack.jlearning.neural.types.ActivationType;
import dev.vozniack.jlearning.neural.types.StructureType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FeedforwardStructureTest {

    @Test
    public void createStructureTest() {
        Structure structure = StructureFactory.createStructure(StructureType.FEEDFORWARD, true, 4, 12, 8);

        assertNotNull(structure);
        assertTrue(structure.getBias());

        List<Layer> layers = structure.getLayers();
        assertEquals(3, layers.size());

        layers.forEach(layer -> assertEquals(ActivationFunction.get(ActivationType.SIGMOID).getClass(), layer.getActivationFunction().getClass()));

        assertEquals(4, layers.get(0).getNeurons().size());
        assertEquals(12, layers.get(1).getNeurons().size());
        assertEquals(8, layers.get(2).getNeurons().size());
    }

    @Test
    public void createStructureAndAddHiddenLayerTest() {
        Structure structure = StructureFactory.createStructure(StructureType.FEEDFORWARD, false, 4, 12, 8);

        assertNotNull(structure);
        assertFalse(structure.getBias());

        structure.addHiddenLayer(24);

        List<Layer> layers = structure.getLayers();
        assertEquals(4, layers.size());

        assertEquals(24, layers.get(2).getNeurons().size());
        assertEquals(8, layers.get(3).getNeurons().size());
    }

    @Test
    public void createStructureAndConnectionsWithBiasTest() {
        Structure structure = StructureFactory.createStructure(StructureType.FEEDFORWARD, true, 4, 12, 8);

        assertNotNull(structure);
        assertTrue(structure.getBias());

        assertEquals(140, structure.getConnections().size());
    }

    @Test
    public void createStructureAndConnectionsWithoutBiasTest() {
        Structure structure = StructureFactory.createStructure(StructureType.FEEDFORWARD, false, 4, 12, 8);

        assertNotNull(structure);
        assertFalse(structure.getBias());

        assertEquals(144, structure.getConnections().size());
    }

    @Test
    public void initWeightsTest() {
        Structure structure = StructureFactory.createStructure(StructureType.FEEDFORWARD, false, 4, 1);
        structure.initConnections(List.of(0.25d, 5d, 0.25d, 1d));

        assertEquals(Double.valueOf(0.25), structure.getConnections().get(0).getWeight());
        assertEquals(Double.valueOf(5), structure.getConnections().get(1).getWeight());
        assertEquals(Double.valueOf(0.25), structure.getConnections().get(2).getWeight());
        assertEquals(Double.valueOf(1), structure.getConnections().get(3).getWeight());
    }

    @Test
    public void initIncorrectWeightsTest() {
        Structure structure = StructureFactory.createStructure(StructureType.FEEDFORWARD, false, 4, 1);

        StructureException structureException = assertThrows(StructureException.class, () -> structure.initConnections(List.of(0.25d, 5d, 0.25d)));
        assertEquals("Number of connections is different than number of new weights", structureException.getMessage());
    }
}
