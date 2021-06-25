package com.danko.shape.observer.impl;

import com.danko.shape.entity.Cone;
import com.danko.shape.entity.ConeParameter;
import com.danko.shape.entity.Warehouse;
import com.danko.shape.exception.ConeException;
import com.danko.shape.observer.ConeEvent;
import com.danko.shape.observer.ConeObserver;
import com.danko.shape.service.impl.ConeCalculateServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConeObserverImpl implements ConeObserver {
    private static Logger logger = LogManager.getLogger();

    @Override
    public void updateParameters(ConeEvent coneEvent) {
        Warehouse warehouse = Warehouse.getInstance();
        ConeCalculateServiceImpl calculationService = new ConeCalculateServiceImpl();
        Cone cone = coneEvent.getSource();
        try {
            double volume = calculationService.calculateVolume(cone);
            double area = calculationService.calculateArea(cone);
            double lateralSurfaceArea = calculationService.calculateLateralSurfaceArea(cone);
            ConeParameter parameter = new ConeParameter(volume, area, lateralSurfaceArea);
            warehouse.put(cone.getConeId(), parameter);
            logger.log(Level.INFO, "Parameters of the Cone has been update", cone);
        } catch (ConeException e) {
            logger.log(Level.ERROR, "Parameters of the Cone has not been update", cone);
        }
    }
}
