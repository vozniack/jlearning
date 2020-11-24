package dev.vozniack.jlearning.genetic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Chromosome {

    private Genome genome;

    private double fitness;

    private double distribution;

    private double percent;

    /* Copy */

    public Chromosome copy() {
        return new Chromosome(genome.copy(), fitness, distribution, percent);
    }
}
