package com.danko.shape.repository;

import com.danko.shape.entity.Cone;

@FunctionalInterface
public interface ConeSpecification {
    public boolean specify(Cone cone);
}