package solutions.neetcode.roadmap.slidingwindows;

import solutions.Solution;

import java.util.Arrays;

public class LC_567 implements Solution {
    @Override
    public void solve() {
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println("Solution: " + this.checkInclusion(s1, s2));
    }

    private boolean checkInclusion(String s1, String s2) {
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        for (int i = 0; i < s1.length(); ++i) {
            s1Count[(int) s1.charAt(i) - (int) 'a'] += 1;
            s2Count[(int) s2.charAt(i) - (int) 'a'] += 1;
        }
        int matches = 0;
        for (int i = 0; i < 26; ++i) {
            if (s1Count[i] == s2Count[i]) {
                matches += 1;
            }
        }
        int l = 0;
        for (int r = s1.length(); r < s2.length(); ++r) {
            if (matches == 26) {
                return true;
            }
            //right side increment
            char c = s2.charAt(r);
            int index = (int) c - (int) 'a';
            s2Count[index] += 1;
            if (s1Count[index] == s2Count[index]) {
                matches += 1;
            } else if (s1Count[index] + 1 == s2Count[index]) {
                matches -= 1;
            }
            //left side  decrement
            c = s2.charAt(l);
            index = (int) c - (int) 'a';
            s2Count[index] -= 1;
            if (s1Count[index] == s2Count[index]) {
                matches += 1;
            } else if (s1Count[index] - 1 == s2Count[index]) {
                matches -= 1;
            }
            l+=1;
        }
        return matches == 26;
    }
}
