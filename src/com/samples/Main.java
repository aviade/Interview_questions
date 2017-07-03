package com.samples;

import com.samples.stringfinder.StringListFinder;
import com.samples.stringfinder.StringListFinderResult;

public class Main {

    public static void main(String[] args) throws Exception {
        // Click Shift-F10 to run
        char[] arr = new char[] { 'a', 'b', 'c' };
        String input = "aMMaDDbFcFD";
        final StringListFinderResult result = StringListFinder.find(input, arr);
        System.out.print(result);
    }

}