package solutions.neetcode.roadmap.dynamic_programming_1d;

import solutions.Solution;

public class LC_647 implements Solution {
    @Override
    public void solve() {
        System.out.println("Solution: "+this.countSubstrings("aaa"));
    }
    // Time: O(n^2)
    public int countSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            // odd length palindromes
            res += this.countPali(s, i, i);
            // even length palindromes
            res += this.countPali(s, i, i + 1);

        }
        return res;
    }

    private int countPali(String s, int l, int r) {
        int res = 0;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            res += 1;
            l -= 1;
            r += 1;
        }
        return res;
    }}
