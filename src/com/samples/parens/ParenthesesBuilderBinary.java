package com.samples.parens;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by avezra on 7/6/2017.
 */
public class ParenthesesBuilderBinary implements ParenthesesBuilder{
    @Override
    public String[] getPairs(int n) {
        List<String> result = new ArrayList<>();

        final int numberOfBits = n * 2;
        int bitComboCount = (int) Math.pow(2, numberOfBits);

        // for every bit.. given n=1, combos would be: 00..01..10..11
        for (int currentBit = 0; currentBit < bitComboCount; currentBit++) {
            Boolean[] combos = tryGetCombos(currentBit, numberOfBits);
            Boolean valid = combos != null && ParenthesesValidation.checkValid(combos);
            if (valid) {
                char[] chars = new char[numberOfBits];
                for (int j = 0; j < combos.length; j++) {
                    chars[j] = combos[j] ? '(' : ')';
                }
                result.add(String.copyValueOf(chars));
            }
        }

        return result.toArray(new String[0]);
    }

    private static Boolean[] tryGetCombos(int currentBit, int numberOfBits) {
        int balance = 0;

        Boolean[] combos = new Boolean[numberOfBits];
        for (int index = 0; index < numberOfBits; index++) {
            int factor = 1 << index;
            Boolean bitIsSet = (factor & currentBit) > 0;
            if (bitIsSet) {
                balance++;
            }
            else{
                balance--;
            }
            combos[index] = bitIsSet;
        }

        return balance == 0 ? combos : null;
    }
}