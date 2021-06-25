package com.danko.shape.repository.impl;

import com.danko.shape.entity.Cone;
import com.danko.shape.repository.ConeSpecification;

public class ConeMaxHeightSpecification implements ConeSpecification {
    private final double maxHeight;

    public ConeMaxHeightSpecification(double maxHeight) {
        this.maxHeight = maxHeight;
    }

    @Override
    public boolean specify(Cone cone) {
        double height = cone.getHeight();
        return height <= maxHeight;
    }
}
