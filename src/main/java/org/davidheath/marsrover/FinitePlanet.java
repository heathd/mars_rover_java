package org.davidheath.marsrover;

import org.davidheath.marsrover.commands.Move;
import org.davidheath.marsrover.geometry.Compass;
import org.davidheath.marsrover.geometry.Displacement;
import org.davidheath.marsrover.geometry.Point;

public class FinitePlanet extends Planet {
    private final int width;
    private final int height;

    public FinitePlanet(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public Point calculateNewLocationForMove(Point here, Compass currentDirection, Move move) {
        Displacement d = move.displacement(currentDirection);
        int newX = wrap(here.getX() + d.getX(), getWidth());
        int newY = wrap(here.getY() + d.getY(), getHeight());
        return new Point(newX, newY);
    }

    private int wrap(int pos, int limit) {
        while (pos < 0) {
            pos += limit;
        }
        return pos % limit;
    }
}
