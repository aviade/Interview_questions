package com.samples.towerofhanoi;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by avezra on 7/4/2017.
 */
public class TowerMoverTest {
    @Test
    public void moveTower_small() throws MoveDiskException {
        final Stack<Integer> source = new Stack<>();
        source.add(15);
        source.add(10);
        source.add(5);

        final Stack<Integer> destination = TowerMover.moveTower((Stack<Integer>) source.clone());
        assertEquals(source.size(), destination.size());

        while(!source.isEmpty())
        {
            Boolean match = source.pop() == destination.pop();
            assertTrue(match);
        }
    }

    @Test
    public void moveTower_big() throws MoveDiskException {
        final Stack<Integer> source = new Stack<>();
        for (int i = 24; i > 0; i--) {
            source.add(i);
        }

        final Stack<Integer> destination = TowerMover.moveTower((Stack<Integer>) source.clone());
        assertEquals(source.size(), destination.size());

        while(!source.isEmpty())
        {
            Boolean match = source.pop() == destination.pop();
            assertTrue(match);
        }
    }
}