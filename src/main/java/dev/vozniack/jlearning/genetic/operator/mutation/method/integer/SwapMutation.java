package dev.vozniack.jlearning.genetic.operator.mutation.method.integer;

import dev.vozniack.jlearning.genetic.model.Chromosome;
import dev.vozniack.jlearning.genetic.operator.mutation.Mutation;
import dev.vozniack.jlearning.genetic.types.PopulationType;

public class SwapMutation extends Mutation {

    public SwapMutation(Double probability) {
        super(PopulationType.INTEGER, probability);
    }

    @Override
    protected Chromosome mutate(Chromosome chromosome) {
        return null;
    }
}
