package org.davidheath.marsrover.commands;

public class Left extends Move {
    @Override
    public boolean isAntiClockwiseRotation() {
        return true;
    }
}
