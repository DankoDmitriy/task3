package com.danko.shape.repository.impl;

import com.danko.shape.entity.Cone;
import com.danko.shape.entity.ConeParameter;
import com.danko.shape.entity.Warehouse;
import com.danko.shape.exception.ConeException;
import com.danko.shape.repository.ConeSpecification;
import com.danko.shape.service.ConeCalculateService;
import com.danko.shape.service.impl.ConeCalculateServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class ConeAreaRangeSpecification  implements ConeSpecification {
    public static Logger logger = LogManager.getLogger();
    private final double fromArea;
    private final double toArea;

    public ConeAreaRangeSpecification(double fromArea, double toArea) {
        this.fromArea = fromArea;
        this.toArea = toArea;
    }

    @Override
    public boolean specify(Cone cone) {
        double area;
        boolean result = false;
        Warehouse warehouse = Warehouse.getInstance();
        Optional<ConeParameter> optional = warehouse.get(cone.getConeId());
        if (optional.isPresent()) {
            ConeParameter parameter = optional.get();
            area = parameter.getArea();
        } else {
            ConeCalculateService service = new ConeCalculateServiceImpl();
            try {
                area = service.calculateArea(cone);
            } catch (ConeException e) {
                logger.log(Level.ERROR, "Calculation failed: ", e);
                return result;
            }
        }
        result = (area <= toArea && area >= fromArea);
        return result;
    }
}
