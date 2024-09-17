package solutions.leetcode.arrays;

import solutions.Solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class LC_884 implements Solution {

    // Time: O(m+n)
    private String[] uncommonFromSentences(String s1, String s2) {
        Set<String> uncommon = new HashSet<>();
        Set<String> blocked = new HashSet<>();
        for (String s : s1.split(" ")) {
            if (blocked.contains(s)) {
                continue;
            } else if (uncommon.contains(s)) {
                blocked.add(s);
                uncommon.remove(s);
            } else {
                uncommon.add(s);
            }
        }
        for (String s : s2.split(" ")) {
            if (blocked.contains(s)) {
                continue;
            } else if (uncommon.contains(s)) {
                blocked.add(s);
                uncommon.remove(s);
            } else {
                uncommon.add(s);
            }
        }
        String[] res = new String[uncommon.size()];
        int i = 0;
        for (String u : uncommon) {
            res[i] = u;
            i++;
        }
        return res;
    }

    private String[] uncommonFromSentences2(String s1, String s2) {
        return Arrays.stream((s1 + " " + s2).split(" "))
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .toArray(String[]::new);
    }

    @Override
    public void solve() {
        String s1 = "this apple is sweet";
        String s2 = "this apple is sour";
        System.out.println("Solution: " + Arrays.toString(this.uncommonFromSentences(s1, s2)));
        System.out.println("Solution: " + Arrays.toString(this.uncommonFromSentences2(s1, s2)));
    }
}
