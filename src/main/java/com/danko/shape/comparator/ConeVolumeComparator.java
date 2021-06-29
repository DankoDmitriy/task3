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

public class ConeVolumeComparator implements Comparator<Cone> {
    private static Logger logger = LogManager.getLogger();

    @Override
    public int compare(Cone o1, Cone o2) {
        double volume1 = 0;
        double volume2 = 0;
        int result = 0;
        Warehouse warehouse = Warehouse.getInstance();
        Optional<ConeParameter> parametersCone1 = warehouse.get(o1.getConeId());
        Optional<ConeParameter> parametersCone2 = warehouse.get(o2.getConeId());
        if (parametersCone1.isPresent()) {
            ConeParameter parameter1 = parametersCone1.get();
            volume1 = parameter1.getVolume();
        } else {
            ConeCalculateService service = new ConeCalculateServiceImpl();
            try {
                volume1 = service.calculateVolume(o1);
            } catch (ConeException e) {
                logger.log(Level.ERROR, "Calculation error: ", e);
                return -1;
            }
        }
        if (parametersCone2.isPresent()) {
            ConeParameter parameter2 = parametersCone2.get();
            volume2 = parameter2.getVolume();
        } else {
            ConeCalculateService service = new ConeCalculateServiceImpl();
            try {
                volume2 = service.calculateVolume(o2);
            } catch (ConeException e) {
                logger.log(Level.ERROR, "Calculation error: ", e);
                return 1;
            }
        }
        result = Double.compare(volume1, volume2);
        return result;
    }
}
