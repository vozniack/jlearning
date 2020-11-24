package dev.vozniack.jlearning.genetic.operator.crossover;

import dev.vozniack.jlearning.genetic.exception.CrossoverException;
import dev.vozniack.jlearning.genetic.operator.GeneticOperator;
import dev.vozniack.jlearning.genetic.operator.crossover.method.binary.OnePointCrossover;
import dev.vozniack.jlearning.genetic.operator.crossover.method.binary.TwoPointCrossover;
import dev.vozniack.jlearning.genetic.operator.crossover.method.binary.UniformCrossover;
import dev.vozniack.jlearning.genetic.operator.crossover.method.integer.OxCrossover;
import dev.vozniack.jlearning.genetic.operator.crossover.method.integer.PmxCrossover;

public abstract class Crossover extends GeneticOperator {

    public Crossover(Double probability) {
        this.probability = probability;
    }

    /* Properties */

    protected Double probability;

    /* Factory */

    public static Crossover create(CrossoverMethod method, Double probability) {
        switch (method) {
            case ONE_POINT:
                return new OnePointCrossover(probability);

            case TWO_POINT:
                return new TwoPointCrossover(probability);

            case UNIFORM:
                return new UniformCrossover(probability);

            case OX:
                return new OxCrossover(probability);

            case PMX:
                return new PmxCrossover(probability);

            default:
                throw new CrossoverException("How did you throw it?");
        }
    }
}
