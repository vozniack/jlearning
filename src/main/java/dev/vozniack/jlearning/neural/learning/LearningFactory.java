package dev.vozniack.jlearning.neural.learning;

import dev.vozniack.jlearning.neural.types.LearningType;

public class LearningFactory {

    public static Learning createLearning(LearningType learningType, Integer iterations, Double tolerance, Double factor, Boolean shuffleRecords) {
        switch (learningType) {
            case BACKPROPAGATION:
                return Backpropagation.builder()
                        .iterations(iterations)
                        .tolerance(tolerance)
                        .factor(factor)
                        .shuffleRecords(shuffleRecords)
                        .build();

            default:
                throw new RuntimeException();
        }
    }
}
