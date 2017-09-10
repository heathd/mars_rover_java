package org.davidheath.marsrover;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class PlanetTest {

    private final int width = 3;
    private final int height = 4;
    private final FinitePlanet planet = new FinitePlanet(width, height);

    @Test
    public void aFinitePlanet_hasNoObstacles() {
        for (int x=0; x<width; x++) {
            for (int y = 0; y < height; y++) {
                assertFalse(planet.hasObstacle(x, y));
            }
        }
    }

    @Test
    public void afterAddingAnObstacle_theObstacleCanBeDetected() {
        planet.addObstacle(1,1);
        assert(planet.hasObstacle(1,1));
        assertFalse(planet.hasObstacle(0,1));
    }

}
