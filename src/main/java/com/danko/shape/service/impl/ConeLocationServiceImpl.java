package com.danko.shape.service.impl;

import com.danko.shape.entity.Cone;
import com.danko.shape.excaption.ConeException;
import com.danko.shape.service.ConeLocationService;

public class ConeLocationServiceImpl implements ConeLocationService {
    @Override
    public boolean isBaseOnCoordinateLineXY(Cone cone) throws ConeException {
        if (cone.getCircleCenter().getZ() == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isBaseOnCoordinateLineXZ(Cone cone) throws ConeException {
        if (cone.getCircleCenter().getY() == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isBaseOnCoordinateLineYZ(Cone cone) throws ConeException {
        if (cone.getCircleCenter().getX() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
