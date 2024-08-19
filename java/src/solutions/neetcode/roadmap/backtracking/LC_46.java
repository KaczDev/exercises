package solutions.neetcode.roadmap.backtracking;

import solutions.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_46 implements Solution {
    @Override
    public void solve() {
        System.out.println("Solution: " + this.permute(new int[]{1, 2, 3}));
        System.out.println("Solution: " + this.permuteIterative(new int[]{1, 2, 3}));
    }
    public List<List<Integer>> permuteIterative(int[] nums) {
        List<List<Integer>> perms = new ArrayList<>();
        perms.add(new ArrayList<>());

        for (int num: nums){
            List<List<Integer>> newPerms = new ArrayList<>();
            for (List<Integer> p : perms){
                for (int i =0;i<p.size()+1;i++){
                    List<Integer> pCopy = new ArrayList<>(p);
                    pCopy.add(i,num);
                    newPerms.add(pCopy);
                }
            }
            perms = newPerms;
        }
        return perms;
    }

    public List<List<Integer>> permute(int[] nums) {
        return this.recurse(nums, 0);
    }

    public List<List<Integer>> recurse(int[] nums, int idxToAdd) {
        if (nums.length <= idxToAdd) {
            List<List<Integer>> emptySub = new ArrayList<>();
            emptySub.add(new ArrayList<>());
            return emptySub;
        }
        List<List<Integer>> perms = this.recurse(nums, idxToAdd + 1);
        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> p : perms) {
            for (int i = 0; i < p.size() + 1; i++) {
                List<Integer> pCopy = new ArrayList<>(p);
                pCopy.add(i, nums[idxToAdd]);
                res.add(pCopy);
            }
        }
        return res;
    }
}