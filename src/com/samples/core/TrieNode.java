package com.samples.core;
import java.util.HashMap;

/**
 * Created by avezra on 7/4/2017.
 */
public class TrieNode {
    private Character data;
    private HashMap<Character, TrieNode> nodes = new HashMap<>();

    public TrieNode(Character data) {
        this.data = data;
    }

    public TrieNode[] getNodes() {
        return nodes.values().toArray(new TrieNode[0]);
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

    public void addChild(TrieNode child) {
        nodes.put(child.data, child);
    }
}