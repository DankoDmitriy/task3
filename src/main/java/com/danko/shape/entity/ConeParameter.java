package com.danko.shape.entity;

public class ConeParameter {
    private double volume;
    private double area;
    private double lateralSurfaceArea;

    public ConeParameter() {
    }

    public ConeParameter(double volume, double area, double lateralSurfaceArea) {
        this.volume = volume;
        this.area = area;
        this.lateralSurfaceArea = lateralSurfaceArea;
    }

    public double getVolume() {
        return volume;
    }

    public double getArea() {
        return area;
    }

    public double getLateralSurfaceArea() {
        return lateralSurfaceArea;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConeParameter that = (ConeParameter) o;

        if (Double.compare(that.volume, volume) != 0) return false;
        if (Double.compare(that.area, area) != 0) return false;
        return Double.compare(that.lateralSurfaceArea, lateralSurfaceArea) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(volume);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(area);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(lateralSurfaceArea);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ConeParameter{");
        sb.append("volume=").append(volume);
        sb.append(", area=").append(area);
        sb.append(", lateralSurfaceArea=").append(lateralSurfaceArea);
        sb.append('}');
        return sb.toString();
    }
}
