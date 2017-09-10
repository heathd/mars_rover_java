package org.davidheath.marsrover;

import org.davidheath.marsrover.geometry.Compass;
import org.davidheath.marsrover.geometry.Point;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(Parameterized.class)
public class RoverDisplacementTest {
    private MarsRover rover;

    private final Point startingPoint;
    private final Compass initialDirection;
    private final String move;
    private final Point expected;

    @Parameterized.Parameters(name = "{index}: from({0} {1}) move({2}) => {3}")
    public static List<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Point(3,4), Compass.north(), "f", new Point(3,5)},
                {new Point(3,4), Compass.east(), "f", new Point(4,4)},
                {new Point(3,4), Compass.south(), "f", new Point(3,3)},
                {new Point(3,4), Compass.west(), "f", new Point(2,4)},
                {new Point(3,4), Compass.north(), "b", new Point(3,3)},
                {new Point(3,4), Compass.east(), "b", new Point(2,4)},
                {new Point(3,4), Compass.south(), "b", new Point(3,5)},
                {new Point(3,4), Compass.west(), "b", new Point(4,4)}
                }
        );
    }

    public RoverDisplacementTest(Point initialPosition, Compass initialDirection, String move, Point expected) {
        this.startingPoint = initialPosition;
        this.initialDirection = initialDirection;
        this.move = move;
        this.expected = expected;
    }

    @Test
    public void testMoveForward() throws Exception {
        rover = new MarsRover(startingPoint, initialDirection);

        rover.move(move);

        assertThat(rover.location(), is(expected));
        assertThat(rover.direction(), is(initialDirection));
    }
}
