package solutions.leetcode.arrays;

import solutions.Solution;

import java.util.HashSet;
import java.util.Set;

public class LC_1684 implements Solution {
    @Override
    public void solve() {
        String allowed = "cad";
        String[] words = {"cc", "acd", "b", "ba", "bac", "bad", "ac", "d"};
        System.out.println("Solution: " + this.countConsistentStrings(allowed, words));
    }

    private int countConsistentStrings(String allowed, String[] words) {
        Set<Character> allowedChars = new HashSet<>();
        for (char c : allowed.toCharArray()) {
            allowedChars.add(c);
        }
        int res = 0;
        for (String w : words) {
            boolean pass = true;
            for (char c : w.toCharArray()) {
                if (!allowedChars.contains(c)) {
                    pass = false;
                    break;
                }
            }
            res += pass ? 1 : 0;
        }
        return res;
    }
}
