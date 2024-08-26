package solutions.neetcode.roadmap.greedy;

import solutions.Solution;

import java.util.*;

public class LC_763 implements Solution {
    @Override
    public void solve() {
        String s = "ababcbacadefegdehijhklij";
        String s2 = "eccbbbbdec";
        System.out.println("Solution: " + this.partitionLabels(s));
        System.out.println("Solution: " + this.partitionLabels(s2));

    }

    // Time: O(n)
    // Space O(26) //english chars
    public List<Integer> partitionLabels(String s) {
        // Maps character and its last idx in the string
        Map<Character, Integer> lastIndex = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastIndex.put(s.charAt(i), i);
        }
        List<Integer> res = new ArrayList<>();
        int size = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            size += 1;
            end = Math.max(end, lastIndex.get(c));
            if (i == end) {
                res.add(size);
                size = 0;
            }
        }
        return res;
    }
}
