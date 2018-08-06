package com.samples.treesearch;

import com.samples.core.BinaryTreeNode;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TreeSearchTest {
    @Test
    public void testTreeSearch_findSubTreesThatMakeSum() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);

        // Add 3 nodes to the left
        BinaryTreeNode<Integer> l1 = new BinaryTreeNode<>(2);
        root.setLeft(l1);
        BinaryTreeNode<Integer> l2 = new BinaryTreeNode<>(3);
        l1.setLeft(l2);
        BinaryTreeNode<Integer> l3 = new BinaryTreeNode<>(6);
        l2.setLeft(l3);

        // Add one node to the right
        BinaryTreeNode<Integer> r1 = new BinaryTreeNode<>(5);
        root.setRight(r1);

        ArrayList<BinaryTreeNode> result = TreeSearch.findSubTreesThatMakeSum(root, 6);
        assertEquals(3, result.size());

        // Check first result
        BinaryTreeNode resultNode1 = result.get(0);
        assertEquals(3, resultNode1.size());

        BinaryTreeNode resultNode2 = result.get(1);
        assertEquals(2, resultNode2.size());

        BinaryTreeNode resultNode3 = result.get(2);
        assertEquals(1, resultNode3.size());
    }

}