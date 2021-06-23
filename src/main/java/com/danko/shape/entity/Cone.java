package com.danko.shape.entity;

import com.danko.shape.excaption.ConeException;
import com.danko.shape.observer.ConeEvent;
import com.danko.shape.observer.ConeObservable;
import com.danko.shape.observer.ConeObserver;
import com.danko.shape.util.ShapeIdGeneration;

public class Cone implements ConeObservable {
    private long coneId;
    private Point circleCenter;
    private double radius;
    private double height;
    private double generatrix;
    private ConeObserver observer;

    public Cone() {
    }

    public Cone(Point circleCenter, double radius, double height, double generatrix) throws ConeException {
        if (circleCenter == null || radius < 0) {
            throw new ConeException();
        }
        this.coneId = ShapeIdGeneration.generateId();
        this.circleCenter = circleCenter;
        this.radius = radius;
        this.height = height;
        this.generatrix = generatrix;
    }

    public long getConeId() {
        return coneId;
    }

    public Point getCircleCenter() {
        return circleCenter;
    }

    public void setCircleCenter(Point circleCenter) throws ConeException {
        if (circleCenter == null) {
            throw new ConeException();
        }
        this.circleCenter = circleCenter;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) throws ConeException {
        if (radius < 0) {
            throw new ConeException();
        }
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

    public double getGeneratrix() {
        return generatrix;
    }

    public void setGeneratrix(double generatrix) {
        this.generatrix = generatrix;
        notifyObservers();
    }

    @Override
    public void attach(ConeObserver observer) {
        this.observer = observer;
    }

    @Override
    public void detach(ConeObserver observer) {
        this.observer = null;
    }

    @Override
    public void notifyObservers() {
        if (observer != null) {
            observer.updateParameters(new ConeEvent(this));
        } else {
//fixme  - this only for first start
            System.out.println("Observer is NULL");
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cone{");
        sb.append("coneId=").append(coneId);
        sb.append(", circleCenter=").append(circleCenter);
        sb.append(", radius=").append(radius);
        sb.append(", height=").append(height);
        sb.append(", generatrix=").append(generatrix);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cone cone = (Cone) o;

        if (coneId != cone.coneId) return false;
        if (Double.compare(cone.radius, radius) != 0) return false;
        if (Double.compare(cone.height, height) != 0) return false;
        if (Double.compare(cone.generatrix, generatrix) != 0) return false;
        return circleCenter.equals(cone.circleCenter);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (coneId ^ (coneId >>> 32));
        result = 31 * result + circleCenter.hashCode();
        temp = Double.doubleToLongBits(radius);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(generatrix);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
