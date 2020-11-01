package dev.vozniack.jlearning.neural.structure.feedforward;

import dev.vozniack.jlearning.neural.model.structure.Layer;
import dev.vozniack.jlearning.neural.structure.Structure;
import dev.vozniack.jlearning.neural.structure.StructureFactory;
import dev.vozniack.jlearning.neural.types.ActivationFunction;
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

        layers.forEach(layer -> assertEquals(ActivationFunction.SIGMOID, layer.getActivationFunction()));

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
}
