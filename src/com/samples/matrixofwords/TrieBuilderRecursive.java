package com.samples.matrixofwords;

import com.samples.core.Matrix;
import com.samples.core.TrieNode;

public class TrieBuilderRecursive implements ITrieBuilder{
    @Override
    public TrieNode buildTrie(Matrix matrix) {
        TrieNode trie = new TrieNode(null);
        final int rows = matrix.getRows();
        final int columns = matrix.getColumns();

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                buildTrieRecursive(matrix, trie, row, column);
            }
        }
        return trie;
    }

    private void buildTrieRecursive(Matrix matrix, TrieNode trie, int row, int column) {
        // Base case: check if the position in in matrix range
        Boolean inRange = matrix.isInRange(row, column);
        if (!inRange) {
            return;
        }
        final TrieNode child = trie.addChild(matrix.get(row, column));

        buildTrieRecursive(matrix, child, row + 1, column);
        buildTrieRecursive(matrix, child, row, column + 1);
        buildTrieRecursive(matrix, child, row + 1, column + 1);
    }

}
