package solutions.leetcode.stacks;

import solutions.Solution;

import java.util.*;

public class LC_22 implements Solution {

    private StringBuilder sb; //We make it behave like a stack

    private List<String> res;

    @Override
    public void solve() {
        int n1 = 3;
        int n2 = 1;
        System.out.println("Solution: " + this.generateParenthesis(n1));
        System.out.println("Solution: " + this.generateParenthesis(n2));
    }


    private List<String> generateParenthesis(int n) {
        this.res = new ArrayList<>();
        this.sb = new StringBuilder();
        this.recurse(0, 0, n);

        return res;
    }

    private void recurse(int open, int closed, int n) {
        if (open == closed && closed == n) {
            String valid = this.sb.toString();
            this.res.add(valid);
        }
        if (open < n) {
            this.sb.append("(");
            this.recurse(open + 1, closed, n);
            this.sb.deleteCharAt(sb.length() - 1);
        }
        if (closed < open) {
            this.sb.append(")");
            this.recurse(open, closed + 1, n);
            this.sb.deleteCharAt(sb.length() - 1);
        }
    }
}
