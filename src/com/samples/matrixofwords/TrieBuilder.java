package com.samples.matrixofwords;

import com.samples.core.Matrix;
import com.samples.core.TrieNode;

public class TrieBuilder implements ITrieBuilder{

    @Override
    public TrieNode buildTrie(Matrix matrix) {
        int rows = matrix.getRows();
        int columns = matrix.getColumns();

        TrieNode[][] trieMatrix = new TrieNode[rows][columns];

        // Create double array of all the nodes
        for (int row = 0; row < rows; row++){
            for (int col = 0; col < columns; col++){
                trieMatrix[row][col] = new TrieNode(matrix.get(row, col));
            }
        }

        for (int row = 0; row < rows; row++){
            for (int col = 0; col < columns; col++){
                TrieNode node = trieMatrix[row][col];
                AddChild(matrix, trieMatrix, row+1, col, node);
                AddChild(matrix, trieMatrix, row, col+1, node);
                AddChild(matrix, trieMatrix, row+1, col+1, node);
            }
        }
        TrieNode root = new TrieNode(' ');
        root.addChild(trieMatrix[0][0]);
        return root;
    }

    private void AddChild(Matrix matrix, TrieNode[][] trieMatrix, int row, int col, TrieNode node) {
        if (matrix.isInRange(row, col)){
            node.addChild(trieMatrix[row][col]);
        }
    }
}
