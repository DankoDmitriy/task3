package com.danko.shape.validator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomStringValidator { //FIXME - other logic and REGS
    private static Logger logger = LogManager.getLogger();
    private static final String REG_EXP_VALIDATION_STRING = "\\p{Alpha}+";

    public static boolean isStringValid(String inputString) {
        if (inputString == null || inputString.length() == 0) {
            logger.log(Level.DEBUG, "Input string is empty");
            return false;
        }
        Pattern pattern = Pattern.compile(REG_EXP_VALIDATION_STRING);
        Matcher matcher = pattern.matcher(inputString);
        while (matcher.find()) {
            logger.log(Level.INFO, "String is not valid:-> " + inputString);
            return false;
        }
        logger.log(Level.INFO, "String is valid:-> " + inputString);
        return true;
    }
}
