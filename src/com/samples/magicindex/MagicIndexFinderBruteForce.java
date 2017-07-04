package com.samples.magicindex;

/**
 * Created by avezra on 7/2/2017.
 */
public class MagicIndexFinderBruteForce implements MagicIndexFinder{
    @Override
    public int findMagicIndex(int[] array) {
        for (int index = 0; index < array.length; index++) {
            final int magicVaule = array[index];
            if (magicVaule == index)
            {
                return index;
            }
        }
        return -1;
    }
}
