package com.samples.fastroute;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by avezra on 6/28/2017.
 */
public class FastRouteFinderTest {
    @Test
    public void findFastestRoute_optimalOpened() throws Exception {
        final Point[] blockers = {
                new Point(0, 1),
        };

        final List<Point> route = RouteFinder.findFastestRoute(4, 4, blockers);

        PrintRoute(route);

        assertEquals(4, route.size());

        assertEquals(new Point(0,0), route.get(0));
        assertEquals(new Point(1,1), route.get(1));
        assertEquals(new Point(2,2), route.get(2));
        assertEquals(new Point(3,3), route.get(3));
    }

    @Test
    public void findFastestRoute_semiOptimalOpened() throws Exception {
        final Point[] blockers = {
                new Point(0, 1),
                new Point(2, 2),
        };

        final List<Point> route = RouteFinder.findFastestRoute(4, 4, blockers);

        PrintRoute(route);

        assertEquals(5, route.size());

        assertEquals(new Point(0,0), route.get(0));
        assertEquals(new Point(1,0), route.get(1));
        assertEquals(new Point(2,1), route.get(2));
        assertEquals(new Point(3,2), route.get(3));
        assertEquals(new Point(3,3), route.get(4));
    }

    private void PrintRoute(List<Point> route) {
        System.out.printf("Route %d \n", route.size());
        System.out.println("************");
        System.out.println("************");
        for (Point point : route) {
            System.out.println(point.toString());
        }
    }
}