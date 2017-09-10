package org.davidheath.marsrover;

import org.davidheath.marsrover.commands.Move;
import org.davidheath.marsrover.geometry.Compass;
import org.davidheath.marsrover.geometry.Point;

public class InfinitePlanet extends Planet {

    @Override
    public Point calculateNewLocationForMove(Point currentLocation, Compass currentDirection, Move move) {
        return currentLocation.displace(move.displacement(currentDirection));
    }
}
