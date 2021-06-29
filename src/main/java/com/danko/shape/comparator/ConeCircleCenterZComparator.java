package com.danko.shape.comparator;

import com.danko.shape.entity.Cone;

import java.util.Comparator;

public class ConeCircleCenterZComparator implements Comparator<Cone> {
    @Override
    public int compare(Cone o1, Cone o2) {
        int result = 0;
        double circleCenterZ1 = o1.getCircleCenter().getZ();
        double circleCenterZ2 = o2.getCircleCenter().getZ();
        result = Double.compare(circleCenterZ1, circleCenterZ2);
        return result;
    }
}
