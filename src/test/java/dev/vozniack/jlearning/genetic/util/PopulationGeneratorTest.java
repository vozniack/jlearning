package dev.vozniack.jlearning.genetic.util;

import dev.vozniack.jlearning.genetic.model.Chromosome;
import dev.vozniack.jlearning.genetic.model.Genome;
import dev.vozniack.jlearning.genetic.types.PopulationType;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PopulationGeneratorTest {

    @Test
    public void generateBinaryPopulation() {
        List<Chromosome> chromosomes = PopulationGenerator.generate(PopulationType.BINARY, 8, 4, 3);

        assertEquals(chromosomes.size(), 8);

        chromosomes.forEach(chromosome -> {
            Genome genome = chromosome.getGenome();

            assertEquals(4, genome.getGenes());
            assertEquals(3, genome.getGeneSize());
            assertEquals(12, genome.getBits().length);

            for (int bit : genome.getBits()) {
                assertTrue(bit == 0 || bit == 1);
            }
        });
    }

    @Test
    public void generateIntegerPopulation() {
        List<Chromosome> chromosomes = PopulationGenerator.generate(PopulationType.INTEGER, 8, 4, 3);

        assertEquals(chromosomes.size(), 8);

        chromosomes.forEach(chromosome -> {
            Genome genome = chromosome.getGenome();

            assertEquals(4, genome.getGenes());
            assertEquals(3, genome.getGeneSize());
            assertEquals(12, genome.getBits().length);

            int[] sortedBits = Arrays.stream(genome.getBits()).sorted().toArray();

            for (int i = 0; i < sortedBits.length; i++) {
                assertEquals(i + 1, sortedBits[i]);
            }
        });
    }
}