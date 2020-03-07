package com.samples.matrixofwords;

import com.samples.core.Matrix;
import com.samples.core.TrieNode;

public class TrieBuilderRecursive implements ITrieBuilder{
    @Override
    public TrieNode buildTrie(Matrix matrix) {
        TrieNode trie = new TrieNode(null);
        buildTrieRecursive(matrix, trie, 0, 0);
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