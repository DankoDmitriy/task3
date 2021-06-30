package com.danko.shape.validator;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ConeValidatorTest {
    @Test
    public void validateValidCone() {
        List<Double> parameters = Arrays.asList(1.0, 1.0, 0.0, 6.0, 4.0);
        assertTrue(ConeValidator.isParametersValid(parameters));
    }

    @Test
    public void validateInvalidCone() {
        List<Double> parameters = Arrays.asList(1.0, 1.0, 0.0, -6.0, 4.0);
        assertFalse(ConeValidator.isParametersValid(parameters));
    }
}
