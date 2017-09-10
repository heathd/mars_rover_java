package org.davidheath.marsrover;

import org.davidheath.marsrover.commands.Move;
import org.davidheath.marsrover.geometry.Compass;
import org.davidheath.marsrover.geometry.Point;

public class MarsRover {
    private Point currentLocation;
    private Compass currentDirection;
    private final Planet planet;

    public MarsRover(Point startingPoint, Compass initialDirection) {
        this(startingPoint, initialDirection, new InfinitePlanet());
    }

    public MarsRover(Point startingPoint, Compass initialDirection, Planet planet) {
        this.currentLocation = startingPoint;
        this.currentDirection = initialDirection;
        this.planet = planet;
    }

    public Point location() {
        return currentLocation;
    }

    public Compass direction() {
        return currentDirection;
    }

    public void move(String commandList) throws ObstacleDetectedException {
        for (char command : commandList.toCharArray()) {
            Move move = Move.moveFor(command);
            Point newLocation = planet.calculateNewLocationForMove(currentLocation, currentDirection, move);
            if (planet.hasObstacle(newLocation)) {
                throw new ObstacleDetectedException("cannot move " + move + " from " + currentLocation + " because of obstacle at " + newLocation);
            }
            currentLocation = newLocation;
            currentDirection = currentDirection.rotate(move);
        }
    }

    public static class ObstacleDetectedException extends Exception {
        public ObstacleDetectedException(String message) {
            super(message);
        }
    }
}
