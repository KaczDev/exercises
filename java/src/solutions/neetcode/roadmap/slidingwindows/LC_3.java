package solutions.neetcode.roadmap.slidingwindows;

import solutions.Solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC_3 implements Solution {
    @Override
    public void solve() {
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";
        String s4 = "umvejcuuk";
        String s5 = "dvdf";
        System.out.println("Solution: " + this.lengthOfLongestSubstring(s1));
        System.out.println("Solution: " + this.lengthOfLongestSubstring(s2));
        System.out.println("Solution: " + this.lengthOfLongestSubstring(s3));
        System.out.println("Solution: " + this.lengthOfLongestSubstring(s4));
        System.out.println("Solution: " + this.lengthOfLongestSubstring(s5));
    }

    //Time: O(n)
    //Space: O(n)
    private int lengthOfLongestSubstring(String s) {
        int longest = 0;
        int l = 0; //left pointer
        Set<Character> substring = new HashSet<>();
        for (int r = 0; r < s.length(); ++r) { // r=right pointer
            char c = s.charAt(r);
            while (substring.contains(c)) {
                substring.remove(s.charAt(l));
                l += 1;
            }
            substring.add(c);
            longest = Math.max(longest, substring.size());
        }
        return longest;
    }
}
