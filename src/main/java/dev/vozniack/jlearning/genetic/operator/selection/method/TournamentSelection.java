package dev.vozniack.jlearning.genetic.operator.selection.method;

import dev.vozniack.jlearning.genetic.model.Chromosome;
import dev.vozniack.jlearning.genetic.operator.selection.Selection;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class TournamentSelection extends Selection {

    private final int tournamentSize = 8;

    @Override
    public List<Chromosome> process(List<Chromosome> chromosomes) {
        return null;
    }
}
