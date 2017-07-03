package com.samples.pathwithsum;

import com.samples.core.BinaryTreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by avezra on 7/2/2017.
 */
public class PathsCalculatorTest {
    @Test
    public void calcPathsToSum_twoNodes_oneSum() throws Exception {
        final BinaryTreeNode node = createTree();
        final int sum = PathsCalculator.calcPathsToSum(node, 4);
        assertEquals(1, sum);
    }

    @Test
    public void calcPathsToSum_allNodes_twoSums() throws Exception {
        final BinaryTreeNode node = createTree();
        final int sum = PathsCalculator.calcPathsToSum(node, 13);
        assertEquals(2, sum);
    }

    @Test
    public void calcPathsToSum_zeroSum() throws Exception {
        final BinaryTreeNode node = createTree();
        final int sum = PathsCalculator.calcPathsToSum(node, 0);
        assertEquals(0, sum);
    }

    @Test
    public void calcPathsToSum_emptyTree() throws Exception {
        final int sum = PathsCalculator.calcPathsToSum(new BinaryTreeNode(0), 0);
        assertEquals(1, sum);
    }

    private static BinaryTreeNode createTree() {
        final BinaryTreeNode binaryTreeNode = new BinaryTreeNode(1);
        // Root nodes
        final BinaryTreeNode n2 = new BinaryTreeNode(2);
        binaryTreeNode.setLeft(n2);
        final BinaryTreeNode n3 = new BinaryTreeNode(3);
        binaryTreeNode.setRight(n3);

        // N2 nodes
        final BinaryTreeNode n10 = new BinaryTreeNode(10);
        n2.setLeft(n10);
        final BinaryTreeNode n11 = new BinaryTreeNode(11);
        n2.setRight(n11);

        return binaryTreeNode;
    }
}