package org.davidheath.marsrover.geometry;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {

        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        return y == point.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public Point displace(int xDisplacement, int yDisplacement) {
        return new Point(getX() + xDisplacement, getY() + yDisplacement);
    }

    public Point displace(Displacement d) {
        return displace(d.getX(), d.getY());
    }
}
