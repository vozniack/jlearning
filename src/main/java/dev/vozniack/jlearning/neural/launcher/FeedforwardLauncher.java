package dev.vozniack.jlearning.neural.launcher;

import dev.vozniack.jlearning.neural.model.structure.Neuron;
import dev.vozniack.jlearning.neural.structure.Structure;
import dev.vozniack.jlearning.neural.util.NetworkUtil;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class FeedforwardLauncher implements Launcher {
    private final Structure structure;

    @Override
    public List<Double> launch(List<Double> input) {
        NetworkUtil.initInput(structure, input);
        NetworkUtil.countOutputs(structure);

        return structure.getLayers().getLast().getNeurons().stream().map(Neuron::getOutput).collect(Collectors.toList());
    }
}
