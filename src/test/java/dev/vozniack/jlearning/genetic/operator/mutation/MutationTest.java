package dev.vozniack.jlearning.genetic.operator.mutation;

import dev.vozniack.jlearning.genetic.operator.mutation.method.binary.FlipBitMutation;
import dev.vozniack.jlearning.genetic.operator.mutation.method.binary.FlipStringMutation;
import dev.vozniack.jlearning.genetic.operator.mutation.method.integer.InversionMutation;
import dev.vozniack.jlearning.genetic.operator.mutation.method.integer.ScrambleMutation;
import dev.vozniack.jlearning.genetic.operator.mutation.method.integer.SwapMutation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MutationTest {

    @Test
    public void buildFlipBitMutationTest() {
        Mutation mutation = Mutation.create(MutationMethod.FLIP_BIT, 1d);
        assertEquals(mutation.getClass(), FlipBitMutation.class);
    }

    @Test
    public void buildFlipStringMutationTest() {
        Mutation mutation = Mutation.create(MutationMethod.FLIP_STRING, 1d);
        assertEquals(mutation.getClass(), FlipStringMutation.class);
    }

    @Test
    public void buildInversionMutationTest() {
        Mutation mutation = Mutation.create(MutationMethod.INVERSION, 1d);
        assertEquals(mutation.getClass(), InversionMutation.class);
    }

    @Test
    public void buildScrambleMutationTest() {
        Mutation mutation = Mutation.create(MutationMethod.SCRAMBLE, 1d);
        assertEquals(mutation.getClass(), ScrambleMutation.class);
    }

    @Test
    public void buildSwapMutationTest() {
        Mutation mutation = Mutation.create(MutationMethod.SWAP, 1d);
        assertEquals(mutation.getClass(), SwapMutation.class);
    }

}