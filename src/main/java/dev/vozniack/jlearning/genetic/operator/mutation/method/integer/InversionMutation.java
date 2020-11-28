package dev.vozniack.jlearning.genetic.operator.mutation.method.integer;

import dev.vozniack.jlearning.genetic.model.Chromosome;
import dev.vozniack.jlearning.genetic.operator.mutation.Mutation;

public class InversionMutation extends Mutation {

    public InversionMutation(Double probability) {
        super(probability);
    }

    @Override
    protected Chromosome mutate(Chromosome chromosome) {
        return null;
    }
}
