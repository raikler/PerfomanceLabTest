package com.company;

import java.util.Objects;

public class PointQuad {
    private double x,y;

    public PointQuad(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PointQuad pointQuad = (PointQuad) o;
        return Double.compare(pointQuad.x, x) == 0 && Double.compare(pointQuad.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
