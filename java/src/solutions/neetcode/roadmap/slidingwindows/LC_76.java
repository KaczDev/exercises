package solutions.neetcode.roadmap.slidingwindows;

import solutions.Solution;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LC_76 implements Solution {
    @Override
    public void solve() {
        String s1 = "ADOBECODEBANC";
        String t1 = "ABC";
        String s2 = "a";
        String t2 = "a";
        String s3 = "a";
        String t3 = "aa";
        System.out.println("Solution: " + this.minWindow(s1, t1));
        System.out.println("Solution: " + this.minWindow(s2, t2));
        System.out.println("Solution: " + this.minWindow(s3, t3));
        System.out.println("Solution: " + this.minWindow("a", "b"));
        System.out.println("Solution: " + this.minWindow("ab", "b"));
        System.out.println("Solution: " + this.minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd"));

    }

    //Time: O(n)
    private String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        } else if (t.equals(s)) {
            return s;
        }
        Map<Character, Integer> tCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }
        int[] ixds = new int[2];
        int minSize = Integer.MAX_VALUE;
        int l = 0;
        int have = 0;
        int need = tCount.size();
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if (tCount.containsKey(c)) {
                tCount.put(c, tCount.get(c) - 1);
                if (tCount.get(c) == 0) {
                    have += 1;
                }
            }
            while (have == need) {
                //get size
                if (r - l + 1 < minSize) {
                    ixds[0] = l;
                    ixds[1] = r;
                    minSize = r - l + 1;
                }
                //shift left
                char lC = s.charAt(l);
                if (tCount.containsKey(lC)) {
                    tCount.put(lC, tCount.get(lC) + 1);
                    //check if have is broken or not
                    if (tCount.get(lC) > 0) {
                        have -= 1;
                    }
                }
                l += 1;
            }
        }

        return minSize == Integer.MAX_VALUE ? "" : s.substring(ixds[0], ixds[1] + 1);
    }

    //Time: O(n)
    private String minWindowNeetCode(String s, String t) {
        if (t.length() > s.length() || t.isEmpty()) {
            return "";
        }
        Map<Character, Integer> tCount = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }
        int[] res = new int[2];
        int minSize = Integer.MAX_VALUE;
        int l = 0;
        int have = 0;
        int need = tCount.size();
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (tCount.containsKey(c) && window.get(c).equals(tCount.get(c))) {
                have += 1;
            }
            while (have == need) {
                // update out result
                if ((r - l + 1) < minSize) {
                    res[0] = l;
                    res[1] = r;
                    minSize = r - l + 1;
                }
                //pop from the left of our window
                window.put(s.charAt(l), window.get(s.charAt(l)) - 1);
                if (tCount.containsKey(s.charAt(l)) && window.get(s.charAt(l)) < tCount.get(s.charAt(l))) {
                    have -= 1;
                }
                l += 1;
            }
        }

        return minSize == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
