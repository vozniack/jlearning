package dev.vozniack.jlearning.genetic.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class Population {

    private final int size;

    private final int genes;

    private final int geneSize;

    @Setter
    private List<Chromosome> chromosomes;

    /* Clone population */

    public List<Chromosome> clonePopulation() {
        return chromosomes.stream().map(Chromosome::copy).collect(Collectors.toList());
    }
}
