package dev.vozniack.jlearning.genetic.algorithm;

import dev.vozniack.jlearning.genetic.fitness.FitnessFunction;
import dev.vozniack.jlearning.genetic.model.Population;
import dev.vozniack.jlearning.genetic.model.Properties;
import dev.vozniack.jlearning.genetic.operator.GeneticOperator;
import dev.vozniack.jlearning.genetic.operator.selection.Selection;
import dev.vozniack.jlearning.genetic.validator.Validator;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class GeneticAlgorithm {

    public GeneticAlgorithm(Properties properties, Selection selection, List<GeneticOperator> operators, Population population, FitnessFunction fitnessFunction, Validator validator) {
        this.properties = properties;
        this.selection = selection;
        this.operators = operators;
        this.population = population;
        this.fitnessFunction = fitnessFunction;
        this.validator = validator;
    }

    @Builder
    private static GeneticAlgorithm buildAlgorithm(Properties properties, Selection selection, List<GeneticOperator> operators, Population population, FitnessFunction fitnessFunction) {
        return new GeneticAlgorithm(properties, selection, operators, population, fitnessFunction, new Validator());
    }

    /* Properties */

    private final Properties properties;

    private final Selection selection;

    private final List<GeneticOperator> operators;

    private final Population population;

    private final FitnessFunction fitnessFunction;

    private final Validator validator;

    /* Algorithm variables */

    private int iteration;

    /* Algorithm */

    public void init() {
        selection.setFitnessFunction(fitnessFunction);
        population.populate();

        iteration = 0;
    }

    public void launch() {
        validator.validate(this);

        while (conditions()) {
            selection.apply(population);
            operators.forEach(operator -> operator.apply(population));
        }
    }

    private Boolean conditions() {
        return iteration++ <= properties.getIterations();
    }
}
