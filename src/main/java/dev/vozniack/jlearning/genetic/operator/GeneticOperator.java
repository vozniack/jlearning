package dev.vozniack.jlearning.genetic.operator;

import dev.vozniack.jlearning.genetic.model.Chromosome;
import dev.vozniack.jlearning.genetic.model.Population;

import java.util.List;

public abstract class GeneticOperator {

    public void apply(Population population) {
        population.setChromosomes(process(population.clonePopulation()));
    }

    /* To implement */

    public abstract List<Chromosome> process(List<Chromosome> chromosomes);
}
