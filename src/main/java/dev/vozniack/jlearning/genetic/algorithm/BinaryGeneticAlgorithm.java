package dev.vozniack.jlearning.genetic.algorithm;

import dev.vozniack.jlearning.genetic.fitness.FitnessFunction;
import dev.vozniack.jlearning.genetic.model.Population;
import dev.vozniack.jlearning.genetic.model.Properties;
import dev.vozniack.jlearning.genetic.operator.GeneticOperator;
import dev.vozniack.jlearning.genetic.operator.selection.Selection;
import dev.vozniack.jlearning.genetic.validator.BinaryValidator;
import lombok.Builder;

import java.util.List;

public class BinaryGeneticAlgorithm extends GeneticAlgorithm {

    public BinaryGeneticAlgorithm(Properties properties, Selection selection, List<GeneticOperator> operators, Population population, FitnessFunction fitnessFunction) {
        super(properties, selection, operators, population, fitnessFunction, new BinaryValidator());
    }

    @Builder
    private static BinaryGeneticAlgorithm buildAlgorithm(Properties properties, Selection selection, List<GeneticOperator> operators, Population population, FitnessFunction fitnessFunction) {
        return new BinaryGeneticAlgorithm(properties, selection, operators, population, fitnessFunction);
    }

    @Override
    public void init() {
        selection.setFitnessFunction(fitnessFunction);
        iteration = 0;
    }

    @Override
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
