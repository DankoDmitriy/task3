package com.danko.shape.validator;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CustomStringValidatorTest {
    @Test
    public void validateValidString() {
        String line = "1.0 1.0 0.0 6.0 4.0";
        assertTrue(CustomStringValidator.isStringValid(line));
    }

    @Test
    public void validateInvalidString() {
        String line = "asd sdf gs ds";
        assertFalse(CustomStringValidator.isStringValid(line));
    }
}
