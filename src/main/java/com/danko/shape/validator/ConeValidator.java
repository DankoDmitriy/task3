package com.danko.shape.validator;

import java.util.List;

public class ConeValidator {
    private static final int RADIUS_INDEX = 3;
    private static final int HEIGHT_INDEX = 4;
    private static final int GENERATRIX_INDEX = 5;

    public static boolean isParametersValid(List<Double> cone) {
        if (cone.get(RADIUS_INDEX) <= 0) {
            return false;
        }
        return (Math.pow(cone.get(RADIUS_INDEX), 2) + Math.pow(cone.get(HEIGHT_INDEX), 2)) == Math.pow(cone.get(GENERATRIX_INDEX), 2) ? true : false;
    }
}
