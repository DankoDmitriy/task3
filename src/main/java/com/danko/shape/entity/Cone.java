package com.danko.shape.entity;

import com.danko.shape.exception.ConeException;
import com.danko.shape.observer.ConeEvent;
import com.danko.shape.observer.ConeObservable;
import com.danko.shape.observer.ConeObserver;
import com.danko.shape.util.ShapeIdGeneration;

public class Cone implements ConeObservable {
    private long coneId;
    private Point circleCenter;
    private double radius;
    private double height;
    private ConeObserver observer;

    public Cone() {
    }

    public Cone(Point circleCenter, double radius, double height) throws ConeException {
        if (circleCenter == null || radius <= 0) {
            throw new ConeException();
        }
        this.coneId = ShapeIdGeneration.generateId();
        this.circleCenter = circleCenter;
        this.radius = radius;
        this.height = height;
    }

    public long getConeId() {
        return coneId;
    }

    public Point getCircleCenter() {
        return circleCenter;
    }

    public void setCircleCenter(Point circleCenter) {
        this.circleCenter = circleCenter;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) throws ConeException {
        this.radius = radius;
        notifyObservers();
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
        notifyObservers();
    }

    @Override
    public void attach(ConeObserver observer) {
        this.observer = observer;
    }

    @Override
    public void detach() {
        this.observer = null;
    }

    @Override
    public void notifyObservers() {
        if (observer != null) {
            observer.updateParameters(new ConeEvent(this));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cone cone = (Cone) o;

        if (coneId != cone.coneId) return false;
        if (Double.compare(cone.radius, radius) != 0) return false;
        if (Double.compare(cone.height, height) != 0) return false;
        if (circleCenter != null ? !circleCenter.equals(cone.circleCenter) : cone.circleCenter != null) return false;
        return observer != null ? observer.equals(cone.observer) : cone.observer == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (coneId ^ (coneId >>> 32));
        result = 31 * result + (circleCenter != null ? circleCenter.hashCode() : 0);
        temp = Double.doubleToLongBits(radius);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (observer != null ? observer.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cone{");
        sb.append("coneId=").append(coneId);
        sb.append(", circleCenter=").append(circleCenter);
        sb.append(", radius=").append(radius);
        sb.append(", height=").append(height);
        sb.append(", observer=").append(observer);
        sb.append('}');
        return sb.toString();
    }
}
