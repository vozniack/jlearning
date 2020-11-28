package dev.vozniack.jlearning.genetic.operator.mutation.method.binary;

import dev.vozniack.jlearning.genetic.model.Chromosome;
import dev.vozniack.jlearning.genetic.model.Genome;
import dev.vozniack.jlearning.genetic.model.Population;
import dev.vozniack.jlearning.genetic.operator.GeneticOperator;
import dev.vozniack.jlearning.genetic.types.PopulationType;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FlipBitMutationTest {

    @Test
    public void processMutationTest() {
        int[] oldGenome = new int[]{1, 0, 0, 1, 1, 0};

        Population population = Population.builder()
                .type(PopulationType.BINARY)
                .chromosomes(List.of(new Chromosome(new Genome(2, 3, oldGenome))))
                .build();

        GeneticOperator mutation = new FlipBitMutation(1d);
        mutation.apply(population);

        int[] newGenome = population.getChromosomes().get(0).getGenome().getBits();

        assertNotEquals(Arrays.toString(oldGenome), Arrays.toString(newGenome));

        int differences = 0;

        for (int i = 0; i < oldGenome.length; i++) {
            if (oldGenome[i] != newGenome[i]) {
                differences++;
            }
        }

        assertEquals(1, differences);
    }

    @Test
    public void processNoMutationTest() {
        int[] oldGenome = new int[]{1, 0, 0, 1, 1, 0};

        Population population = Population.builder()
                .type(PopulationType.BINARY)
                .chromosomes(List.of(new Chromosome(new Genome(2, 3, oldGenome))))
                .build();

        GeneticOperator mutation = new FlipBitMutation(0d);
        mutation.apply(population);

        int[] newGenome = population.getChromosomes().get(0).getGenome().getBits();

        assertArrayEquals(oldGenome, newGenome);
    }
}