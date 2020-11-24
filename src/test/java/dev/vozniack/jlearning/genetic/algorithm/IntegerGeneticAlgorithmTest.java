package dev.vozniack.jlearning.genetic.algorithm;

import dev.vozniack.jlearning.genetic.fitness.FitnessFunction;
import dev.vozniack.jlearning.genetic.model.Genome;
import dev.vozniack.jlearning.genetic.model.Population;
import dev.vozniack.jlearning.genetic.model.Properties;
import dev.vozniack.jlearning.genetic.operator.crossover.Crossover;
import dev.vozniack.jlearning.genetic.operator.crossover.CrossoverMethod;
import dev.vozniack.jlearning.genetic.operator.mutation.Mutation;
import dev.vozniack.jlearning.genetic.operator.mutation.MutationMethod;
import dev.vozniack.jlearning.genetic.operator.selection.Selection;
import dev.vozniack.jlearning.genetic.operator.selection.SelectionMethod;
import org.junit.jupiter.api.Test;

import java.util.List;

public class IntegerGeneticAlgorithmTest {

    @Test
    public void createIntegerGeneticAlgorithmTest() {
        GeneticAlgorithm geneticAlgorithm = BinaryGeneticAlgorithm.builder()
                .properties(Properties.builder().iterations(128).build())
                .selection(Selection.create(SelectionMethod.ELITISM))
                .operators(List.of(
                        Crossover.create(CrossoverMethod.OX, 0.25),
                        Mutation.create(MutationMethod.SWAP, 0.1)))
                .population(Population.builder().size(128).genes(12).genes(8).build())
                .fitnessFunction(new MaximizeFunction())
                .build();
    }

    static class MaximizeFunction implements FitnessFunction {

        @Override
        public Double countFitness(Genome genome) {
            return genome.getBits()[0] == 0b01 ? 1d: 0d; // some fitness
        }
    }
}
