package dev.vozniack.jlearning.genetic.util;

import dev.vozniack.jlearning.genetic.exception.GeneticException;
import dev.vozniack.jlearning.genetic.model.Chromosome;
import dev.vozniack.jlearning.genetic.model.Genome;
import dev.vozniack.jlearning.genetic.types.PopulationType;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PopulationGenerator {

    public static List<Chromosome> generate(PopulationType type, int size, int genes, int geneSize) {
        return IntStream.range(0, size)
                .mapToObj(i -> new Chromosome(new Genome(genes, geneSize, buildGenome(type, genes, geneSize))))
                .collect(Collectors.toList());
    }

    private static int[] buildGenome(PopulationType type, int genes, int geneSize) {
        switch (type) {
            case BINARY:
                return buildBinaryPopulation(genes, geneSize);

            case INTEGER:
                return buildIntegerPopulation(genes, geneSize);

            default:
                throw new GeneticException("How did you throw it?");
        }
    }

    private static int[] buildBinaryPopulation(int genes, int geneSize) {
        List<Integer> bits = IntStream.range(0, genes * geneSize).map(i -> RandUtil.randomBit()).boxed().collect(Collectors.toList());
        return bits.stream().mapToInt(bit -> bit).toArray();
    }

    private static int[] buildIntegerPopulation(int genes, int geneSize) {
        List<Integer> bits = IntStream.range(1, (genes * geneSize) + 1).boxed().collect(Collectors.toList());
        Collections.shuffle(bits);

        return bits.stream().mapToInt(bit -> bit).toArray();
    }
}
