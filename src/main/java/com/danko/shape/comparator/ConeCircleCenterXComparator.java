package com.danko.shape.comparator;

import com.danko.shape.entity.Cone;

import java.util.Comparator;

public class ConeCircleCenterXComparator implements Comparator<Cone> {
    @Override
    public int compare(Cone o1, Cone o2) {
        int result = 0;
        double circleCenterX1 = o1.getCircleCenter().getX();
        double circleCenterX2 = o2.getCircleCenter().getX();
        result = Double.compare(circleCenterX1, circleCenterX2);
        return result;
    }
}
