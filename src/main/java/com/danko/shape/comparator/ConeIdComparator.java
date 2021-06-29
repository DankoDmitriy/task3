package com.danko.shape.comparator;

import com.danko.shape.entity.Cone;

import java.util.Comparator;

public class ConeIdComparator implements Comparator<Cone> {

    @Override
    public int compare(Cone o1, Cone o2) {
        int result = Long.compare(o1.getConeId(), o2.getConeId());
        return result;
    }
}
