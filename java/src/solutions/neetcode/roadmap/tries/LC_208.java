package solutions.neetcode.roadmap.tries;

import solutions.Solution;

import java.util.HashMap;
import java.util.Map;

public class LC_208 implements Solution {
    @Override
    public void solve() {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // return True
        System.out.println(trie.search("app"));     // return False
        System.out.println(trie.startsWith("app")); // return True
        trie.insert("app");
        System.out.println(trie.search("app"));     // return True
    }

    class Trie {
        class TrieNode {
            boolean isWord = false;
            Map<Character, TrieNode> children = new HashMap<>();
        }

        //A tree that has 26 children
        private TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode cur = this.root;
            for (char c : word.toCharArray()) {
                if (!cur.children.containsKey(c)) {
                    cur.children.put(c, new TrieNode());
                }
                cur = cur.children.get(c);
            }
            cur.isWord = true;
        }

        public boolean search(String word) {
            TrieNode cur = this.root;
            for (char c : word.toCharArray()) {
                if (!cur.children.containsKey(c)) {
                    return false;
                }
                cur = cur.children.get(c);
            }
            return cur.isWord;
        }

        public boolean startsWith(String prefix) {
            TrieNode cur = this.root;
            for (char c : prefix.toCharArray()) {
                if (!cur.children.containsKey(c)) {
                    return false;
                }
                cur = cur.children.get(c);
            }
            return true;
        }
    }
}
