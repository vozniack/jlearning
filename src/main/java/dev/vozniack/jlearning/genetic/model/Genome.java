package dev.vozniack.jlearning.genetic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public class Genome {

    private final int genes;

    private final int geneSize;

    @Setter
    private int[] bits;

    public Genome copy() {
        return new Genome(genes, geneSize, Arrays.copyOf(bits, bits.length));
    }
}
