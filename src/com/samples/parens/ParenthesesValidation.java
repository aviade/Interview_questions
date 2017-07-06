package com.samples.parens;

import java.util.Stack;

/**
 * Created by avezra on 7/6/2017.
 */
public class ParenthesesValidation {
    public static Boolean checkValid(Boolean[] combos) {
        Stack<Boolean> stack = new Stack<>();
        for (int i = 0; i < combos.length; i++) {
            final Boolean open = combos[i];
            if (open) {
                stack.add(true);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return true;
    }
}
