package solutions.neetcode.roadmap.tries;

import solutions.Solution;

import java.util.HashMap;
import java.util.Map;

public class LC_211 implements Solution {

    @Override
    public void solve() {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // return False
        System.out.println(wordDictionary.search("bad")); // return True
        System.out.println(wordDictionary.search(".ad")); // return True
        System.out.println(wordDictionary.search("b..")); // return True
    }

    class WordDictionary {
        class TrieNode {
            boolean isWord = false;
            Map<Character, TrieNode> children = new HashMap<>();
        }

        private TrieNode root;

        public WordDictionary() {
            this.root = new TrieNode();
        }

        public void addWord(String word) {
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
            return this.dfs(0,this.root, word);
        }
        private boolean dfs(int j, TrieNode root,String word){
            TrieNode cur = root;
            for (int i=j;i<word.length();i++) {
                char c =word.charAt(i);
                if (c == '.') {
                    //We have to search through all possible nodes
                    for (TrieNode node: cur.children.values()){
                        if (this.dfs(i+1,node,word)){
                            return true;
                        }
                    }
                    return false;
                } else {
                    if (!cur.children.containsKey(c)) {
                        return false;
                    }
                    cur = cur.children.get(c);
                }
            }
            return cur.isWord;
        }
    }}
