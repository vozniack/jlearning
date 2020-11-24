package dev.vozniack.jlearning.genetic.operator.mutation.method.binary;

import dev.vozniack.jlearning.genetic.model.Chromosome;
import dev.vozniack.jlearning.genetic.operator.mutation.Mutation;

import java.util.List;

public class FlipBitMutation extends Mutation {

    public FlipBitMutation(Double probability) {
        super(probability);
    }

    @Override
    public List<Chromosome> process(List<Chromosome> chromosomes) {
        return null;
    }
}
