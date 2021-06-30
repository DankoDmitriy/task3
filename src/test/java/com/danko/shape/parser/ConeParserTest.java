package com.danko.shape.parser;

import com.danko.shape.exception.ConeException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ConeParserTest {
    private ConeParser parser;

    @BeforeClass
    public void createParser() {
        parser = new ConeParser();
    }

    @DataProvider(name = "valid_data")
    public Object[][] coneValidDataCreate() throws ConeException {
        return new Object[][]{
                {Arrays.asList("1.0 1.0 0.0 6.0 4.0"), new double[]{1.0, 1.0, 0.0, 6.0, 4.0}},
                {Arrays.asList("2.0 -1.0 2.0 9.0 5.0"), new double[]{2.0, -1.0, 2.0, 9.0, 5.0}}
        };
    }

    @DataProvider(name = "invalid_data")
    public Object[] coneInvalidDataCreate() throws ConeException {
        return new Object[]{
                Arrays.asList("1.0 1.0 0.0x 6.0 4.0"),
                Arrays.asList("1.0c 1.0 0.0 6.0 4.0")
        };
    }

    @Test(dataProvider = "invalid_data", expectedExceptions = ConeException.class)
    public void parseConeTest(List<String> line) throws ConeException {
        parser.parseStringToDouble(line);
    }

    @Test(dataProvider = "valid_data")
    public void parseConeTest(List<String> line, double[] expected) throws ConeException {
        List<double[]> parsedList = parser.parseStringToDouble(line);
        assertEquals(parsedList.get(0), expected);
    }
}
