package dev.vozniack.jlearning.genetic.operator.mutation.method.integer;

import dev.vozniack.jlearning.genetic.model.Chromosome;
import dev.vozniack.jlearning.genetic.operator.mutation.Mutation;

import java.util.List;

public class InversionMutation extends Mutation {

    public InversionMutation(Double probability) {
        super(probability);
    }

    @Override
    public List<Chromosome> process(List<Chromosome> chromosomes) {
        return null;
    }
}
