package solutions.leetcode.stacks;

import solutions.Solution;

import java.util.*;

//https://leetcode.com/problems/car-fleet/description/
public class LC_853 implements Solution {
    @Override
    public void solve() {

        int target = 12;
        int[] position = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};
        System.out.println("Solution: " + this.carFleet(target, position, speed));
    }

    record Pair(int pos, int speed) {}

    //Space: O(n) + Sorting O(n log n) = O(n log n)
    //Space: O(n)
    private int carFleet(int target, int[] position, int[] speed) {
        Pair[] pairs = new Pair[position.length];
        for (int i = 0; i < position.length; i++) {
            pairs[i] = new Pair(position[i], speed[i]);
        }
        Arrays.sort(pairs, (pair, t1) -> t1.pos - pair.pos); //Reverse Sorted Order
        Stack<Float> stack = new Stack<>();
        for (Pair p : pairs) {
            stack.push((float) (target - p.pos) / p.speed);
            if (stack.size() >= 2
                    && stack.peek() <= stack.elementAt(stack.size() - 2)) {
                stack.pop();
            }
        }
        return stack.size();
    }

}
