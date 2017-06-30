package com.samples.stringfinder;

public class StringListFinderResult {
    int minIndex, maxIndex = 0;

    public StringListFinderResult(int minIndex, int maxIndex) {
        this.minIndex = minIndex;
        this.maxIndex = maxIndex;
    }

    @Override
    public String toString() {
        return "Result{" +
                "minIndex=" + minIndex +
                ", maxIndex=" + maxIndex +
                '}';
    }
}
