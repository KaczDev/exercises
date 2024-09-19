package solutions.leetcode.dynamic_programming;

import solutions.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;

public class LC_241 implements Solution {
    @Override
    public void solve() {
        String expression = "2-1-1";
        System.out.println("Solution: " + diffWaysToCompute(expression));
        expression = "2*3-4*5";
        System.out.println("Solution: " + diffWaysToCompute(expression));
    }


    Set<Character> operations = Set.of('+', '-', '*');

    public List<Integer> diffWaysToCompute(String expression) {
        return backtrack(expression, 0, expression.length() - 1);
    }

    private int operation(char sign, int x, int y) {
        return switch (sign) {
            case '+' -> x + y;
            case '-' -> x - y;
            case '*' -> x * y;
            default -> throw new RuntimeException();
        };
    }

    private List<Integer> backtrack(String expression, int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i < right + 1; i++) {
            char op = expression.charAt(i);
            if (operations.contains(op)) {
                List<Integer> nums1 = backtrack(expression, left, i - 1);
                List<Integer> nums2 = backtrack(expression, i + 1, right);
                for (int n1 : nums1) {
                    for (int n2 : nums2) {
                        res.add(this.operation(op, n1, n2));
                    }
                }
            }
        }
        if (res.isEmpty()) {
            res.add(Integer.parseInt(expression.substring(left, right + 1)));
        }
        return res;
    }
}
