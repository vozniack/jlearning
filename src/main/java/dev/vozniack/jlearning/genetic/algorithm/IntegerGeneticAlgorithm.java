package dev.vozniack.jlearning.genetic.algorithm;

import dev.vozniack.jlearning.genetic.fitness.FitnessFunction;
import dev.vozniack.jlearning.genetic.model.Population;
import dev.vozniack.jlearning.genetic.model.Properties;
import dev.vozniack.jlearning.genetic.operator.GeneticOperator;
import dev.vozniack.jlearning.genetic.operator.selection.Selection;
import dev.vozniack.jlearning.genetic.validator.IntegerValidator;
import lombok.Builder;

import java.util.List;

public class IntegerGeneticAlgorithm extends GeneticAlgorithm {

    public IntegerGeneticAlgorithm(Properties properties, Selection selection, List<GeneticOperator> operators, Population population, FitnessFunction fitnessFunction) {
        super(properties, selection, operators, population, fitnessFunction, new IntegerValidator());
    }

    @Builder
    private static IntegerGeneticAlgorithm buildAlgorithm(Properties properties, Selection selection, List<GeneticOperator> operators, Population population, FitnessFunction fitnessFunction) {
        return new IntegerGeneticAlgorithm(properties, selection, operators, population, fitnessFunction);
    }

    @Override
    public void init() {

    }

    @Override
    public void launch() {

    }
}
