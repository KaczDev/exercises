package solutions.leetcode.dynamic_programming;

import solutions.Solution;

import java.util.*;

public class LC_2707 implements Solution {
    @Override
    public void solve() {
        String s = "leetscode";
        String[] dictionary = {"leet", "code", "leetcode"};
        System.out.println("Solution: " + this.minExtraCharDP(s, dictionary));
        System.out.println("Solution: " + this.minExtraCharTrie(s, dictionary));
        s = "sayhelloworld";
        dictionary = new String[]{"hello", "world"};
        System.out.println("Solution: " + this.minExtraCharDP(s, dictionary));
        System.out.println("Solution: " + this.minExtraCharTrie(s, dictionary));
    }

    private int minExtraCharDP(String s, String[] dictionary) {
        Set<String> dict = new HashSet<>(dictionary.length);
        dict.addAll(Arrays.asList(dictionary));
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(s.length(), 0);
        return this.dfsDP(s, dict, dp, 0);
    }

    private int dfsDP(String s, Set<String> dict, Map<Integer, Integer> dp, int i) {
        if (dp.containsKey(i)) {
            return dp.get(i);
        }
        // skip
        int res = 1 + dfsDP(s, dict, dp, i + 1);
        for (int j = i; j < s.length(); j++) {
            if (dict.contains(s.substring(i, j + 1))) {
                // take
                res = Math.min(res, dfsDP(s, dict, dp, j + 1));
            }
        }
        dp.put(i, res);
        return res;
    }

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord = false;
    }

    class Trie {
        TrieNode root;

        Trie(String[] dictionary) {
            this.root = new TrieNode();
            for (String w : dictionary) {
                TrieNode curr = this.root;
                for (char c : w.toCharArray()) {
                    curr.children.putIfAbsent(c, new TrieNode());
                    curr = curr.children.get(c);
                }
                curr.isWord = true;
            }
        }
    }

    public int minExtraCharTrie(String s, String[] dictionary) {
        TrieNode trie = new Trie(dictionary).root;
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(s.length(), 0);
        return this.dfsTrie(s, trie, dp, 0);
    }

    private int dfsTrie(String s, TrieNode trie, Map<Integer, Integer> dp, int i) {
        if (dp.containsKey(i)) {
            return dp.get(i);
        }
        // skip
        int res = 1 + dfsTrie(s, trie, dp, i + 1);
        TrieNode curr = trie;
        for (int j = i; j < s.length(); j++) {
            if (!curr.children.containsKey(s.charAt(j))) {
                break;
            }
            curr = curr.children.get(s.charAt(j));
            if (curr.isWord) {
                res = Math.min(res, dfsTrie(s, trie, dp, j + 1));
            }
        }
        dp.put(i, res);
        return res;
    }
}
