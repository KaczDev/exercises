package solutions.neetcode.roadmap.twopointers;

import solutions.Solution;

import java.util.Arrays;

//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
public class LC_167 implements Solution {
    @Override
    public void solve() {
        int[] numbers1 = new int[]{2, 7, 11, 15};
        int target1 = 9;
        int[] numbers2 = new int[]{2, 3, 4};
        int target2 = 6;
        int[] numbers3 = new int[]{-1, 0};
        int target3 = -1;
        int[] numbers4 = new int[]{3, 24, 50, 79, 88, 150, 345};
        int target4 = 200;
        System.out.println("Solution: " + Arrays.toString(this.twoSum(numbers1, target1)));
        System.out.println("Solution: " + Arrays.toString(this.twoSum(numbers2, target2)));
        System.out.println("Solution: " + Arrays.toString(this.twoSum(numbers3, target3)));
        System.out.println("Solution: " + Arrays.toString(this.twoSum(numbers4, target4)));

    }

    //Time: O(n)
    //Space: O(1)
    private int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        int[] res = new int[2];
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                break;
            }
            if (numbers[left] + numbers[right] < target) {
                left += 1;
            }
            if (numbers[left] + numbers[right] > target) {
                right -= 1;
            }
        }
        res[0] = left + 1;
        res[1] = right + 1;
        return res;
    }
}
