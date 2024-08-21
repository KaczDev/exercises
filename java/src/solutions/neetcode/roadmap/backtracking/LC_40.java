package solutions.neetcode.roadmap.backtracking;

import solutions.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_40 implements Solution {
    @Override
    public void solve() {
        System.out.println("Solution: "+this.combinationSum2(new int[]{10,1,2,7,6,1,5},8));
    }

    List<List<Integer>> res;
    List<Integer> combs;

    // Time: O(n * 2^n)
    // TIme: O(n)
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // We sort it to have duplicate elements adjacent
        Arrays.sort(candidates);
        this.res = new ArrayList<>();
        this.combs = new ArrayList<>();
        this.recurse(candidates, target, 0, 0);
        return res;
    }

    private void recurse(int[] candidates, int target, int idxToTake, int curSum) {
        if (target == curSum) {
            this.res.add(new ArrayList<>(this.combs));
            return;
        }
        if (idxToTake >= candidates.length || curSum > target) {
            return;
        }
        // Include candidates[idxToTake]
        this.combs.add(candidates[idxToTake]);
        this.recurse(candidates, target, idxToTake + 1, curSum + candidates[idxToTake]);
        this.combs.remove(this.combs.size() - 1);
        // skip candidates[idxToTake]
        // skip the adjacent duplicates
        while (idxToTake + 1 < candidates.length && candidates[idxToTake] == candidates[idxToTake + 1]) {
            idxToTake += 1;
        }
        this.recurse(candidates, target, idxToTake + 1, curSum);
    }

}
