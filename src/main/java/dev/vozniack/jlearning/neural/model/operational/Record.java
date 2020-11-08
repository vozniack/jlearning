package dev.vozniack.jlearning.neural.model.operational;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class Record {

    private final List<Double> inputValues;

    private final List<Double> correctOutput;
}
