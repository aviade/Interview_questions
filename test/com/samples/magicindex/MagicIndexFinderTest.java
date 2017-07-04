package com.samples.magicindex;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by avezra on 7/2/2017.
 */
public class MagicIndexFinderTest {
    private static final Boolean OPTIMIZED = true;
    @Test
    public void findMagicIndex_single() throws Exception {
        final MagicIndexFinder finder = createFinder();
        final int[] array = {-10, -5, 1, 3, 14, 18, 77};
        final int magicIndex = finder.findMagicIndex(array);

        assertEquals(3, magicIndex);
    }

    @Test
    public void findMagicIndex_multiple() throws Exception {
        final MagicIndexFinder finder = createFinder();
        final int[] array = {-5, -4, 2, 3, 77};
        final int magicIndex = finder.findMagicIndex(array);

        assertEquals(2, magicIndex);
    }

    @Test
    public void findMagicIndex_long() throws Exception {
        final MagicIndexFinder finder = createFinder();
        final int[] array = {-40, -35, -20, -10, -5, -4, 1, 2, 8, 10, 11, 12, 13, 14};
        final int magicIndex = finder.findMagicIndex(array);

        assertEquals(8, magicIndex);
    }

    private MagicIndexFinder createFinder() {
        if (OPTIMIZED) {
            return new MagicIndexFinderOptimized();
        }
        return new MagicIndexFinderBruteForce();
    }
}