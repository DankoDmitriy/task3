package com.danko.shape.service.impl;

import com.danko.shape.entity.Cone;
import com.danko.shape.entity.Point;
import com.danko.shape.exception.ConeException;
import com.danko.shape.service.ConeCalculateService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ConeCalculateServiceImplTest {
    private ConeCalculateService service;
    private Cone cone;
    private static final double EXPECTED_VOLUME = 3.141592653589793;
    private static final double EXPECTED_AREA = 13.076180919385896;
    private static final double EXPECTED_LATERAL_SURFACE_AREA = 9.934588265796101;

    @BeforeClass
    public void createCalculateService() throws ConeException {
        service = new ConeCalculateServiceImpl();
        cone = new Cone(new Point(1.0, 1.0, 0.0), 1.0, 3.0);
    }

    @Test
    public void calculateVolumeTest() throws ConeException {
        double volume = service.calculateVolume(cone);
        assertEquals(volume, EXPECTED_VOLUME);
    }

    @Test
    public void calculateLateralSurfaceAreaTest() throws ConeException {
        double lateralSurfaceArea = service.calculateLateralSurfaceArea(cone);
        assertEquals(lateralSurfaceArea, EXPECTED_LATERAL_SURFACE_AREA);
    }

    @Test
    public void calculateAreaTest() throws ConeException {
        double area = service.calculateArea(cone);
        assertEquals(area, EXPECTED_AREA);
    }
}
