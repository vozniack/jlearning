package dev.vozniack.jlearning.genetic.operator.mutation.method.integer;

import dev.vozniack.jlearning.genetic.model.Chromosome;
import dev.vozniack.jlearning.genetic.operator.mutation.Mutation;

import java.util.List;

public class SwapMutation extends Mutation {

    public SwapMutation(Double probability) {
        super(probability);
    }

    @Override
    public List<Chromosome> process(List<Chromosome> chromosomes) {
        return null;
    }
}
