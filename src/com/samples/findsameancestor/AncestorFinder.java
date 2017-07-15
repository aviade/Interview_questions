package com.samples.findsameancestor;

import com.samples.core.BinaryTreeNode;

/**
 * Created by avezra on 6/30/2017.
 */
public interface AncestorFinder {
    BinaryTreeNode<Integer> findFirstAncestor(BinaryTreeNode<Integer> node, int n1, int n2);
}
