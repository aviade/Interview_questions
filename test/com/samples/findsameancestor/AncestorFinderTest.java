package com.samples.findsameancestor;

import com.samples.core.BinaryTreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by avezra on 6/30/2017.
 */
public class AncestorFinderTest {
    private static final Boolean USE_ARRAY = true;

    @Test
    public void findFirstAncestor_ancestorIsRoot() throws Exception {
        AncestorFinder ancestorFinder = createFinder();

        BinaryTreeNode<Integer> tree = createTree();
        final BinaryTreeNode ancestor = ancestorFinder.findFirstAncestor(tree, 9, 11);
        assertEquals(1, ancestor.getData());
    }

    @Test
    public void findFirstAncestor_ancestorIsSecond() throws Exception {
        AncestorFinder ancestorFinder = createFinder();

        BinaryTreeNode tree = createTree();
        final BinaryTreeNode ancestor = ancestorFinder.findFirstAncestor(tree, 10, 11);
        assertEquals(2, ancestor.getData());
    }

    @Test
    public void findFirstAncestor_ancestorIsLeaf() throws Exception {
        AncestorFinder ancestorFinder = createFinder();

        BinaryTreeNode tree = createTree();
        final BinaryTreeNode ancestor = ancestorFinder.findFirstAncestor(tree, 8, 9);
        assertEquals(5, ancestor.getData());
    }

    @Test
    public void findFirstAncestor_missingNode() throws Exception {
        AncestorFinder ancestorFinder = createFinder();

        BinaryTreeNode tree = createTree();
        final BinaryTreeNode ancestor = ancestorFinder.findFirstAncestor(tree, 8, 13);
        assertNull(ancestor);
    }

    @Test
    public void findFirstAncestor_missingBothNode() throws Exception {
        AncestorFinder ancestorFinder = createFinder();

        BinaryTreeNode tree = createTree();
        final BinaryTreeNode ancestor = ancestorFinder.findFirstAncestor(tree, 14, 13);
        assertNull(ancestor);
    }

    @Test
    public void findFirstAncestor_emptyTree() throws Exception {
        AncestorFinder ancestorFinder = createFinder();

        BinaryTreeNode<Integer> tree = createTree();
        final BinaryTreeNode ancestor = ancestorFinder.findFirstAncestor(tree, 14, 13);
        assertNull(ancestor);
    }

    private static BinaryTreeNode<Integer> createTree() {
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

        // N3 nodes
        final BinaryTreeNode n4 = new BinaryTreeNode(4);
        n3.setLeft(n4);
        final BinaryTreeNode n5 = new BinaryTreeNode(5);
        n3.setRight(n5);

        // N5 nodes
        final BinaryTreeNode n8 = new BinaryTreeNode(8);
        n5.setLeft(n8);
        final BinaryTreeNode n9 = new BinaryTreeNode(9);
        n3.setLeft(n4);
        n5.setRight(n9);

        return binaryTreeNode;
    }

    private AncestorFinder createFinder() {
        if (USE_ARRAY) {
            return new AncestorFinderWithArrays();
        }
        else{
            return new AncestorFinderInPlace();
        }
    }

}