package dev.vozniack.jlearning.genetic.operator.crossover.method.binary;

import dev.vozniack.jlearning.genetic.model.Chromosome;
import dev.vozniack.jlearning.genetic.operator.crossover.Crossover;
import dev.vozniack.jlearning.genetic.types.PopulationType;

import java.util.List;

public class TwoPointCrossover extends Crossover {

    public TwoPointCrossover(Double probability) {
        super(PopulationType.BINARY, probability);
    }

    @Override
    public List<Chromosome> process(List<Chromosome> chromosomes) {
        return null;
    }
}
