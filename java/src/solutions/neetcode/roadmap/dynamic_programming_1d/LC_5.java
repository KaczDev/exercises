package solutions.neetcode.roadmap.dynamic_programming_1d;

import solutions.Solution;

public class LC_5 implements Solution {
    @Override
    public void solve() {

        String s = "babad";
        System.out.println("Solution: " + this.longestPalindrome(s));
    }

    //Time: O(n^2).
//Substring makes it O(n^3) but if we handled it differently (like store l,r on the side and at the end do substring)
    public String longestPalindrome(String s) {
        String res = "";
        int resLen = 0;
        for (int i = 0; i < s.length(); i++) {
            // odd length
            int l = i, r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > resLen) {
                    res = s.substring(l, r + 1);
                    resLen += 1;
                }
                l -= 1;
                r += 1;
            }
            //even length
            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > resLen) {
                    res = s.substring(l, r + 1);
                    resLen += 1;
                }
                l -= 1;
                r += 1;
            }
        }
        return res;
    }
}
