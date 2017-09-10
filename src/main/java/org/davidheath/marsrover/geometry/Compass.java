package org.davidheath.marsrover.geometry;

import org.apache.commons.lang3.ArrayUtils;
import org.davidheath.marsrover.commands.Move;
import org.jetbrains.annotations.Contract;

public class Compass {
    private static final Compass[] points = {
            new Compass("N", 0, 1),
            new Compass("E",1, 0),
            new Compass("S",0, -1),
            new Compass("W",-1, 0)
    };

    private final Displacement displacementVector;
    private final String name;

    public static Compass north() { return points[0]; }
    public static Compass east() { return points[1]; }
    public static Compass south() { return points[2]; }
    public static Compass west() { return points[3]; }

    private Compass(String name, int xVector, int yVector) {
        this.name = name;
        this.displacementVector = new Displacement(xVector, yVector);
    }

    public Compass rotate(Move rotation) {
        if (rotation.isClockwiseRotation()) {
            return rotate(1);
        } else if (rotation.isAntiClockwiseRotation()) {
            return rotate(-1);
        } else {
            return this;
        }
    }

    private Compass rotate(int direction) {
        int i = ArrayUtils.indexOf(points, this);
        return getPoint(i + direction);
    }

    @Contract(pure = true)
    private static Compass getPoint(int index) {
        return points[wrapIndexWithinBounds(index)];
    }

    private static int wrapIndexWithinBounds(int index) {
        return (index + points.length) % points.length;
    }

    public Displacement displacementVector() {
        return displacementVector;
    }
    public Displacement stationaryDisplacementVector() {
        return new Displacement(0,0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Compass compass = (Compass) o;

        return displacementVector != null ? displacementVector.equals(compass.displacementVector) : compass.displacementVector == null;
    }

    @Override
    public int hashCode() {
        return displacementVector != null ? displacementVector.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Compass{" +
                name +
                '}';
    }
}
