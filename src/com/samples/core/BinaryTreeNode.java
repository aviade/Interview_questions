package com.samples.core;

/**
 * Created by avezra on 6/30/2017.
 */
public class BinaryTreeNode<T> {
    BinaryTreeNode parent;
    BinaryTreeNode left;
    BinaryTreeNode right;
    T data;

    public BinaryTreeNode(T data) {

        this.data = data;
    }

    public BinaryTreeNode(T data, BinaryTreeNode<T> parent) {

        this.data = data;
        this.parent = parent;
    }

    public BinaryTreeNode<T> getParent() {
        return parent;
    }

    public BinaryTreeNode<T> getLeft() {

        return left;
    }

    public void setLeft(BinaryTreeNode<T> left) {

        this.left = left;
    }

    public BinaryTreeNode<T> getRight() {

        return right;
    }

    public void setRight(BinaryTreeNode<T> right) {

        this.right = right;
    }

    public T getData() {

        return data;
    }

    public BinaryTreeNode getNode(T data) {
        return getNodeRecursive(this, data);
    }

    public BinaryTreeNode getNodeRecursive(BinaryTreeNode node, T data) {
        if (node == null){
            return null;
        }
        if (node.getData() == data){
            return node;
        }
        // Look to the right
        final BinaryTreeNode nodeRight = getNodeRecursive(node.getRight(), data);
        if (nodeRight != null){
            return nodeRight;
        }
        // Look to the left
        return getNodeRecursive(node.getLeft(), data);
    }

}