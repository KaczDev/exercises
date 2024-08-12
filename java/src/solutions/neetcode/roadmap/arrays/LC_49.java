package solutions.neetcode.roadmap.arrays;

import solutions.Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC_49 implements Solution {
    @Override
    public void solve() {
        String[] anagrams1 = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] anagrams2 = new String[]{""};
        String[] anagrams3 = new String[]{"a"};
        System.out.println("Solution: " + this.groupAnagrams(anagrams1));
        System.out.println("Solution: " + this.groupAnagrams(anagrams2));
        System.out.println("Solution: " + this.groupAnagrams(anagrams3));
    }

    private List<List<String>> groupAnagrams(String[] anagrams) {
        Map<Map<Character, Integer>, List<String>> group = new HashMap<>();
        for (String word : anagrams) {
            Map<Character, Integer> freq = this.frequencies(word);
            if (group.containsKey(freq)) {

                List<String> groupedAnagrams = group.get(freq);
                groupedAnagrams.add(word);
                group.put(freq, groupedAnagrams);
            } else {
                List<String> s = new ArrayList<>();
                s.add(word);
                group.put(freq, s);
            }
        }
        return new ArrayList<>(group.values());
    }

    private Map<Character, Integer> frequencies(String word) {
        Map<Character, Integer> f = new HashMap<>();
        for (char c : word.toCharArray()) {
            f.put(c, f.getOrDefault(c, 0) + 1);
        }
        return f;
    }
}
