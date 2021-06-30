package com.danko.shape.validator;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CustomFileValidatorTest {
    @Test
    public void validateValidFile() {
        String path = "test_data\\data.txt";
        assertTrue(CustomFileValidator.isFileValid(path));
    }

    @Test
    public void validateInvalidFile() {
        String path = "test_data\\dataEmpty.txt";
        assertFalse(CustomFileValidator.isFileValid(path));
    }
}
