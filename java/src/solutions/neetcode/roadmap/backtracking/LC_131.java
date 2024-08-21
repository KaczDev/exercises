package solutions.neetcode.roadmap.backtracking;

import solutions.Solution;

import java.util.ArrayList;
import java.util.List;

public class LC_131 implements Solution {
    @Override
    public void solve() {
        System.out.println("Solution: " + this.partition("aab"));
        System.out.println("Solution: " + this.partition("a"));
        System.out.println("Solution: " + this.partition("bb"));
    }

    List<List<String>> res;
    List<String> parts;

    public List<List<String>> partition(String s) {
        this.res = new ArrayList<>();
        this.parts = new ArrayList<>();
        this.recurse(s, 0);
        return this.res;
    }

    private void recurse(String s, int i) {
        if (i >= s.length()) {
            this.res.add(new ArrayList<>(this.parts));
            return;
        }

        for (int j = i; j < s.length(); j++) {
            if (this.isPalindrome(s.substring(i, j + 1))) {
                this.parts.add(s.substring(i, j + 1));
                this.recurse(s, j + 1);
                this.parts.remove(this.parts.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s1) {
        if (s1.length() <= 1) {
            return true;
        }
        int l = 0;
        int r = s1.length() - 1;
        while (l < r) {
            if (s1.charAt(l) != s1.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
