package com.danko.shape.service;

import com.danko.shape.entity.Cone;
import com.danko.shape.excaption.ConeException;

public interface ConeCalculateService {
    double calculateVolume(Cone cone) throws ConeException;

    double calculateLateralSurfaceArea(Cone cone) throws ConeException;

    double calculateArea(Cone cone) throws ConeException;
}
