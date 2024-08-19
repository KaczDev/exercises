package solutions.neetcode.roadmap.backtracking;

import solutions.Solution;

import java.util.ArrayList;
import java.util.List;

public class LC_78 implements Solution {
    @Override
    public void solve() {
        System.out.println("Solution: "+this.subsets(new int[]{1,2,3}));
    }
    //Time: O(n * 2^n)
    private List<List<Integer>> res;
    private List<Integer> subset;

    public List<List<Integer>> subsets(int[] nums) {
        this.res = new ArrayList<>();
        this.subset = new ArrayList<>();
        this.dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int idxToTake) {
        if (idxToTake >= nums.length) {
            this.res.add(new ArrayList<>(subset));
            return;
        }
        // decision to include nums[i]
        subset.add(nums[idxToTake]);
        this.dfs(nums, idxToTake + 1);
        // decision not to include nums[i]
        subset.remove(this.subset.size() - 1);
        this.dfs(nums, idxToTake + 1);
    }
}
