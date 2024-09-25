package solutions.leetcode.trie;

import solutions.Solution;

import java.util.*;

public class LC_2416 implements Solution {
    @Override
    public void solve() {
        String[] words = {"abc", "ab", "bc", "b"};
        System.out.println("Solution: " + Arrays.toString(this.sumPrefixScoresHashMap(words)));
        System.out.println("Solution: " + Arrays.toString(this.sumPrefixScoresTrie(words)));
    }

    class TrieNode {
        Map<Character, TrieNode> children;
        int sum;

        TrieNode() {
            this.children = new HashMap<>();
            this.sum = 1;
        }
    }

    class Trie {
        TrieNode root = new TrieNode();

        Trie(String[] words) {
            for (String w : words) {
                TrieNode cur = this.root;
                for (char c : w.toCharArray()) {
                    if (cur.children.containsKey(c)) {
                        cur.children.get(c).sum += 1;
                    } else {
                        TrieNode t = new TrieNode();
                        cur.children.put(c, t);
                    }
                    cur = cur.children.get(c);
                }
            }
        }
    }

    //Time: O(n*L) (L = word length)
    public int[] sumPrefixScoresTrie(String[] words) {
        TrieNode root = new Trie(words).root;
        int[] res = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int score = 0;
            TrieNode cur = root;
            for (int j = 0; j < words[i].length(); j++) {
                //sum the trie
                char c = words[i].charAt(j);
                if (!cur.children.containsKey(c)) {
                    break;
                }
                score += cur.children.get(c).sum;
                cur = cur.children.get(c);
            }
            res[i] = score;
        }
        return res;
    }

    //Time: O(n*L^2)
    public int[] sumPrefixScoresHashMap(String[] words) {
        int[] res = new int[words.length];
        Map<String, Integer> count = new HashMap<>();
        for (String w : words) {
            for (int i = 0; i < w.length(); i++) {
                String sub = w.substring(0, i + 1);
                count.put(sub, count.getOrDefault(sub, 0) + 1);
            }
        }
        int resI = 0;
        for (String w : words) {
            int score = 0;
            for (int i = 0; i < w.length(); i++) {
                String sub = w.substring(0, i + 1);
                score += count.get(sub);
            }
            res[resI] = score;
            resI += 1;
        }
        return res;
    }
}
