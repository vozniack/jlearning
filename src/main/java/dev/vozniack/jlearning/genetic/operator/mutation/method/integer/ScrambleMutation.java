package dev.vozniack.jlearning.genetic.operator.mutation.method.integer;

import dev.vozniack.jlearning.genetic.model.Chromosome;
import dev.vozniack.jlearning.genetic.operator.mutation.Mutation;

public class ScrambleMutation extends Mutation {

    public ScrambleMutation(Double probability) {
        super(probability);
    }

    @Override
    protected Chromosome mutate(Chromosome chromosome) {
        return null;
    }
}
