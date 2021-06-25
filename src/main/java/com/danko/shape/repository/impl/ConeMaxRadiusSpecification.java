package com.danko.shape.repository.impl;

import com.danko.shape.entity.Cone;
import com.danko.shape.repository.ConeSpecification;

public class ConeMaxRadiusSpecification implements ConeSpecification {
    private final double maxRadius;

    public ConeMaxRadiusSpecification(double maxRadius) {
        this.maxRadius = maxRadius;
    }

    @Override
    public boolean specify(Cone cone) {
        double radius = cone.getRadius();
        return radius <= maxRadius;
    }
}
