package com.danko.shape.repository.impl;

import com.danko.shape.entity.Cone;
import com.danko.shape.repository.ConeSpecification;

public class ConeIdSpecification implements ConeSpecification {
    private final long id;

    public ConeIdSpecification(long id) {
        this.id = id;
    }

    @Override
    public boolean specify(Cone cone) {
        return cone.getConeId() == id;
    }
}
