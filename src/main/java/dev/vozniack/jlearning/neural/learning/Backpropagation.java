package dev.vozniack.jlearning.neural.learning;

import lombok.Builder;

public class Backpropagation extends Learning {

    public Backpropagation(Integer iterations, Double tolerance, Double factor) {
        super(iterations, tolerance, factor);
    }

    @Builder
    public static Backpropagation buildLearning(Integer iterations, Double tolerance, Double factor) {
        return new Backpropagation(iterations, tolerance, factor);
    }

    @Override
    public void learn() {

    }
}
