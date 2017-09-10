package org.davidheath.marsrover.geometry;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PointTest {
    @Test
    public void hasXAndY() throws Exception {
        Point p = new Point(3,4);

        assertThat(p.getX(), is(3));
        assertThat(p.getY(), is(4));
    }

    @Test
    public void displaceCalculatesANewPointBasedOnTheDisplacement() throws Exception {
        Point p = new Point(3,4);

        Point newPoint = p.displace(new Displacement(0, 0));

        assertThat(newPoint.getX(), is(3));
        assertThat(newPoint.getY(), is(4));

        newPoint = p.displace(new Displacement(1, 2));

        assertThat(newPoint.getX(), is(4));
        assertThat(newPoint.getY(), is(6));

        newPoint = p.displace(new Displacement(-1, -5));

        assertThat(newPoint.getX(), is(2));
        assertThat(newPoint.getY(), is(-1));

    }
}
