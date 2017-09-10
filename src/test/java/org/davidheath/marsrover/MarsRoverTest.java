package org.davidheath.marsrover;

import org.davidheath.marsrover.geometry.Compass;
import org.davidheath.marsrover.geometry.Point;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MarsRoverTest {
    MarsRover rover;

    @Test
    public void shouldAcceptStartingPointAndInitialDirection() throws Exception {
        Point startingPoint = new Point(3,4);
        Compass initialDirection = Compass.north();
        rover = new MarsRover(startingPoint, initialDirection);

        assertThat(rover.location(), is(startingPoint));
        assertThat(rover.direction(), is(initialDirection));
    }

    /*
    Requirements

You are given the initial starting point (x,y) of a rover and the direction (N,S,E,W) it is facing.
The rover receives a character array of commands.
Implement commands that move the rover forward/backward (f,b).
Implement commands that turn the rover left/right (l,r).
Implement wrapping from one edge of the grid to another. (planets are spheres after all)
Implement obstacle detection before each move to a new square. If a given sequence of commands encounters an obstacle, the rover moves up to the last possible point, aborts the sequence and reports the obstacle.

     */

    @Test
    public void whenGivenEmptyListOfMoves_roverDoesNotMove() throws Exception {
        Point startingPoint = new Point(3,4);
        Compass initialDirection = Compass.north();
        rover = new MarsRover(startingPoint, initialDirection);

        rover.move("");

        assertThat(rover.location(), is(startingPoint));
        assertThat(rover.direction(), is(initialDirection));
    }

    @Test
    public void whenSequenceOfMoves_roverMoves() throws Exception {
        rover = new MarsRover(new Point(0,0), Compass.north());

        rover.move("frflbrff");

        assertThat(rover.location(), is(new Point(3,0)));
        assertThat(rover.direction(), is(Compass.east()));
    }
}
