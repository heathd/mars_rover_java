package org.davidheath.marsrover.commands;

public class Right extends Move {
    @Override
    public boolean isClockwiseRotation() {
        return true;
    }
}
