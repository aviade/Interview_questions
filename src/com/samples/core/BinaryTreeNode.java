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

    public BinaryTreeNode() {
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

        left.parent = this;
        this.left = left;
    }

    public BinaryTreeNode setLeft(T data) {

        this.left = new BinaryTreeNode(data, this);
        return this.left;
    }

    public BinaryTreeNode<T> getRight() {

        return right;
    }

    public BinaryTreeNode setRight(T data) {

        this.right= new BinaryTreeNode(data, this);
        return this.right;
    }

    public void setRight(BinaryTreeNode<T> right) {

        right.parent = this;
        this.right = right;
    }

    private BinaryTreeNode setParent(T data) {
        this.parent = new BinaryTreeNode(data);
        return this.parent;
    }

    public T getData() {

        return data;
    }

    public BinaryTreeNode clone()
    {
        BinaryTreeNode result = new BinaryTreeNode();
        cloneRecursive(getTopMostParent(), result);

        return result;
    }

    public BinaryTreeNode getTail()
    {
        BinaryTreeNode tail = this;

        boolean exit = false;
        while (!exit)
        {
            exit = true;
            if (tail.getLeft() != null){
                tail = tail.getLeft();
                exit = false;
            }
            else if (tail.getRight() != null){
                tail = tail.getRight();
                exit = false;
            }
        }

        return tail;
    }

    private void cloneRecursive(BinaryTreeNode<T> source, BinaryTreeNode<T> dest) {
        // Base case
        dest.setData(source.data);

        BinaryTreeNode<T> sourceLeft = source.getLeft();
        if (sourceLeft != null){
            BinaryTreeNode<T> left = new BinaryTreeNode<>();
            dest.setLeft(left);
            cloneRecursive(sourceLeft, left);
        }

        BinaryTreeNode<T> sourceRight = source.getRight();
        if (sourceRight != null){
            BinaryTreeNode<T> right = new BinaryTreeNode<>();
            dest.setRight(right);
            cloneRecursive(sourceRight, right);
        }
    }

    public BinaryTreeNode<T> getTopMostParent() {
        return getTopMostParentRecursive(this);
    }

    private BinaryTreeNode<T> getTopMostParentRecursive(BinaryTreeNode<T> node) {
        if (node.parent == null)
        {
            return node;
        }
        return getTopMostParentRecursive(node.parent);
    }

    private void setData(T data) {
        this.data = data;
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

    public int size() {
        return getSizeRecursive(this);
    }

    public int getSizeRecursive(BinaryTreeNode node) {
        if (node == null)
        {
            return 0;
        }

        return 1 + getSizeRecursive(node.getLeft())  + getSizeRecursive(node.getRight());
    }

}