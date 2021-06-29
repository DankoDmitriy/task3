package com.danko.shape.repository.impl;

import com.danko.shape.entity.Cone;
import com.danko.shape.repository.ConeSpecification;

public class ConeQuadrantSpecification implements ConeSpecification {
    private final int quadrant;

    public ConeQuadrantSpecification(int quadrant) {
        this.quadrant = quadrant;
    }

    @Override
    public boolean specify(Cone cone) {
        int coneQuadrant = 0;
        double x = cone.getCircleCenter().getX();
        double y = cone.getCircleCenter().getY();
        double z = cone.getCircleCenter().getZ();
        if (x > 0 && y > 0 && z > 0) {
            coneQuadrant = 1;
        }
        if (x > 0 && y < 0 && z > 0) {
            coneQuadrant = 2;
        }
        if (x > 0 && y < 0 && z < 0) {
            coneQuadrant = 3;
        }
        if (x > 0 && y > 0 && z < 0) {
            coneQuadrant = 1;
        }
        return quadrant == coneQuadrant;
    }
}
