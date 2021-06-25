package com.danko.shape.validator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomStringValidator { //FIXME - REGS
    private static Logger logger = LogManager.getLogger();
    private static final String REG_EXP_NOT_VALIDATION_STRING = "\\p{Alpha}+";

    //FIXME  isBlank() -- String  in java 11.
    public static boolean isStringValid(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            logger.log(Level.DEBUG, "Input string is empty");
            return false;
        }
        Pattern pattern = Pattern.compile(REG_EXP_NOT_VALIDATION_STRING);
        Matcher matcher = pattern.matcher(inputString);
        while (!matcher.find()) {
            logger.log(Level.INFO, "String is valid:-> " + inputString);
            return true;
        }
        logger.log(Level.INFO, "String is not valid:-> " + inputString);
        return true;
    }
}
