package com.danko.shape.service.impl;

import com.danko.shape.entity.Cone;
import com.danko.shape.exception.ConeException;
import com.danko.shape.service.ConeCalculateService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConeCalculateServiceImpl implements ConeCalculateService {
    private static Logger logger = LogManager.getLogger();

    @Override
    public double calculateVolume(Cone cone) throws ConeException {
        if (cone == null) {
            throw new ConeException("Calculation of volume cannot be completed. Argument contains null");
        }
        double volume = 1.0 / 3.0 * cone.getHeight() * Math.PI * Math.pow(Math.abs(cone.getRadius()), 2.0);
        logger.log(Level.INFO, "Calculation of volume is successful. Result is " + volume);
        return volume;
    }

    @Override
    public double calculateLateralSurfaceArea(Cone cone) throws ConeException {
        if (cone == null) {
            throw new ConeException("Calculation of Lateral Surface Area cannot be completed. Argument contains null");
        }
        double area = Math.PI * cone.getRadius() * calculateGeneratrix(cone);
        logger.log(Level.INFO, "Calculation of Lateral Surface Area is successful. Result is " + area);
        return area;
    }

    @Override
    public double calculateArea(Cone cone) throws ConeException {
        if (cone == null) {
            throw new ConeException("Calculation of Area cannot be completed. Argument contains null");
        }
        double area = Math.PI * cone.getRadius() * (calculateGeneratrix(cone) + cone.getRadius());
        logger.log(Level.INFO, "Calculation of Lateral Surface Area is successful. Result is " + area);
        return area;
    }

    private double calculateGeneratrix(Cone cone) {
        return Math.sqrt(Math.pow(cone.getRadius(), 2.0) + Math.pow(cone.getHeight(), 2.0));
    }
}
