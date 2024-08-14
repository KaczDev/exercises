package solutions.neetcode.roadmap.slidingwindows;

import solutions.Solution;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/longest-repeating-character-replacement/description/
public class LC_424 implements Solution {
    @Override
    public void solve() {
        System.out.println("Solution: " + this.characterReplacement("ABAB", 2));
        System.out.println("Solution: " + this.characterReplacement("AABABBA", 1));
        System.out.println("Solution: " + this.characterReplacement("ABBB", 2));
        System.out.println("Solution: " + this.characterReplacement("BAAAB", 2));
    }

    private int characterReplacement(String s, int k) {
        Map<Character, Integer> counts = new HashMap<>();
        int res = 1;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            counts.put(c, counts.getOrDefault(c, 0) + 1);
            while ((r - l + 1) - counts.values().stream().max(Comparator.naturalOrder()).get() > k) {
                counts.put(s.charAt(l), counts.get(s.charAt(l)) - 1);
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
