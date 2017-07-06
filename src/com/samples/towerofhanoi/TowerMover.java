package com.samples.towerofhanoi;

import java.util.Stack;

/**
 * Created by avezra on 7/4/2017.
 */
public class TowerMover {
    public static Stack<Integer> moveTower(Stack<Integer> source) throws MoveDiskException {
        Stack<Integer> end = new Stack<>();
        Stack<Integer> spare = new Stack<>();

        moveTowerRecursive(source.size(), source, end, spare);

        return end;
    }

    private static void moveTowerRecursive(
            int index, Stack<Integer> source,
            Stack<Integer> dest,
            Stack<Integer> spare) throws MoveDiskException {

        // Base case
        if (index == 1)
        {
            moveDisk(source, dest);
            return;
        }

        moveTowerRecursive(index-1, source, spare, dest);
        moveTowerRecursive(1, source, dest, spare);
        moveTowerRecursive(index-1, spare, dest, source);
    }

    private static void moveDisk(Stack<Integer> source, Stack<Integer> target) throws MoveDiskException {

        validateMove(source, target);

        target.add(source.pop());
    }

    private static void validateMove(Stack<Integer> source, Stack<Integer> target) throws MoveDiskException {
        if (target.isEmpty())
        {
            return;
        }
        final Integer targetDisk = target.peek();
        final Integer sourceDisk = source.peek();
        if (sourceDisk > targetDisk) {
            throw new MoveDiskException(targetDisk, sourceDisk);
        }
    }
}
