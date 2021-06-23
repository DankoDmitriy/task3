package com.danko.shape.observer;

import com.danko.shape.entity.Cone;

import java.util.EventObject;

public class ConeEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ConeEvent(Object source) {
        super(source);
    }

    @Override
    public Cone getSource() {
        return (Cone) super.getSource();
    }
}
