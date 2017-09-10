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
public class WrappingTest {
    private final Point startingPoint;
    private final Compass initialDirection;
    private final Point expectedPoint;

    @Parameterized.Parameters(name = "{index}: facing {1} from {0} moving forward => {2}")
    public static List<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Point(2, 2), Compass.north(), new Point(2, 0)},
                {new Point(2, 1), Compass.east(), new Point(0, 1)},
                {new Point(0, 0), Compass.south(), new Point(0, 2)},
                {new Point(0, 2), Compass.west(), new Point(2, 2)},
                }
        );
    }

    public WrappingTest(Point startingPoint, Compass initialDirection, Point expectedPoint) {
        this.startingPoint = startingPoint;
        this.initialDirection = initialDirection;
        this.expectedPoint = expectedPoint;
    }

    @Test
    public void wraps() throws Exception {
        MarsRover rover = new MarsRover(startingPoint, initialDirection, new FinitePlanet(3, 3));

        rover.move("f");

        assertThat(rover.location(), is(expectedPoint));
    }
}
