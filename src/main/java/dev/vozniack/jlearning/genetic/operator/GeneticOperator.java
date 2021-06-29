package dev.vozniack.jlearning.genetic.operator;

import dev.vozniack.jlearning.genetic.model.Chromosome;
import dev.vozniack.jlearning.genetic.model.Population;
import dev.vozniack.jlearning.genetic.types.OperatorType;
import lombok.Getter;

import java.util.List;

public abstract class GeneticOperator {

    @Getter
    protected OperatorType type;

    public void apply(Population population) {
        population.setChromosomes(process(population.clonePopulation()));
    }

    /* To implement */

    public abstract List<Chromosome> process(List<Chromosome> chromosomes);
}
