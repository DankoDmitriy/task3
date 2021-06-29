package com.danko.shape.comparator;

import com.danko.shape.entity.Cone;
import com.danko.shape.entity.ConeParameter;
import com.danko.shape.entity.Warehouse;
import com.danko.shape.exception.ConeException;
import com.danko.shape.service.ConeCalculateService;
import com.danko.shape.service.impl.ConeCalculateServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;
import java.util.Optional;

public class ConeLateralSurfaceAreaComparator implements Comparator<Cone> {
    private static Logger logger = LogManager.getLogger();

    @Override
    public int compare(Cone o1, Cone o2) {
        double lateralSurfaceArea1 = 0;
        double lateralSurfaceArea2 = 0;
        int result = 0;
        Warehouse warehouse = Warehouse.getInstance();
        Optional<ConeParameter> parametersCone1 = warehouse.get(o1.getConeId());
        Optional<ConeParameter> parametersCone2 = warehouse.get(o2.getConeId());
        if (parametersCone1.isPresent()) {
            ConeParameter parameter1 = parametersCone1.get();
            lateralSurfaceArea1 = parameter1.getArea();
        } else {
            ConeCalculateService service = new ConeCalculateServiceImpl();
            try {
                lateralSurfaceArea1 = service.calculateLateralSurfaceArea(o1);
            } catch (ConeException e) {
                logger.log(Level.ERROR, "Calculation error: ", e);
                return -1;
            }
        }
        if (parametersCone2.isPresent()) {
            ConeParameter parameter2 = parametersCone2.get();
            lateralSurfaceArea2 = parameter2.getArea();
        } else {
            ConeCalculateService service = new ConeCalculateServiceImpl();
            try {
                lateralSurfaceArea2 = service.calculateLateralSurfaceArea(o2);
            } catch (ConeException e) {
                logger.log(Level.ERROR, "Calculation error: ", e);
                return 1;
            }
        }
        result = Double.compare(lateralSurfaceArea1, lateralSurfaceArea2);
        return result;
    }
}
