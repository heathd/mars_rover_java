package org.davidheath.marsrover.geometry;

public class Displacement {
    private final int x;
    private final int y;

    Displacement(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Displacement invert() {
        return new Displacement(-getX(), -getY());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Displacement that = (Displacement) o;

        if (x != that.x) return false;
        return y == that.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "Displacement{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
