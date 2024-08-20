package solutions.neetcode.roadmap.backtracking;

import solutions.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_90 implements Solution {
    @Override
    public void solve() {
        System.out.println("Solution: "+this.subsetsWithDup(new int[]{1,2,2,3}));
    }

    private List<List<Integer>> res;
    private List<Integer> subset;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.res = new ArrayList<>();
        this.subset = new ArrayList<>();

        Arrays.sort(nums);
        this.backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int idxToTake) {
        if (idxToTake >= nums.length) {
            this.res.add(new ArrayList<>(subset));
            return;
        }
        // decision to include nums[i]
        subset.add(nums[idxToTake]);
        this.backtrack(nums, idxToTake + 1);
        // decision not to include nums[i]
        subset.remove(this.subset.size() - 1);
        // move the idxToTake until non-duplicate number is found
        while (idxToTake + 1 < nums.length && nums[idxToTake] == nums[idxToTake + 1]) {
            idxToTake += 1;
        }
        this.backtrack(nums, idxToTake + 1);
    }
}
