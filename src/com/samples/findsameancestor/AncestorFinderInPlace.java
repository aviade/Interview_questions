package com.samples.findsameancestor;

import com.samples.core.BinaryTreeNode;

/**
 * Created by avezra on 6/30/2017.
 */
public class AncestorFinderInPlace implements AncestorFinder {
        public BinaryTreeNode<Integer> findFirstAncestor(BinaryTreeNode<Integer> node, int n1, int n2){
            final BinaryTreeNode<Integer> ancestor = findFirstAncestorRecursive(node, n1, n2);
            // If none of the nodes exist in the tree, the recursion returns null
            if (ancestor == null)
            {
                return null;
            }

            // If one of the nodes wasn't in the tree, the recursion will return the other node
            if (ancestor.getData() == n1 || ancestor.getData() == n2)
            {
                return null;
            }

            return ancestor;
        }

        private static BinaryTreeNode findFirstAncestorRecursive(BinaryTreeNode<Integer> node, int n1, int n2) {
            // Base case
            if (node == null) {
                return null;
            }

            if (node.getData() == n1 || node.getData() == n2) {
                return node;
            }

            final BinaryTreeNode rightNode = findFirstAncestorRecursive(node.getLeft(), n1, n2);
            final BinaryTreeNode leftNode = findFirstAncestorRecursive(node.getRight(), n1, n2);

            if (rightNode != null && leftNode != null) {
                return node;
            }

            return rightNode != null ? rightNode : leftNode;
        }
    }

