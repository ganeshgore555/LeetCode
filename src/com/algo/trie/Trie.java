package com.algo.trie;

public class Trie {
	
	class TrieNode {
	    public char val;
	    public boolean isWord; 
	    public TrieNode[] child = new TrieNode[26];
	    public TrieNode() {}
	    TrieNode(char c){
	        this.val = c;
	    }
	}
	
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
        root.val = ' ';
    }

    public void insert(String word) {
        TrieNode ws = root;
        for(char c : word.toCharArray()){
            if(ws.child[c - 'a'] == null){
                ws.child[c - 'a'] = new TrieNode(c);
            }
            ws = ws.child[c - 'a'];
        }
        ws.isWord = true;
    }

    public boolean search(String word) {
        TrieNode ws = root; 
        for(char c : word.toCharArray()){
            if(ws.child[c - 'a'] == null) return false;
            ws = ws.child[c - 'a'];
        }
        return ws.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode ws = root; 
        for(char c : prefix.toCharArray()){
            if(ws.child[c - 'a'] == null) return false;
            ws = ws.child[c - 'a'];
        }
        return true;
    }
}
