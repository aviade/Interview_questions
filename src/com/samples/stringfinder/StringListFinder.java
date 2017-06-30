package com.samples.stringfinder;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by avezra on 6/27/2017.
 */
public class StringListFinder {

    public static StringListFinderResult find(String input, char[] arr) throws CharNotFoundException {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            map.put(c, -1);
        }

        // Update the latest index
        for (int index = 0; index < input.length(); index++) {
            char c = input.charAt(index);
            if (map.containsKey(c)) {
                map.put(c, index);
            }
        }
        int min = arr.length, max = 0;

        final Collection<Integer> values = map.values();
        for (int value: values) {
            if (value == -1) {
                throw new CharNotFoundException("Couldn't find all chars");
            }
            if (value < min) {
                min = value;
            } if (value > max) {
                max = value;
            }
        }
        
        return new StringListFinderResult(min, max);
    }
}



