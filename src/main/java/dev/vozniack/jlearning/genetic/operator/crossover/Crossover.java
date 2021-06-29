package dev.vozniack.jlearning.genetic.operator.crossover;

import dev.vozniack.jlearning.genetic.exception.CrossoverException;
import dev.vozniack.jlearning.genetic.operator.GeneticOperator;
import dev.vozniack.jlearning.genetic.operator.crossover.method.binary.OnePointCrossover;
import dev.vozniack.jlearning.genetic.operator.crossover.method.binary.TwoPointCrossover;
import dev.vozniack.jlearning.genetic.operator.crossover.method.binary.UniformCrossover;
import dev.vozniack.jlearning.genetic.operator.crossover.method.integer.OxCrossover;
import dev.vozniack.jlearning.genetic.operator.crossover.method.integer.PmxCrossover;
import dev.vozniack.jlearning.genetic.types.OperatorType;
import dev.vozniack.jlearning.genetic.types.PopulationType;

public abstract class Crossover extends GeneticOperator {

    protected PopulationType populationType;
    protected Double probability;

    public Crossover(PopulationType populationType, Double probability) {
        this.populationType = populationType;
        this.type = OperatorType.CROSSOVER;
        this.probability = probability;
    }

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
