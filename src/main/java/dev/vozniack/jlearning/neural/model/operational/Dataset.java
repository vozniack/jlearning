package dev.vozniack.jlearning.neural.model.operational;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class Dataset {

    private final Integer inputs;

    private final Integer outputs;

    private final List<Record> records;
}
