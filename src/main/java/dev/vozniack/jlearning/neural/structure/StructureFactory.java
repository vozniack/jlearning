package dev.vozniack.jlearning.neural.structure;

import dev.vozniack.jlearning.neural.types.StructureType;

public class StructureFactory {

    public static Structure createStructure(StructureType structureType, Boolean bias, Integer... neurons) {
        switch (structureType) {
            case FEEDFORWARD:
                return new FeedforwardStructure(bias, neurons);

            default:
                throw new RuntimeException();
        }
    }
}
