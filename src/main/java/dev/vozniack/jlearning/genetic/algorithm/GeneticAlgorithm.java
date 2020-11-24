package dev.vozniack.jlearning.genetic.algorithm;

import dev.vozniack.jlearning.genetic.fitness.FitnessFunction;
import dev.vozniack.jlearning.genetic.model.Population;
import dev.vozniack.jlearning.genetic.model.Properties;
import dev.vozniack.jlearning.genetic.operator.GeneticOperator;
import dev.vozniack.jlearning.genetic.operator.selection.Selection;
import dev.vozniack.jlearning.genetic.validator.Validator;
import lombok.Getter;

import java.util.List;

@Getter
public abstract class GeneticAlgorithm {

    public GeneticAlgorithm(Properties properties, Selection selection, List<GeneticOperator> operators, Population population, FitnessFunction fitnessFunction, Validator validator) {
        this.properties = properties;
        this.selection = selection;
        this.operators = operators;
        this.population = population;
        this.fitnessFunction = fitnessFunction;
        this.validator = validator;
    }

    /* Properties */

    protected Properties properties;

    protected Selection selection;

    protected List<GeneticOperator> operators;

    protected Population population;

    protected FitnessFunction fitnessFunction;

    protected Validator validator;

    /* Algorithm variables */

    protected int iteration;

    /* Algorithm */

    public abstract void init();

    public abstract void launch();
}
