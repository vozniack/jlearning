package dev.vozniack.jlearning.neural.structure;

import dev.vozniack.jlearning.neural.structure.feedforward.FeedforwardStructure;
import dev.vozniack.jlearning.neural.structure.recursive.RecursiveStructure;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StructureFactoryTest {

    @Test
    public void createFeedforwardStructureTest() {
        Structure structure = StructureFactory.createStructure(StructureType.FEEDFORWARD, true, 4, 12, 8);

        assertNotNull(structure);
        assertEquals(FeedforwardStructure.class, structure.getClass());
    }

    @Test
    public void createRecursiveStructureTest() {
        Structure structure = StructureFactory.createStructure(StructureType.RECURSIVE, true, 4, 12, 8);

        assertNotNull(structure);
        assertEquals(RecursiveStructure.class, structure.getClass());
    }
}