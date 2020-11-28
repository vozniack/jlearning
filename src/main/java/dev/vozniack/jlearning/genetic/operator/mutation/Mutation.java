package dev.vozniack.jlearning.genetic.operator.mutation;

import dev.vozniack.jlearning.genetic.exception.MutationException;
import dev.vozniack.jlearning.genetic.model.Chromosome;
import dev.vozniack.jlearning.genetic.operator.GeneticOperator;
import dev.vozniack.jlearning.genetic.operator.mutation.method.binary.FlipBitMutation;
import dev.vozniack.jlearning.genetic.operator.mutation.method.binary.FlipStringMutation;
import dev.vozniack.jlearning.genetic.operator.mutation.method.integer.InversionMutation;
import dev.vozniack.jlearning.genetic.operator.mutation.method.integer.ScrambleMutation;
import dev.vozniack.jlearning.genetic.operator.mutation.method.integer.SwapMutation;
import dev.vozniack.jlearning.genetic.types.PopulationType;

import java.util.List;
import java.util.stream.Collectors;

public abstract class Mutation extends GeneticOperator {

    protected PopulationType populationType;
    protected Double probability;

    public Mutation(PopulationType populationType, Double probability) {
        this.populationType = populationType;
        this.probability = probability;
    }

    /* Mutation */

    @Override
    public List<Chromosome> process(List<Chromosome> chromosomes) {
        return chromosomes.stream().map(this::mutate).collect(Collectors.toList());
    }

    protected abstract Chromosome mutate(Chromosome chromosome);

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
