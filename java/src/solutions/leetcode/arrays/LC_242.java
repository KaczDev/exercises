package solutions.leetcode.arrays;

import solutions.Solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/valid-anagram/description/
public class LC_242 implements Solution {

    @Override
    public void solve() {
        String s1 = "anagram", t1 = "nagaram";
        String s2 = "rat", t2 = "car";
        String s3 = "aacc", t3 = "ccac";
        System.out.println("Solution: " + this.isAnagram(s1, t1));
        System.out.println("Solution: " + this.isAnagram(s2, t2));
        System.out.println("Solution: " + this.isAnagram(s3, t3));
    }

    private boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); ++i) {
            Character sChar = s.charAt(i);
            if (map.containsKey(sChar)) {
                Integer sVal = map.get(sChar);
                sVal += 1;
                map.put(sChar, sVal);
            } else {
                map.put(sChar, 1);
            }
        }
        for (int i = 0; i < t.length(); ++i) {
            Character tChar = t.charAt(i);
            if (map.containsKey(t.charAt(i))) {
                Integer tVal = map.get(tChar);
                tVal -= 1;
                if (tVal == 0) {
                    map.remove(tChar);
                } else {
                    map.put(tChar, tVal);
                }
            } else {
                break;
            }
        }
        return map.isEmpty();
    }

}
