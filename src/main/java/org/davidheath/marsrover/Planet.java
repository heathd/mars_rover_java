package org.davidheath.marsrover;

import org.davidheath.marsrover.commands.Move;
import org.davidheath.marsrover.geometry.Compass;
import org.davidheath.marsrover.geometry.Point;

import java.util.LinkedList;
import java.util.List;

public abstract class Planet {
    private List<Point> obstacles = new LinkedList<>();

    public abstract Point calculateNewLocationForMove(Point currentLocation, Compass currentDirection, Move move);

    public void addObstacle(int x, int y) {
        obstacles.add(new Point(x,y));
    }

    public boolean hasObstacle(Point p) {
        return hasObstacle(p.getX(), p.getY());
    }

    public boolean hasObstacle(int x, int y) {
        return obstacles.stream().anyMatch(p -> p.getX() == x && p.getY() == y);
    }
}
