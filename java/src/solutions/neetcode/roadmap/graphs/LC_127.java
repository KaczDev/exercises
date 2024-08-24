package solutions.neetcode.roadmap.graphs;

import solutions.Solution;

import java.util.*;

public class LC_127 implements Solution {
    @Override
    public void solve() {
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println("Solution: " + this.ladderLength("hit", "cog", wordList));
    }

    private int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Map<String, Set<String>> nei = new HashMap<>();
        wordList.add(beginWord);
        for (String word : wordList) {
            for (int j = 0; j < word.length(); j++) {
                String pattern = word.substring(0, j) + '*' + word.substring(j + 1);
                nei.putIfAbsent(pattern, new HashSet<>());
                nei.get(pattern).add(word);
            }
        }
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        Deque<String> q = new ArrayDeque<>();
        q.addLast(beginWord);
        int res = 1;
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                String word = q.removeFirst();
                if (word.equals(endWord)) {
                    return res;
                }
                for (int j = 0; j < word.length(); j++) {
                    String pattern = word.substring(0, j) + '*' + word.substring(j + 1);
                    for (String neiWord : nei.get(pattern)) {
                        if (!visited.contains(neiWord)) {
                            q.addLast(neiWord);
                            visited.add(neiWord);
                        }
                    }
                }
            }
            res += 1;
        }
        return 0;
    }
}
