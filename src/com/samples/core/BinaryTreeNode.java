package com.samples.core;

/**
 * Created by avezra on 6/30/2017.
 */
public class BinaryTreeNode {
    BinaryTreeNode left;
    BinaryTreeNode right;
    int data;

    public BinaryTreeNode(int data) {
        this.data = data;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

    public int getData() {
        return data;
    }
}