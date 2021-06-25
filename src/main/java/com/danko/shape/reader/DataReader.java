package com.danko.shape.reader;

import com.danko.shape.exception.ConeException;
import com.danko.shape.validator.CustomFileValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataReader {
    private static Logger logger = LogManager.getLogger();

    public List<String> reader(String fileAddress) throws ConeException {
        if (!CustomFileValidator.isFileValid(fileAddress)) {
            logger.log(Level.ERROR, "File can not valid...");
            throw new ConeException("File can not valid...");
        }
        logger.log(Level.DEBUG, "File has been validated");
        List<String> arrayList = new ArrayList();

        Path path = Paths.get(fileAddress);
        try (Stream<String> lineStream = Files.lines(path)) {
            arrayList = lineStream.collect(Collectors.toList());
        } catch (IOException e) {
            logger.log(Level.ERROR, "File reade exception");
            throw new ConeException("File reade exception", e);
        }
        logger.log(Level.DEBUG, "File has been read. Result:" + arrayList.toString());
        return arrayList;
    }
}
