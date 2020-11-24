package dev.vozniack.jlearning.genetic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Chromosome {

    public Chromosome(Genome genome) {
        this.genome = genome;
    }

    private Genome genome;

    private double fitness = 0d;

    private double distribution = 0d;

    private double percent = 0d;

    /* Copy */

    public Chromosome copy() {
        return new Chromosome(genome.copy(), fitness, distribution, percent);
    }
}
