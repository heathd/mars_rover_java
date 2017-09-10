package org.davidheath.marsrover.commands;

import org.davidheath.marsrover.geometry.Compass;
import org.davidheath.marsrover.geometry.Displacement;

public class Backward extends Move {
    public Displacement displacement(Compass direction) {
        return direction.displacementVector().invert();
    }

    @Override
    public String toString() {
        return "Backward";
    }
}
