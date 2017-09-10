package org.davidheath.marsrover.commands;

import org.davidheath.marsrover.geometry.Compass;
import org.davidheath.marsrover.geometry.Displacement;

public abstract class Move {
    public static Move moveFor(char command) {
        if (command == 'f') {
            return new Forward();
        } else if (command == 'b') {
            return new Backward();
        } else if (command == 'l') {
            return new Left();
        } else if (command == 'r') {
            return new Right();
        }
        throw new RuntimeException("Unknown command " + command);
    }

    public Displacement displacement(Compass direction) {
        return direction.stationaryDisplacementVector();
    };

    public boolean isClockwiseRotation() { return false; };

    public boolean isAntiClockwiseRotation() { return false; };
}
