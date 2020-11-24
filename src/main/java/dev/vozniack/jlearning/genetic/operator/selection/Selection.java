package dev.vozniack.jlearning.genetic.operator.selection;

import dev.vozniack.jlearning.genetic.exception.SelectionException;
import dev.vozniack.jlearning.genetic.fitness.FitnessFunction;
import dev.vozniack.jlearning.genetic.model.Population;
import dev.vozniack.jlearning.genetic.operator.GeneticOperator;
import dev.vozniack.jlearning.genetic.operator.selection.method.*;
import lombok.Setter;

public abstract class Selection extends GeneticOperator {

    @Setter
    protected FitnessFunction fitnessFunction;

    @Override
    public void apply(Population population) {
        population.getChromosomes().forEach(chromosome -> chromosome.setFitness(fitnessFunction.countFitness(chromosome.getGenome())));
        population.setChromosomes(process(population.clonePopulation()));
    }

    /* Factory (creates selection with default parameters) */

    public static Selection create(SelectionMethod method) {
        switch (method) {
            case TOURNAMENT:
                return new TournamentSelection();

            case ROULETTE:
                return new RouletteSelection();

            case RANK:
                return new RankSelection();

            case ELITISM:
                return new ElitismSelection();

            case STEADY_STATE:
                return new SteadyStateSelection();

            default:
                throw new SelectionException("How did you throw it?");
        }
    }
}
