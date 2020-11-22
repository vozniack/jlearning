package dev.vozniack.jlearning.neural.util;

import dev.vozniack.jlearning.neural.exception.DatasetException;
import dev.vozniack.jlearning.neural.model.operational.Dataset;
import dev.vozniack.jlearning.neural.model.operational.Record;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DatasetUtil {

    public static Dataset create(File file, String separator) throws IOException {
        return create(Files.readAllLines(Paths.get(file.getPath()), StandardCharsets.UTF_8), separator);
    }

    public static Dataset create(InputStream inputStream, String separator) {
        return create(new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)).lines().collect(Collectors.toList()), separator);
    }

    private static Dataset create(List<String> lines, String separator) {
        String[] firstLineValues = lines.get(0).split(separator);

        if (firstLineValues.length != 3) {
            throw new DatasetException("First row should contain correct metadata");
        }

        Integer inputs = Integer.valueOf(lines.get(0).split(separator)[1]);
        Integer outputs = Integer.valueOf(lines.get(0).split(separator)[2]);

        List<Record> records = new ArrayList<>();

        for (int i = 1; i < lines.size(); i++) {
            records.add(Record.builder()
                    .inputs(getValues(lines.get(i), separator, 0, inputs, inputs + outputs, i))
                    .outputs(getValues(lines.get(i), separator, inputs, inputs + outputs, inputs + outputs, i))
                    .build());
        }

        return Dataset.builder()
                .inputs(inputs)
                .outputs(outputs)
                .records(records)
                .build();
    }

    private static List<Double> getValues(String line, String separator, int start, int stop, int size, int row) {
        String[] stringValues = line.split(separator);

        if (stringValues.length < size) {
            throw new DatasetException("Incorrect data in row " + row);
        }

        List<Double> values = new ArrayList<>();

        for (int i = start; i < stop; i++) {
            values.add(Double.valueOf(stringValues[i]));
        }

        return values;
    }
}
