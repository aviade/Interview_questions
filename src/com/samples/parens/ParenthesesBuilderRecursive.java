package com.samples.parens;

import java.util.*;

/**
 * Created by avezra on 7/6/2017.
 */
public class ParenthesesBuilderRecursive implements ParenthesesBuilder{
    @Override
    public String[] getPairs(int n) {
        /*
            1 = ()
            2 - ()(), (())
            3 - ()()(), (()()), (())(), ()(()), ((()))

            Can we build solution for n based n-1?
        */

        final Set<String> result = getPairsRecursive(n);

        return result.toArray(new String[0]);
    }

    private HashSet<String> getPairsRecursive(int index) {

        final HashSet<String> result = new HashSet<>();

        if (index == 0) {
            return result;
        }
        if (index == 1) {
            result.add("()");
            return result;
        }

        final Set<String> previousPairs = getPairsRecursive(index - 1);

        for (String previousItem : previousPairs) {
            // Add to the beginning
            addToSet(result, String.format("()%s", previousItem));

            // Add after every open Parentheses
            for (int j = 0; j < previousItem.length(); j++) {
                Character c = previousItem.charAt(j);
                if (c == '(') {
                    String s = addParenthesesAtLocation(previousItem, j + 1);
                    addToSet(result, s);
                }
            }
        }
        return result;
    }

    private void addToSet(HashSet<String> result, String format) {
        if (!result.contains(format)) {
            result.add(format);
        }
    }

    private String addParenthesesAtLocation(String previousItem, int index) {
        StringBuilder sb = new StringBuilder(previousItem);
        sb.insert(index, "()");
        return sb.toString();
    }
}