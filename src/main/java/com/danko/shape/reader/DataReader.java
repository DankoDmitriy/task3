package com.danko.shape.reader;

import com.danko.shape.excaption.ConeException;
import com.danko.shape.validator.CustomFileValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
    private static Logger logger = LogManager.getLogger();

    public List<String> reader(String fileAddress) throws ConeException {
        if (!CustomFileValidator.isFileValid(fileAddress)) {
            logger.log(Level.ERROR, "File can not valid...");
            throw new ConeException("File can not valid...");
        }
        logger.log(Level.DEBUG, "File has been validated");
        List<String> arrayList = new ArrayList();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileAddress));
            String readLine = null;
            while ((readLine = reader.readLine()) != null) {
                arrayList.add(readLine);
            }
        } catch (IOException e) {
            logger.log(Level.ERROR, "File reade exception");
            throw new ConeException("File reade exception");
        }
        logger.log(Level.DEBUG, "File has been read. Result:" + arrayList.toString());
        return arrayList;
    }
}
