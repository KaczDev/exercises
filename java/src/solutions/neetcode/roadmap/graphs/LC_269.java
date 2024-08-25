package solutions.neetcode.roadmap.graphs;

import solutions.Solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC_269 implements Solution {
    @Override
    public void solve() {
        String[] input = new String[]{"hrn", "hrf", "er", "enn", "rfnn"};
        System.out.println("Solution: " + this.foreignDictionary(input));
    }

    private String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> adj = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.putIfAbsent(c, new HashSet<>());
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int minLen = Math.min(w1.length(), w2.length());
            if (w1.length() > w2.length() && w1.substring(0, minLen - 1).equals(w2.substring(0, minLen - 1))) {
                return "";
            }
            for (int j = 0; j < minLen; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    adj.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
            }
        }
        Map<Character, Boolean> visit = new HashMap<>(); //False=visited, True = on current path
        StringBuilder path = new StringBuilder();
        for (char c : adj.keySet()) {
            if (this.dfs(visit, path, adj, c)) {
                return "";
            }
        }

        return path.reverse().toString();
    }

    private boolean dfs(Map<Character, Boolean> visit, StringBuilder path, Map<Character, Set<Character>> adj, char c) {
        if (visit.containsKey(c)) {
            return visit.get(c);
        }
        visit.put(c, true);
        for (char nei : adj.get(c)) {
            if (this.dfs(visit, path, adj, nei)) {
                return true;
            }
        }
        visit.put(c, false);
        path.append(c);
        return false;
    }

}
