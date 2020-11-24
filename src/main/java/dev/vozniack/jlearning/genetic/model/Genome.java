package dev.vozniack.jlearning.genetic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Genome {

    private final int genes;

    private final int geneSize;

    @Setter
    private byte[] bits;

    public Genome copy() {
        return new Genome(genes, geneSize, bits);
    }
}
