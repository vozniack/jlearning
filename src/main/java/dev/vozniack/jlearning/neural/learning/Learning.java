package dev.vozniack.jlearning.neural.learning;

import dev.vozniack.jlearning.neural.model.operational.Dataset;
import dev.vozniack.jlearning.neural.network.NeuralNetwork;
import lombok.Getter;
import lombok.Setter;

public abstract class Learning {

    public Learning(Integer iterations, Double tolerance, Double factor, Boolean shuffleRecords) {
        this.iterations = iterations;
        this.tolerance = tolerance;
        this.factor = factor;
        this.shuffleRecords = shuffleRecords;
    }

    /* Network */

    @Setter
    protected NeuralNetwork neuralNetwork;

    /* Status */

    protected Integer iteration;

    /* Settings */

    @Getter
    protected Integer iterations = 1024;

    @Getter
    protected Double tolerance = 0.1;

    @Getter
    protected Double factor = 0.2;

    @Getter
    protected Boolean shuffleRecords = false;

    /* To implement */

    public abstract void learn(Dataset dataset);
}
