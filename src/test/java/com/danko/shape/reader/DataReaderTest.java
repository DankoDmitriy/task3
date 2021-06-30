package com.danko.shape.reader;

import com.danko.shape.exception.ConeException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DataReaderTest {
    DataReader reader;

    @BeforeClass
    public void createReader() {
        reader = new DataReader();
    }

    @Test
    public void readValidFile() throws ConeException {
        String path = "test_data\\data.txt";
        List<String> listOfStringFromFile = reader.reader(path);
        List<String> expected = Arrays.asList("1.0 1.0 0.0 6.0 4.0",
                "2.0 -1.0 2.0 9.0 5.0",
                "0.0 1.0 2.0 7.0 3.0",
                "asd sdf gs ds",
                "-2.0 2.0 2.0 -3.0 4.0");
        assertEquals(expected, listOfStringFromFile);
    }

    @Test(expectedExceptions = ConeException.class)
    public void readInvalidFile() throws ConeException {
        String path = "test_data\\dataEmpty.txt";
        List<String> listOfStringFromFile = reader.reader(path);
    }

}
