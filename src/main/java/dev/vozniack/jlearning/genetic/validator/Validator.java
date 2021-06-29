package dev.vozniack.jlearning.genetic.validator;

import dev.vozniack.jlearning.genetic.algorithm.GeneticAlgorithm;
import dev.vozniack.jlearning.genetic.exception.*;
import dev.vozniack.jlearning.genetic.types.OperatorType;

import java.util.Objects;

public class Validator {

    public void validate(GeneticAlgorithm geneticAlgorithm) {
        if (geneticAlgorithm.getOperators().stream().filter(Objects::nonNull)
                .noneMatch(operator -> OperatorType.SELECTION.equals(operator.getType()))) {
            throw new SelectionException("Selection operator is not initialized yet");
        }

        if (geneticAlgorithm.getOperators().stream().filter(Objects::nonNull)
                .noneMatch(operator -> OperatorType.CROSSOVER.equals(operator.getType()))) {
            throw new CrossoverException("Crossover operator is not initialized yet");
        }

        if (geneticAlgorithm.getOperators().stream().filter(Objects::nonNull)
                .noneMatch(operator -> OperatorType.MUTATION.equals(operator.getType()))) {
            throw new MutationException("Mutation operator is not initialized yet");
        }

        if (geneticAlgorithm.getPopulation() == null) {
            throw new PopulationException("Population is not initialized yet");
        }

        if (geneticAlgorithm.getFitnessFunction() == null) {
            throw new GeneticException("Fitness function is not initialized yet");
        }
    }
}
