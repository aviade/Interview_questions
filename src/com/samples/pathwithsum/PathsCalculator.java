package com.samples.pathwithsum;

import com.samples.core.BinaryTreeNode;

/**
 * Created by avezra on 7/2/2017.
 */
public class PathsCalculator {
    public static int calcPathsToSum(BinaryTreeNode<Integer> node, int sum) {
        return calcPathsToSumRecursive(node, sum);
    }

    private static int calcPathsToSumRecursive(BinaryTreeNode<Integer> node, int expectedSum) {
        if (node == null) {
            return 0;
        }

        int paths = getPaths(node, expectedSum);

        // Calculate paths to sum for every node
        paths = paths +
                calcPathsToSumRecursive(node.getLeft(), expectedSum) +
                calcPathsToSumRecursive(node.getRight(), expectedSum);

        return paths;
    }

    private static int getPaths(BinaryTreeNode<Integer> node, int expectedSum) {
        return getPathsRecursive(node, expectedSum, 0);
    }

    private static int getPathsRecursive(BinaryTreeNode<Integer> node, int expectedSum, int currentSum) {
        // Base case
        if (node == null) {
            return 0;
        }
        currentSum += node.getData();
        // If we found a path that leads to the sum, return 1
        if (currentSum == expectedSum) {
            return 1;
        }

        // Optimization: If the sum of the path is already bigger than sum, break early
        if (currentSum > expectedSum) {
            return 0;
        }

        return getPathsRecursive(node.getLeft(), expectedSum, currentSum) +
                getPathsRecursive(node.getRight(), expectedSum, currentSum);
    }
}