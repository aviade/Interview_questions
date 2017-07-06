package com.samples.intmultiplication;

/**
 * Created by avezra on 7/4/2017.
 */
public class IntMultiply {
    public static int multiply(int n1, int n2)
    {
        final boolean n1IsBigger = n1 > n2;
        int bigger = n1IsBigger ? n1 : n2;
        int smaller = n1IsBigger ? n2 : n1;

        int result = multiplyRecursive(smaller, bigger);

        return result;
    }

    public static int multiplyRecursive(int smaller, int bigger){
        // Base cases
        if (smaller == 0) {
            return 0;
        } else if (smaller == 1) {
            return bigger;
        }

        Boolean smallerIsOdd = smaller % 2 == 1;
        if (smallerIsOdd){
            // If smaller is odd, make it even
            smaller--;
        }

        // divide by two
        final int smallerDividedByTwo = smaller >> 1;

        int halfResult = multiplyRecursive(smallerDividedByTwo, bigger);

        int result = halfResult + halfResult;
        if (smallerIsOdd){

            // If smaller was odd, we need to fix the result
            result += bigger;
        }

        return result;
    }
}
