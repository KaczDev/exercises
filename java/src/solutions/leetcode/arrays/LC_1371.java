package solutions.leetcode.arrays;

import solutions.Solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LC_1371 implements Solution {
    @Override
    public void solve() {
        System.out.println("Solution: "+this.findTheLongestSubstring("eleetminicoworoep"));
        System.out.println("Solution: "+this.findTheLongestSubstring("leetcodeisgreat"));
        System.out.println("Solution: "+this.findTheLongestSubstring("bcbcbc"));
        System.out.println("Solution: "+this.findTheLongestSubstringSlightlyOptimized("eleetminicoworoep"));
        System.out.println("Solution: "+this.findTheLongestSubstringSlightlyOptimized("leetcodeisgreat"));
        System.out.println("Solution: "+this.findTheLongestSubstringSlightlyOptimized("bcbcbc"));

    }
    // Time: O(n)
    // Space: O(1) O(32) (only vowels 2^5)
    private int findTheLongestSubstring(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int res = 0;
        int mask = 0;
        Map<Integer, Integer> mask_to_idx = new HashMap<>();
        mask_to_idx.put(0, -1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (vowels.contains(c)) {
                mask = mask ^ (1 + (int) c - (int) 'a');
            }
            if (mask_to_idx.containsKey(mask)) {
                int length = i - mask_to_idx.get(mask);
                res = Math.max(res, length);
            } else {
                mask_to_idx.put(mask, i);
            }
        }
        return res;
    }
    // Time: O(n)
    // Space: O(1) O(32) (only vowels 2^5)
    private int findTheLongestSubstringSlightlyOptimized(String s) {
        Map<Character,Integer> vowelsBitPos = Map.of('a',1,'e',2,'i',4,'o',8,'u',16);
        int res = 0;
        int mask = 0;
        int[] mask_to_idx = new int[32];
        Arrays.fill(mask_to_idx,-1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            mask = mask ^ vowelsBitPos.getOrDefault(c,0);
            if (mask_to_idx[mask]!=-1 || mask==0) {
                int length = i - mask_to_idx[mask];
                res = Math.max(res, length);
            } else {
                mask_to_idx[mask]= i;
            }
        }
        return res;
    }
}
