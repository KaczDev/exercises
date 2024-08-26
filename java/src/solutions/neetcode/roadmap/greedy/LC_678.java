package solutions.neetcode.roadmap.greedy;

import solutions.Solution;

public class LC_678 implements Solution {
    @Override
    public void solve() {
        System.out.println("Solution: "+this.checkValidString("(*)("));
        System.out.println("Solution: "+this.checkValidString("(*))"));
    }
    private boolean checkValidString(String s) {
        // valid range of possibilities (calculated when * is met)
        // leftMin and leftMax should never be < 0 for string to be valid
        int leftMin = 0;
        int leftMax = 0;
        for (char c : s.toCharArray()) {
            if (c == '*') {
                leftMin -= 1;
                leftMax += 1;
            } else if (c == '(') {
                leftMin += 1;
                leftMax += 1;
            } else {
                leftMin -= 1;
                leftMax -= 1;
            }
            if (leftMax < 0) {
                return false;
            }
            if (leftMin < 0) { //We need to set leftMin to 0, otherwise we would return true for string "(*)("
                leftMin = 0;
            }
        }
        return leftMin == 0;
    }
}
