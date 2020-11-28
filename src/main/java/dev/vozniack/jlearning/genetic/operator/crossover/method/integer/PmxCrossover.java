package dev.vozniack.jlearning.genetic.operator.crossover.method.integer;

import dev.vozniack.jlearning.genetic.model.Chromosome;
import dev.vozniack.jlearning.genetic.operator.crossover.Crossover;
import dev.vozniack.jlearning.genetic.types.PopulationType;

import java.util.List;

public class PmxCrossover extends Crossover {

    public PmxCrossover(Double probability) {
        super(PopulationType.INTEGER, probability);
    }

    @Override
    public List<Chromosome> process(List<Chromosome> chromosomes) {
        return null;
    }
}
