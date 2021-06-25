package com.danko.shape.parser;

import com.danko.shape.exception.ConeException;
import com.danko.shape.validator.ConeValidator;
import com.danko.shape.validator.CustomStringValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConeParser {
    private static Logger logger = LogManager.getLogger();
    private static final String REG_EXP_STRING_FOR_DOUBLE = "\\s?(-?\\d+\\.\\d+)";
    private static final int VALID_COUNT_DATA = 5;

    public List<double[]> parseStringToDouble(List<String> inputArrayString) throws ConeException {
        if (inputArrayString == null || inputArrayString.size() == 0) {
            logger.log(Level.ERROR, "Input ArrayList is empty or size is zero");
            throw new ConeException("Input ArrayList is empty or size is zero");
        }
        Pattern pattern = Pattern.compile(REG_EXP_STRING_FOR_DOUBLE);
        List<double[]> cones = new ArrayList<double[]>();
        for (String s : inputArrayString) {
            List<Double> coneTMP = new ArrayList<Double>();
            int counter = 0;
            if (CustomStringValidator.isStringValid(s)) {
                Matcher matcher = pattern.matcher(s);
                while (matcher.find()) {
                    counter++;
                    coneTMP.add(Double.valueOf(matcher.group(1)));
                }
            }
            if (counter == VALID_COUNT_DATA) {
                if (ConeValidator.isParametersValid(coneTMP)) {
                    cones.add(coneTMP.stream().mapToDouble(Double::doubleValue).toArray());
                }
            }
        }
        if (cones.size() == 0) {
            logger.log(Level.ERROR, "There was no correct information in the data");
            throw new ConeException("There was no correct information in the data");
        }
        logger.log(Level.INFO, "List of Parameters for make Cones has been created.");
        return cones;
    }
}
