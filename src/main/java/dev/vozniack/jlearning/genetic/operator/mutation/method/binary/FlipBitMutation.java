package dev.vozniack.jlearning.genetic.operator.mutation.method.binary;

import dev.vozniack.jlearning.genetic.model.Chromosome;
import dev.vozniack.jlearning.genetic.operator.mutation.Mutation;
import dev.vozniack.jlearning.genetic.util.RandUtil;

public class FlipBitMutation extends Mutation {

    public FlipBitMutation(Double probability) {
        super(probability);
    }

    @Override
    protected Chromosome mutate(Chromosome chromosome) {
        if (RandUtil.randomChance() < probability) {
            int[] bits = chromosome.getGenome().getBits();

            int index = RandUtil.randomIndex(bits.length);
            bits[index] = bits[index] == 0 ? 1 : 0;

            chromosome.getGenome().setBits(bits);
        }

        return chromosome;
    }
}
