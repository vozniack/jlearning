package dev.vozniack.jlearning.genetic.operator.mutation;

import dev.vozniack.jlearning.genetic.exception.MutationException;
import dev.vozniack.jlearning.genetic.operator.GeneticOperator;
import dev.vozniack.jlearning.genetic.operator.mutation.method.binary.FlipBitMutation;
import dev.vozniack.jlearning.genetic.operator.mutation.method.binary.FlipStringMutation;
import dev.vozniack.jlearning.genetic.operator.mutation.method.integer.InversionMutation;
import dev.vozniack.jlearning.genetic.operator.mutation.method.integer.ScrambleMutation;
import dev.vozniack.jlearning.genetic.operator.mutation.method.integer.SwapMutation;

public abstract class Mutation extends GeneticOperator {

    public Mutation(Double probability) {
        this.probability = probability;
    }

    /* Properties */

    protected Double probability;

    /* Factory */

    public static Mutation create(MutationMethod method, Double probability) {
        switch (method) {
            case FLIP_BIT:
                return new FlipBitMutation(probability);

            case FLIP_STRING:
                return new FlipStringMutation(probability);

            case SWAP:
                return new SwapMutation(probability);

            case SCRAMBLE:
                return new ScrambleMutation(probability);

            case INVERSION:
                return new InversionMutation(probability);

            default:
                throw new MutationException("How did you throw it?");
        }
    }
}
