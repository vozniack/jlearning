package dev.vozniack.jlearning.genetic.operator.mutation.method.binary;

import dev.vozniack.jlearning.genetic.model.Chromosome;
import dev.vozniack.jlearning.genetic.operator.mutation.Mutation;
import dev.vozniack.jlearning.genetic.types.PopulationType;
import dev.vozniack.jlearning.genetic.util.RandUtil;

import java.util.Arrays;

public class FlipStringMutation extends Mutation {

    public FlipStringMutation(Double probability) {
        super(PopulationType.BINARY, probability);
    }

    @Override
    protected Chromosome mutate(Chromosome chromosome) {
        if (RandUtil.randomChance() < probability) {
            chromosome.getGenome().setBits(Arrays.stream(chromosome.getGenome().getBits())
                    .map(bit -> bit == 0 ? 1 : 0).toArray());
        }

        return chromosome;
    }
}
