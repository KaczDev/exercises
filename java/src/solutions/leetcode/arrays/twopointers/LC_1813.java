package solutions.leetcode.arrays.twopointers;

import solutions.Solution;

public class LC_1813 implements Solution {
    @Override
    public void solve() {
        String sentence1 = "My name is Haley";
        String sentence2 = "My Haley";
        System.out.println("Solution: " + this.areSentencesSimilar(sentence1, sentence2));
        sentence1 = "of";
        sentence2 = "A lot of words";
        System.out.println("Solution: " + this.areSentencesSimilar(sentence1, sentence2));
        sentence1 = "Eating right now";
        sentence2 = "Eating";
        System.out.println("Solution: " + this.areSentencesSimilar(sentence1, sentence2));
    }

    // Time: O(n+m)
// Space: O(n+m)
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");
        //s1 is always shorter after that
        if (s2.length < s1.length) {
            String[] s = s2;
            s2 = s1;
            s1 = s;
        }
        //s1 should be the prefix, suffix or combination of both
        int l1 = 0, l2 = 0;
        // longest matching prefix
        while (l1 < s1.length && l2 < s2.length && s1[l1].equals(s2[l2])) {
            l1 += 1;
            l2 += 1;
        }
        //longest matching suffix
        int r1 = s1.length - 1, r2 = s2.length - 1;
        while (r1 >= 0 && r2 >= 00 && s1[r1].equals(s2[r2])) {
            r1 -= 1;
            r2 -= 1;
        }
        return l1 > r1;
    }
}
