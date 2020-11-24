package dev.vozniack.jlearning.genetic.operator.crossover.method.binary;

import dev.vozniack.jlearning.genetic.model.Chromosome;
import dev.vozniack.jlearning.genetic.operator.crossover.Crossover;

import java.util.List;

public class UniformCrossover extends Crossover {

    public UniformCrossover(Double probability) {
        super(probability);
    }

    @Override
    public List<Chromosome> process(List<Chromosome> chromosomes) {
        return null;
    }
}
