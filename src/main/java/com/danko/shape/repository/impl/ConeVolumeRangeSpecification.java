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

public class ConeVolumeRangeSpecification implements ConeSpecification {
    public static Logger logger = LogManager.getLogger();
    private final double fromVolume;
    private final double toVolume;

    public ConeVolumeRangeSpecification(double fromVolume, double toVolume) {
        this.fromVolume = fromVolume;
        this.toVolume = toVolume;
    }

    @Override
    public boolean specify(Cone cone) {
        double volume;
        boolean result = false;
        Warehouse warehouse = Warehouse.getInstance();
        Optional<ConeParameter> optional = warehouse.get(cone.getConeId());
        if (optional.isPresent()) {
            ConeParameter parameter = optional.get();
            volume = parameter.getVolume();
        } else {
            ConeCalculateService service = new ConeCalculateServiceImpl();
            try {
                volume = service.calculateVolume(cone);
            } catch (ConeException e) {
                logger.log(Level.ERROR, "Calculation failed: ", e);
                return result;
            }
        }
        result = (volume <= toVolume && volume >= fromVolume);
        return result;
    }
}
