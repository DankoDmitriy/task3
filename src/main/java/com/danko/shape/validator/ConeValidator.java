package com.danko.shape.validator;

import java.util.List;

public class ConeValidator {
    private static final int RADIUS_INDEX = 3;

    public static boolean isParametersValid(List<Double> cone) {
        if (cone.get(RADIUS_INDEX) > 0) {
            return true;
        }
        return false;
    }
}
