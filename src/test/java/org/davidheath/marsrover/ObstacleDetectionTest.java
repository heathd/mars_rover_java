package org.davidheath.marsrover;

import org.davidheath.marsrover.geometry.Compass;
import org.davidheath.marsrover.geometry.Point;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ObstacleDetectionTest {
    @Test(expected=MarsRover.ObstacleDetectedException.class)
    public void detectsAnObstacle() throws Exception {
        Planet planet = new InfinitePlanet();
        planet.addObstacle(1,1);

        MarsRover r = new MarsRover(new Point(0,0), Compass.north(), planet);

        r.move("frf");
    }

    @Test
    public void detectsAnObstacleInAFinitePlanet() throws Exception {
        Planet planet = new FinitePlanet(3,3);
        planet.addObstacle(1,1);

        MarsRover r = new MarsRover(new Point(0,0), Compass.north(), planet);

        try {
            r.move("rfrffff");
        } catch (MarsRover.ObstacleDetectedException e) {
        }

        assertThat(r.location(), is(new Point(1, 2)));
        assertThat(r.direction(), is(Compass.south()));
    }

}
