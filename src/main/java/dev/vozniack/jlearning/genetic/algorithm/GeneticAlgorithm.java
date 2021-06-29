package dev.vozniack.jlearning.genetic.algorithm;

import dev.vozniack.jlearning.genetic.fitness.FitnessFunction;
import dev.vozniack.jlearning.genetic.model.Population;
import dev.vozniack.jlearning.genetic.model.Properties;
import dev.vozniack.jlearning.genetic.operator.GeneticOperator;
import dev.vozniack.jlearning.genetic.operator.crossover.Crossover;
import dev.vozniack.jlearning.genetic.operator.mutation.Mutation;
import dev.vozniack.jlearning.genetic.operator.selection.Selection;
import dev.vozniack.jlearning.genetic.types.OperatorType;
import dev.vozniack.jlearning.genetic.validator.Validator;
import lombok.Builder;
import lombok.Getter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Getter
public class GeneticAlgorithm {

    public GeneticAlgorithm(Properties properties, List<GeneticOperator> operators, Population population, FitnessFunction fitnessFunction, Validator validator) {
        this.properties = properties;
        this.operators = operators;
        this.population = population;
        this.fitnessFunction = fitnessFunction;
        this.validator = validator;
    }

    @Builder
    private static GeneticAlgorithm buildAlgorithm(Properties properties, Selection selection, Crossover crossover, Mutation mutation, Population population, FitnessFunction fitnessFunction) {
        return new GeneticAlgorithm(properties, Arrays.asList(selection, crossover, mutation), population, fitnessFunction, new Validator());
    }

    /* Properties */

    private final Properties properties;

    private final List<GeneticOperator> operators;

    private final Population population;

    private final FitnessFunction fitnessFunction;

    private final Validator validator;

    /* Algorithm variables */

    private int iteration;

    /* Algorithm */

    public void init() {
        operators.stream().filter(operator -> operator.getType().equals(OperatorType.SELECTION))
                .findAny().ifPresent(selection -> ((Selection) selection).setFitnessFunction(fitnessFunction));
        population.populate();

        iteration = 0;
    }

    public void launch() {
        validator.validate(this);

        while (conditions()) {
            operators.stream().sorted(Comparator.comparing(GeneticOperator::getType))
                    .forEach(operator -> operator.apply(population));
        }
    }

    private Boolean conditions() {
        return iteration++ <= properties.getIterations();
    }
}
