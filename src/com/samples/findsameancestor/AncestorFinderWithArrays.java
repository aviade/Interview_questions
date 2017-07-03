package com.samples.findsameancestor;

import com.samples.core.BinaryTreeNode;

import java.util.*;

/**
 * Created by avezra on 6/30/2017.
 */
public class AncestorFinderWithArrays implements AncestorFinder {
    public BinaryTreeNode findFirstAncestor(BinaryTreeNode node, int n1, int n2) {
        Stack<BinaryTreeNode> list1 = new Stack<>();
        Stack<BinaryTreeNode> list2 = new Stack<>();

        getPath(list1, node, n1);
        getPath(list2, node, n2);

        Boolean matching = true;
        BinaryTreeNode ancestor = null;
        while(matching)
        {
            if (list1.isEmpty() || list2.isEmpty()) {
                matching = false;
            }
            else {
                BinaryTreeNode node1 = list1.pop();
                final BinaryTreeNode node2 = list2.pop();
                matching = node1 == node2;
                if (matching)
                {
                    ancestor = node1;
                }
            }
        }
        return ancestor;
    }

    private static Boolean getPath(Stack<BinaryTreeNode> list, BinaryTreeNode node, int data) {
        if (node == null)
        {
            return false;
        }
        if (node.getData() == data)
        {
            return true;
        }
        if (getPath(list, node.getLeft(), data))
        {
            list.add(node);
            return true;
        }
        else if (getPath(list, node.getRight(), data)){
            list.add(node);
            return true;
        }
        return false;
    }
}
