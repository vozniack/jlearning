package dev.vozniack.jlearning.genetic.operator.crossover.method.integer;

import dev.vozniack.jlearning.genetic.model.Chromosome;
import dev.vozniack.jlearning.genetic.operator.crossover.Crossover;

import java.util.List;

public class OxCrossover extends Crossover {

    public OxCrossover(Double probability) {
        super(probability);
    }

    @Override
    public List<Chromosome> process(List<Chromosome> chromosomes) {
        return null;
    }
}
