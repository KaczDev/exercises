package solutions.leetcode.arrays;

import solutions.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/encode-and-decode-strings/
//https://neetcode.io/problems/string-encode-and-decode
public class LC_659 implements Solution {
    @Override
    public void solve() {
        String[] strs1 = new String[]{"lint", "code", "love", "you"};
        String[] strs2 = new String[]{"we", "say", ":", "yes"};
        System.out.println("Solution: " + Arrays.toString(this.decode(this.encode(strs1))));
        System.out.println("Solution: " + Arrays.toString(this.decode(this.encode(strs2))));
    }

    private final char DELIMITER = '#';

    private String encode(String[] strings) {
        StringBuilder res = new StringBuilder();
        for (String str : strings) {
            res.append(String.format("%d%c%s", str.length(), DELIMITER, str));
        }
        return res.toString();
    }

    private String[] decode(String encoded) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < encoded.length()) {
            int j = i;
            while (encoded.charAt(j) != DELIMITER) {
                j++;
            }
            String lenStr = encoded.substring(i, j);
            int len = Integer.parseInt(lenStr);
            j++;
            String word = encoded.substring(j, j + len);
            res.add(word);
            i = j + len;
        }
        return res.toArray(new String[0]);
    }
}
