package dev.vozniack.jlearning.neural.structure;

import dev.vozniack.jlearning.neural.exception.StructureException;
import dev.vozniack.jlearning.neural.structure.feedforward.FeedforwardStructure;
import dev.vozniack.jlearning.neural.structure.recursive.RecursiveStructure;

public class StructureFactory {

    public static Structure createStructure(StructureType structureType, Boolean bias, Integer... neurons) {
        switch (structureType) {
            case FEEDFORWARD:
                return new FeedforwardStructure(bias, neurons);

            case RECURSIVE:
                return new RecursiveStructure(bias, neurons);

            default:
                throw new StructureException("How did you throw it?");
        }
    }
}
