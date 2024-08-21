package solutions.neetcode.roadmap.backtracking;

import solutions.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LC_17 implements Solution {
    Map<Character, String> keyboard = Map.of(
            '2', "abc",
            '3', "def",
            '4', "ghi",
            '5', "jkl",
            '6', "mno",
            '7', "pqrs",
            '8', "tuv",
            '9', "wxyz"
    );

    @Override
    public void solve() {
        System.out.println("Solution: " + this.letterCombinations("23"));
    }

    //TIme: O(n*4^n)
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        char[] digitsC = digits.toCharArray();
        List<String> combs = new ArrayList<>();
//        this.dfs(digitsC, 0, combs, new StringBuilder());
        this.dfs(digitsC, 0, combs, "");
        return combs;
    }

    private void dfs(char[] digits, int i, List<String> combs, String sb) {
        if (i == digits.length) {
            combs.add(sb);
            return;
        }

        for (char c : this.keyboard.get(digits[i]).toCharArray()) {
//            sb.append(c);
            this.dfs(digits, i + 1, combs, sb + c);
//            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
