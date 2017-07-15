package com.samples.nextinordernode;

import com.samples.core.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by avezra on 7/7/2017.
 */
public class TreeDepthFirstTraversals {

    public static List<BinaryTreeNode<Character>> getInorder(BinaryTreeNode<Character> root) {
        List<BinaryTreeNode<Character>> result = new ArrayList<>();

        getInorderRecursive(root, result);

        return result;
    }

    private static void getInorderRecursive(
            BinaryTreeNode<Character> node,
            List<BinaryTreeNode<Character>> result) {

        if (node == null) {
            return;
        }
        // Go left all the way
        getInorderRecursive(node.getLeft(), result);
        // Visit current node
        result.add(node);
        // Go right all the way
        getInorderRecursive(node.getRight(), result);
    }

    public static List<BinaryTreeNode<Character>> getPreorder(BinaryTreeNode<Character> root) {
        List<BinaryTreeNode<Character>> result = new ArrayList<>();

        getPreorderRecursive(root, result);

        return result;
    }

    private static void getPreorderRecursive(
            BinaryTreeNode<Character> node,
            List<BinaryTreeNode<Character>> result) {

        if (node == null) {
            return;
        }
        // Visit current node
        result.add(node);
        // Go left all the way
        getPreorderRecursive(node.getLeft(), result);
        // Go right all the way
        getPreorderRecursive(node.getRight(), result);
    }

    public static List<BinaryTreeNode<Character>> getPostorder(BinaryTreeNode<Character> root) {
        List<BinaryTreeNode<Character>> result = new ArrayList<>();

        getPostorderRecursive(root, result);

        return result;
    }

    private static void getPostorderRecursive(
            BinaryTreeNode<Character> node,
            List<BinaryTreeNode<Character>> result) {

        if (node == null) {
            return;
        }
        // Go left all the way
        getPostorderRecursive(node.getLeft(), result);
        // Go right all the way
        getPostorderRecursive(node.getRight(), result);
        // Visit current node
        result.add(node);
    }

    public static List<BinaryTreeNode<Character>> getInorderIterative(BinaryTreeNode<Character> node) {
        List<BinaryTreeNode<Character>> result = new ArrayList<>();

        Stack<BinaryTreeNode<Character>> stack = new Stack<>();

        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                // as long as the node to the left is not null:
                // add it to the stack and moved to the next left node...
                stack.push(node);
                node = node.getLeft();
            } else {
                // When no more nodes to the left:
                // visit the last node found at the left
                node = stack.pop();
                result.add(node);

                // Continue with the right node of the last node found at the left.
                // We will be adding it's left nodes to the stack.
                node = node.getRight();
            }
        }

        return result;
    }

    public static BinaryTreeNode findNextNode(BinaryTreeNode node) {
        final BinaryTreeNode rightChild = node.getRight();
        boolean hasRightChild = rightChild != null;
        if (hasRightChild) {
            return getLeftMostLookDown(rightChild);
        } else {
            return getAncestorLocatedLeft(node);
        }
    }

    private static BinaryTreeNode getAncestorLocatedLeft(BinaryTreeNode node) {

        BinaryTreeNode child = node;
        BinaryTreeNode parent = node.getParent();
        while (parent != null && parent.getLeft() != child) {
            child = parent;
            parent = parent.getParent();
        }
        return parent;
    }

    private static BinaryTreeNode getLeftMostLookDown(BinaryTreeNode node) {
        BinaryTreeNode result = node;

        while (result.getLeft() != null) {
            result = result.getLeft();
        }
        return result;
    }
}
