package com.samples.magicindex;

/**
 * Created by avezra on 7/2/2017.
 */
public class MagicIndexFinderOptimized implements MagicIndexFinder{
    @Override
    public int findMagicIndex(int[] array) {
        return findMagicIndexRecursive(array, 0, array.length-1);
    }

    private int findMagicIndexRecursive(int[] array, int start, int end) {
        // Base case
        int delta = end - start;
        if (delta <= 2) {
            if (array[start] == start) {
                return start;
            } else if (array[end] == end) {
                return end;
            } else {
                return -1;
            }
        }

        int midIndex = start + (delta / 2);
        final int midVaule = array[midIndex];
        if (midIndex <= midVaule){
            // Look left
            return findMagicIndexRecursive(array, 0, midIndex);
        } else {
            // Look right
            return findMagicIndexRecursive(array, midIndex+1, end);
        }
    }
}
