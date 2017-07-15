package com.samples.matrixofwords;

import com.samples.core.Matrix;
import com.samples.core.TrieNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by avezra on 7/4/2017.
 */
public class WordsFinderWithTrie implements WordsFinder {
    @Override
    public List<String> findWordsInMatrix(Matrix matrix, String[] lookupList) {
        List<String> result = new ArrayList<>();
        if (matrix.getRows() == 0 || matrix.getColumns() == 0)
        {
            return result;
        }
        TrieNode trie = buildTrie(matrix);

        for (String lookupWord : lookupList) {
            Boolean exist = isWordInTrie(lookupWord, trie);
            if (exist) {
                result.add(lookupWord);
            }
        }
        return result;
    }

    private Boolean isWordInTrie(String word, TrieNode trie) {
        TrieNode nextNode = trie;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            TrieNode currentNode = nextNode.getNode(c);
            if (currentNode == null)
            {
                return false;
            }
            nextNode = currentNode;
        }
        return true;
    }

    private TrieNode buildTrie(Matrix matrix) {
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
