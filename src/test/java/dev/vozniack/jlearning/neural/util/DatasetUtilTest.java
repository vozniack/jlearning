package dev.vozniack.jlearning.neural.util;

import dev.vozniack.jlearning.neural.exception.DatasetException;
import dev.vozniack.jlearning.neural.model.operational.Dataset;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class DatasetUtilTest {
    private final static String FILENAME = "src/test/resources/jLearning.csv";
    private final static String FILENAME_INCORRECT_META = "src/test/resources/jLearning_incorrectMeta.csv";
    private final static String FILENAME_INCORRECT_VALUE = "src/test/resources/jLearning_incorrectValue.csv";

    @Test
    public void createDatasetFromFileTest() throws IOException {
        File file = new File(FILENAME);

        Dataset dataset = DatasetUtil.create(file, ";");

        assertEquals(2, dataset.getInputs().intValue());
        assertEquals(4, dataset.getOutputs().intValue());
        assertEquals(2, dataset.getRecords().size());

        assertEquals("[0.25, -0.75]", dataset.getRecords().get(0).getInputs().toString());
        assertEquals("[-0.25, 0.75]", dataset.getRecords().get(1).getInputs().toString());

        assertEquals("[1.0, 0.5, 1.0, 0.0]", dataset.getRecords().get(0).getOutputs().toString());
        assertEquals("[-1.0, -0.5, -1.0, 0.0]", dataset.getRecords().get(1).getOutputs().toString());
    }

    @Test
    public void createDatasetFromInputStreamTest() throws FileNotFoundException {
        InputStream inputStream = new FileInputStream(new File(FILENAME));

        Dataset dataset = DatasetUtil.create(inputStream, ";");

        assertEquals(2, dataset.getInputs().intValue());
        assertEquals(4, dataset.getOutputs().intValue());
        assertEquals(2, dataset.getRecords().size());

        assertEquals("[0.25, -0.75]", dataset.getRecords().get(0).getInputs().toString());
        assertEquals("[-0.25, 0.75]", dataset.getRecords().get(1).getInputs().toString());

        assertEquals("[1.0, 0.5, 1.0, 0.0]", dataset.getRecords().get(0).getOutputs().toString());
        assertEquals("[-1.0, -0.5, -1.0, 0.0]", dataset.getRecords().get(1).getOutputs().toString());
    }

    @Test
    public void readFileWithIncorrectMetadataTest() {
        File file = new File(FILENAME_INCORRECT_META);

        DatasetException datasetException = assertThrows(DatasetException.class, () -> DatasetUtil.create(file, ";"));
        assertEquals("First row should contain correct metadata", datasetException.getMessage());
    }

    @Test
    public void readFileWithIncorrectValuesTest() {
        File file = new File(FILENAME_INCORRECT_VALUE);

        DatasetException datasetException = assertThrows(DatasetException.class, () -> DatasetUtil.create(file, ";"));
        assertEquals("Incorrect data in row 2", datasetException.getMessage());
    }
}
