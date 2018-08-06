package com.samples.treesearch;

import com.samples.core.BinaryTreeNode;
import java.util.ArrayList;

public class TreeSearch {

    public static ArrayList<BinaryTreeNode> findSubTreesThatMakeSum(BinaryTreeNode<Integer> root, int totalSum) {
        ArrayList<BinaryTreeNode> result = new ArrayList<>();

        findSubTreesRecursive(root, totalSum, result);

        return result;
    }

    private static void findSubTreesRecursive(BinaryTreeNode<Integer> node, int totalSum, ArrayList<BinaryTreeNode> result)
    {
        if (node == null)
        {
            return;
        }
        // visit current
        findSubTreesForNodeRecursive(node, 0, totalSum, new BinaryTreeNode<>(node.getData()), result);

        // Recurse on left node
        findSubTreesRecursive(node.getLeft(), totalSum, result);

        // Recurse on right node
        findSubTreesRecursive(node.getRight(), totalSum, result);
    }

    private static void findSubTreesForNodeRecursive(
            BinaryTreeNode<Integer> node,
            int currentSum,
            int totalSum,
            BinaryTreeNode<Integer> buffer,
            ArrayList<BinaryTreeNode> result) {

        currentSum += node.getData();

        if (currentSum == totalSum)
        {
            result.add(buffer.getTopMostParent());
        }
        else{
            // Search left node
            BinaryTreeNode<Integer> leftNode = node.getLeft();
            if (leftNode != null)
            {
                BinaryTreeNode bufferClone = buffer.clone();
                BinaryTreeNode leftNodeClone = bufferClone.getTail().setLeft(leftNode.getData());
                findSubTreesForNodeRecursive(leftNode, currentSum, totalSum, leftNodeClone , result);
            }

            BinaryTreeNode<Integer> rightNode = node.getRight();
            if (rightNode != null)
            {
                BinaryTreeNode bufferClone = buffer.clone();
                BinaryTreeNode rightNodeClone = bufferClone.getTail().setRight(rightNode.getData());
                findSubTreesForNodeRecursive(rightNode, currentSum, totalSum, rightNodeClone , result);
            }

        }
    }
}
