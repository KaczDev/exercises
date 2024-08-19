package solutions.neetcode.roadmap.backtracking;

import solutions.Solution;

import java.util.ArrayList;
import java.util.List;

public class LC_39 implements Solution {
    @Override
    public void solve() {
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        System.out.println("Solution: " + this.combinationSum(candidates, target));
    }

    private List<Integer> combination;
    private List<List<Integer>> res;
    //Time: O(2^t) //t is the height of the recursion tree
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.combination = new ArrayList<>();
        this.res = new ArrayList<>();
        this.dfs(candidates, target, 0, 0);
        return this.res;
    }

    private void dfs(int[] candidates, int target, int idxToTake, int curSum) {
        if (curSum == target) {
            this.res.add(new ArrayList<>(this.combination));
            return;
        }
        if (idxToTake >= candidates.length || curSum > target) {
            return;
        }
        // call dfs candidates.length times as duplicates are allowed
        for (int i = idxToTake; i < candidates.length; i++) {
            this.combination.add(candidates[i]);
            this.dfs(candidates, target, i, curSum + candidates[i]);
            this.combination.remove(this.combination.size() - 1);
        }
    }
}
