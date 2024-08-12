package solutions.neetcode.roadmap.stacks;

import solutions.Solution;

import java.util.Stack;

public class LC_84 implements Solution {
    @Override
    public void solve() {
        int[] heights = {2, 1, 5, 6, 2, 3};

        System.out.println("Solution: " + this.largestRectangleArea(heights));

    }

    record Pair(int idx, int height) { }

    //Time: O(n)
    //Space: O(n)
    private int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Pair> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            int start = i;
            while (!stack.isEmpty() && stack.peek().height > heights[i]) {
                Pair p = stack.pop();
                maxArea = Math.max(maxArea, p.height * (i - p.idx));
                start = p.idx;
            }
            stack.push(new Pair(start, heights[i]));
        }
        while (!stack.isEmpty()) {
            Pair p = stack.pop();
            maxArea = Math.max(maxArea, p.height * (heights.length - p.idx));
        }
        return maxArea;
    }
}
