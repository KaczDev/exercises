package solutions.leetcode.twopointers;

import org.w3c.dom.ls.LSOutput;
import solutions.Solution;

import java.io.CharConversionException;

public class LC_125 implements Solution {
    @Override
    public void solve() {
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";
        String s3 = " ";
        System.out.println("Solution: " + this.isPalindrome(s1));
        System.out.println("Solution: " + this.isPalindrome(s2));
        System.out.println("Solution: " + this.isPalindrome(s3));
    }

    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            while (!this.isAlphanumeric(s.charAt(i)) && i < j) {
                i += 1;
            }
            while (!this.isAlphanumeric(s.charAt(j)) && j > i) {
                j -= 1;
            }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i += 1;
            j -= 1;
        }
        return true;
    }

    private boolean isAlphanumeric(char c) {
        return Character.isAlphabetic(c) || Character.isDigit(c);
    }

    private String convertS(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isAlphabetic(c) || Character.isDigit(c)) {
                c = Character.toLowerCase(c);
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
