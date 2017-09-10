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

/**
 * Created by davidheath on 10/09/2017.
 */
@RunWith(Parameterized.class)
public class TurnLeftTest {
    private final Compass initial;
    private final Compass expected;

    @Parameterized.Parameters(name = "{index}: turnLeft({0}) => {1}")
    public static List<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {Compass.north(), Compass.west()},
                {Compass.west(), Compass.south()},
                {Compass.south(), Compass.east()},
                {Compass.east(), Compass.north()}
                }
        );
    }

    public TurnLeftTest(Compass initial, Compass expected) {
        this.initial = initial;
        this.expected = expected;
    }

    @Test
    public void whenGivenTurnLeftCommand_roverDirectionRotatesAntiClockwise() throws Exception {
        MarsRover rover = new MarsRover(new Point(3, 4), initial);

        rover.move("l");

        assertThat(rover.location(), is(new Point(3, 4)));
        assertThat(rover.direction(), is(expected));
    }
}
