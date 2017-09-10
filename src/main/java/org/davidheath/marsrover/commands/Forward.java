package org.davidheath.marsrover.commands;

import org.davidheath.marsrover.geometry.Compass;
import org.davidheath.marsrover.geometry.Displacement;

public class Forward extends Move {
    public Displacement displacement(Compass direction) {
        return direction.displacementVector();
    }

    @Override
    public String toString() {
        return "Forward";
    }
}
