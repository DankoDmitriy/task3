package com.danko.shape.comparator;

import com.danko.shape.entity.Cone;

import java.util.Comparator;

public class ConeCircleCenterYComparator implements Comparator<Cone> {
    @Override
    public int compare(Cone o1, Cone o2) {
        int result = 0;
        double circleCenterY1 = o1.getCircleCenter().getY();
        double circleCenterY2 = o2.getCircleCenter().getY();
        result = Double.compare(circleCenterY1, circleCenterY2);
        return result;
    }
}
