package dev.vozniack.jlearning.genetic.fitness;

import dev.vozniack.jlearning.genetic.model.Genome;

public interface FitnessFunction {

    Double countFitness(Genome genome);
}
