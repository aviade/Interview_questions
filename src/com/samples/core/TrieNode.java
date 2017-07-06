package com.samples.core;
import java.util.HashMap;

/**
 * Created by avezra on 7/4/2017.
 */
public class TrieNode {
    Character data;
    private HashMap<Character, TrieNode> nodes = new HashMap<>();

    public TrieNode(Character data) {
        this.data = data;
    }

    public Character getData() {
        return data;
    }

    public TrieNode getNode(Character key) {
        return nodes.get(key);
    }

    public TrieNode addChild(Character key) {
        TrieNode node = getNode(key);
        if (node == null)
        {
            node = new TrieNode(key);
            nodes.put(key, node);
        }
        return node;
    }
}