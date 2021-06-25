package com.danko.shape.service;

import com.danko.shape.entity.Cone;
import com.danko.shape.exception.ConeException;

public interface ConeLocationService {
    boolean isBaseOnCoordinateLineXY(Cone cone) throws ConeException;

    boolean isBaseOnCoordinateLineXZ(Cone cone) throws ConeException;

    boolean isBaseOnCoordinateLineYZ(Cone cone) throws ConeException;
}
