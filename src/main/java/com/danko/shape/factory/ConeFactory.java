package com.danko.shape.factory;

import com.danko.shape.entity.Cone;
import com.danko.shape.entity.Point;
import com.danko.shape.exception.ConeException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ConeFactory {
    private static Logger logger = LogManager.getLogger();
    private static final int VALID_COUNT_DATA = 5;

    public static Cone createCone(double[] parameters) throws ConeException {
        if (parameters == null || parameters.length != VALID_COUNT_DATA) {
            throw new ConeException("Unable to create Cone object." + "Argument contains null or wrong number of parameters.");
        }
        Point circleCenter = new Point(parameters[0], parameters[1], parameters[2]);
        Cone cone = new Cone(circleCenter, parameters[3], parameters[4]);
        logger.log(Level.INFO, "Cone is created successfully: " + cone);
        return cone;
    }

    public static List<Cone> createListOfCones(List<double[]> parameters) throws ConeException {
        if (parameters == null || parameters.isEmpty()) {
            throw new ConeException("Unable to create Cone object. Argument contains null or empty.");
        }
        List<Cone> listOfCones = new ArrayList<>();
        for (double[] parameter : parameters) {
            Cone cone = createCone(parameter);
            listOfCones.add(cone);
            logger.log(Level.DEBUG, "Has been made cone..." + cone);
        }
        logger.log(Level.INFO, "List of Cones is created successfully.");
        return listOfCones;
    }
}
