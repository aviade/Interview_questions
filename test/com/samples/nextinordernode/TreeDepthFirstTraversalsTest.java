package com.samples.nextinordernode;

import com.samples.core.BinaryTreeNode;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by avezra on 7/7/2017.
 */
public class TreeDepthFirstTraversalsTest {
    @Test
    public void findNextNode_nodeHasRightChild() throws Exception {
        // Find the next inorder node
        final BinaryTreeNode<Character> root = createBinaryTreeNode();

        assertNextNode(root, 'F', 'G');
        assertNextNode(root, 'G', 'H');
        assertNextNode(root, 'B', 'C');
        assertNextNode(root, 'D', 'E');
    }

    @Test
    public void findNextNode_nodeDoesNotHaveRightChild() throws Exception {
        // Find the next inorder node
        final BinaryTreeNode<Character> root = createBinaryTreeNode();

        assertNextNode(root, 'A', 'B');
        assertNextNode(root, 'C', 'D');
        assertNextNode(root, 'E', 'F');
        assertNextNode(root, 'H', 'I');
    }

    @Test
    public void findNextNode_lastNode() throws Exception {
        // Find the next inorder node
        final BinaryTreeNode<Character> root = createBinaryTreeNode();
        final BinaryTreeNode node = root.getNode('I');
        BinaryTreeNode nextNode = TreeDepthFirstTraversals.findNextNode(node);
        assertNull(nextNode);
    }

    private void assertNextNode(BinaryTreeNode<Character> root, char nodeData, char expectedNextNodeData) {
        final BinaryTreeNode node = root.getNode(nodeData);
        BinaryTreeNode nextNode = TreeDepthFirstTraversals.findNextNode(node);
        assertEquals(expectedNextNodeData, nextNode.getData());

    }

    @Test
    public void nodeFinder_inoder() throws Exception {
        // Find the next inorder node
        final BinaryTreeNode<Character> node = createBinaryTreeNode();
        final List<BinaryTreeNode<Character>> ordered = TreeDepthFirstTraversals.getInorder(node);

        printOrdered(ordered);
    }

    @Test
    public void nodeFinder_inoder_recursice_iterative() throws Exception {
        // Find the next inorder node
        final BinaryTreeNode<Character> node = createBinaryTreeNode();

        final List<BinaryTreeNode<Character>> orderedRecursive = TreeDepthFirstTraversals.getInorder(node);
        printOrdered(orderedRecursive);

        final List<BinaryTreeNode<Character>> orderedIterative = TreeDepthFirstTraversals.getInorderIterative(node);
        printOrdered(orderedIterative);

        assertEquals(orderedRecursive.size(), orderedIterative.size());

        assertArrayEquals(orderedRecursive.toArray(), orderedIterative.toArray());
    }

    @Test
    public void nodeFinder_preoder() throws Exception {
        // Find the next inorder node
        final BinaryTreeNode<Character> node = createBinaryTreeNode();
        final List<BinaryTreeNode<Character>> ordered = TreeDepthFirstTraversals.getPreorder(node);

        printOrdered(ordered);
    }

    @Test
    public void nodeFinder_postorder() throws Exception {
        // Find the next inorder node
        final BinaryTreeNode<Character> node = createBinaryTreeNode();
        final List<BinaryTreeNode<Character>> ordered = TreeDepthFirstTraversals.getPostorder(node);

        printOrdered(ordered);
    }

    private void printOrdered(List<BinaryTreeNode<Character>> ordered) {
        for (BinaryTreeNode<Character> treeNode : ordered) {
            System.out.println(treeNode.getData() + ", ");
        }
    }

    private BinaryTreeNode createBinaryTreeNode() {
        // Add root
        final BinaryTreeNode root = new BinaryTreeNode('F');
        final BinaryTreeNode b = new BinaryTreeNode('B', root);
        root.setLeft(b);
        final BinaryTreeNode g = new BinaryTreeNode('G', root);
        root.setRight(g);

        // Add to B
        final BinaryTreeNode a = new BinaryTreeNode('A', b);
        b.setLeft(a);
        final BinaryTreeNode d = new BinaryTreeNode('D', b);
        b.setRight(d);

        // Add to D
        final BinaryTreeNode c = new BinaryTreeNode('C', d);
        d.setLeft(c);
        final BinaryTreeNode e = new BinaryTreeNode('E', d);
        d.setRight(e);

        // Add to G
        final BinaryTreeNode i = new BinaryTreeNode('I', g);
        g.setRight(i);
        // Add to I
        i.setLeft(new BinaryTreeNode('H', i));

        return root;
    }
}