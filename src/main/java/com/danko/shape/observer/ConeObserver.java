package com.danko.shape.observer;

import com.danko.shape.entity.ConeParameter;

public interface ConeObserver {
    void updateParameters(ConeEvent coneEvent);
}
