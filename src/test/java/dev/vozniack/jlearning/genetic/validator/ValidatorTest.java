package dev.vozniack.jlearning.genetic.validator;

import dev.vozniack.jlearning.genetic.algorithm.GeneticAlgorithm;
import dev.vozniack.jlearning.genetic.exception.*;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidatorTest {

    @Test
    public void validateCorrectAlgorithmTest() {
        GeneticAlgorithm geneticAlgorithm = GeneticAlgorithm.builder()
                .properties(Properties.builder().iterations(128).build())
                .selection(Selection.create(SelectionMethod.ROULETTE))
                .crossover(Crossover.create(CrossoverMethod.ONE_POINT, 0.25))
                .mutation(Mutation.create(MutationMethod.FLIP_BIT, 0.1))
                .population(Population.builder().type(PopulationType.BINARY).size(128).genes(12).geneSize(8).build())
                .fitnessFunction(new MinimizeFunction())
                .build();

        Validator validator = new Validator();
        validator.validate(geneticAlgorithm);
    }

    @Test
    public void validateAlgorithmWithoutSelectionTest() {
        GeneticAlgorithm geneticAlgorithm = GeneticAlgorithm.builder()
                .properties(Properties.builder().iterations(128).build())
                .crossover(Crossover.create(CrossoverMethod.ONE_POINT, 0.25))
                .mutation(Mutation.create(MutationMethod.FLIP_BIT, 0.1))
                .population(Population.builder().type(PopulationType.BINARY).size(128).genes(12).geneSize(8).build())
                .fitnessFunction(new MinimizeFunction())
                .build();

        Validator validator = new Validator();
        SelectionException selectionException = assertThrows(SelectionException.class, () -> validator.validate(geneticAlgorithm));

        assertEquals("Selection operator is not initialized yet", selectionException.getMessage());
    }

    @Test
    public void validateAlgorithmWithoutCrossoverTest() {
        GeneticAlgorithm geneticAlgorithm = GeneticAlgorithm.builder()
                .properties(Properties.builder().iterations(128).build())
                .selection(Selection.create(SelectionMethod.ROULETTE))
                .mutation(Mutation.create(MutationMethod.FLIP_BIT, 0.1))
                .population(Population.builder().type(PopulationType.BINARY).size(128).genes(12).geneSize(8).build())
                .fitnessFunction(new MinimizeFunction())
                .build();

        Validator validator = new Validator();
        CrossoverException crossoverException = assertThrows(CrossoverException.class, () -> validator.validate(geneticAlgorithm));

        assertEquals("Crossover operator is not initialized yet", crossoverException.getMessage());
    }

    @Test
    public void validateAlgorithmWithoutMutationTest() {
        GeneticAlgorithm geneticAlgorithm = GeneticAlgorithm.builder()
                .properties(Properties.builder().iterations(128).build())
                .selection(Selection.create(SelectionMethod.ROULETTE))
                .crossover(Crossover.create(CrossoverMethod.ONE_POINT, 0.25))
                .population(Population.builder().type(PopulationType.BINARY).size(128).genes(12).geneSize(8).build())
                .fitnessFunction(new MinimizeFunction())
                .build();

        Validator validator = new Validator();
        MutationException mutationException = assertThrows(MutationException.class, () -> validator.validate(geneticAlgorithm));

        assertEquals("Mutation operator is not initialized yet", mutationException.getMessage());
    }

    @Test
    public void validateAlgorithmWithoutPopulationTest() {
        GeneticAlgorithm geneticAlgorithm = GeneticAlgorithm.builder()
                .properties(Properties.builder().iterations(128).build())
                .selection(Selection.create(SelectionMethod.ROULETTE))
                .crossover(Crossover.create(CrossoverMethod.ONE_POINT, 0.25))
                .mutation(Mutation.create(MutationMethod.FLIP_BIT, 0.1))
                .fitnessFunction(new MinimizeFunction())
                .build();

        Validator validator = new Validator();
        PopulationException populationException = assertThrows(PopulationException.class, () -> validator.validate(geneticAlgorithm));

        assertEquals("Population is not initialized yet", populationException.getMessage());
    }

    @Test
    public void validateAlgorithmWithoutFitnessFunctionTest() {
        GeneticAlgorithm geneticAlgorithm = GeneticAlgorithm.builder()
                .properties(Properties.builder().iterations(128).build())
                .selection(Selection.create(SelectionMethod.ROULETTE))
                .crossover(Crossover.create(CrossoverMethod.ONE_POINT, 0.25))
                .mutation(Mutation.create(MutationMethod.FLIP_BIT, 0.1))
                .population(Population.builder().type(PopulationType.BINARY).size(128).genes(12).geneSize(8).build())
                .build();

        Validator validator = new Validator();
        GeneticException geneticException = assertThrows(GeneticException.class, () -> validator.validate(geneticAlgorithm));

        assertEquals("Fitness function is not initialized yet", geneticException.getMessage());
    }

    static class MinimizeFunction implements FitnessFunction {

        @Override
        public Double countFitness(Genome genome) {
            return genome.getBits()[0] == 0 ? 0d: 1d; // some fitness
        }
    }
}
