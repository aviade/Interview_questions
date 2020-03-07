package com.samples.matrixofwords;

import com.samples.core.Matrix;
import com.samples.core.TrieNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by avezra on 7/4/2017.
 */
public class WordsFinderWithTrie implements WordsFinder {
    private ITrieBuilder builder;

    WordsFinderWithTrie(ITrieBuilder builder) {
        this.builder = builder;
    }

    @Override
    public List<String> findWordsInMatrix(Matrix matrix, String[] lookupList) {
        List<String> result = new ArrayList<>();
        int rows = matrix.getRows();
        int columns = matrix.getColumns();

        if (rows == 0 || columns == 0)
        {
            return result;
        }
        TrieNode trie = builder.buildTrie(matrix);

        for (String lookupWord : lookupList) {
            Boolean exist = isWordInTrie(lookupWord, trie);
            if (exist) {
                result.add(lookupWord);
            }
        }
        return result;
    }
    private Boolean isWordInTrie(String word, TrieNode trie) {
        Boolean exist = isWordInTrieNode(word, trie);
        if (exist){
            return true;
        }

        for (TrieNode child : trie.getNodes()) {
            exist = isWordInTrie(word, child);
            if (exist){
                return true;
            }
        }

        return false;
    }

    private Boolean isWordInTrieNode(String word, TrieNode trie) {
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
}
