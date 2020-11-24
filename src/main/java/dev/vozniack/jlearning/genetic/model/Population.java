package dev.vozniack.jlearning.genetic.model;

import dev.vozniack.jlearning.genetic.types.PopulationType;
import dev.vozniack.jlearning.genetic.util.PopulationGenerator;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class Population {

    private final PopulationType type;

    private final int size;

    private final int genes;

    private final int geneSize;

    @Setter
    private List<Chromosome> chromosomes;

    /* Clone population */

    public void populate() {
        chromosomes = PopulationGenerator.generate(type, size, genes, geneSize);
    }

    public List<Chromosome> clonePopulation() {
        return chromosomes.stream().map(Chromosome::copy).collect(Collectors.toList());
    }
}
