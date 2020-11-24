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
import dev.vozniack.jlearning.genetic.types.PopulationType;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GeneticAlgorithmTest {

    @Test
    public void createBinaryGeneticAlgorithmTest() {
        GeneticAlgorithm geneticAlgorithm = GeneticAlgorithm.builder()
                .properties(Properties.builder().iterations(128).build())
                .selection(Selection.create(SelectionMethod.ROULETTE))
                .operators(List.of(
                        Crossover.create(CrossoverMethod.ONE_POINT, 0.25),
                        Mutation.create(MutationMethod.FLIP_BIT, 0.1)))
                .population(Population.builder().type(PopulationType.BINARY).size(128).genes(12).genes(8).build())
                .fitnessFunction(new MinimizeFunction())
                .build();

        geneticAlgorithm.init();
    }

    static class MinimizeFunction implements FitnessFunction {

        @Override
        public Double countFitness(Genome genome) {
            return genome.getBits()[0] == 0 ? 0d: 1d; // some fitness
        }
    }
}
