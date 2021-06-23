package com.danko.shape.factory;

import com.danko.shape.entity.Cone;
import com.danko.shape.entity.Point;
import com.danko.shape.excaption.ConeException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ConeFactory {
    private static Logger logger = LogManager.getLogger();
    private static final int VALID_COUNT_DATA = 6;

    public static Cone createCone(List<Double> parameters) throws ConeException {
        if (parameters == null || parameters.size() != VALID_COUNT_DATA) {
            throw new ConeException("Unable to create Cone object." + "Argument contains null or wrong number of parameters.");
        }
        Point circleCenter = new Point(parameters.get(0), parameters.get(1), parameters.get(2));
        Cone cone = new Cone(circleCenter, parameters.get(3), parameters.get(4), parameters.get(5));
        logger.log(Level.INFO, "Cone is created successfully: " + cone);
        return cone;
    }

    public static List<Cone> createListOfCones(List<double[]> parameters) throws ConeException {
        if (parameters == null || parameters.isEmpty()) {
            throw new ConeException("Unable to create Cone object. Argument contains null or empty.");
        }
        List<Cone> listOfCones = new ArrayList<>();

        for (double[] parameter : parameters) {
            Point circleCenter = new Point(parameter[0], parameter[1], parameter[2]);
            Cone cone = new Cone(circleCenter, parameter[3], parameter[4], parameter[5]);
            listOfCones.add(cone);
            logger.log(Level.DEBUG, "Has been made cone...");
        }
        logger.log(Level.INFO, "List of Cones is created successfully.");
        return listOfCones;
    }
}
