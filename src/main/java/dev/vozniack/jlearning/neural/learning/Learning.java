package dev.vozniack.jlearning.neural.learning;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Learning {

    protected Integer iterations;

    protected Double tolerance;

    protected Double factor;

    public abstract void learn();
}
