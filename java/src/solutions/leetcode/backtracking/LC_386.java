package solutions.leetcode.backtracking;

import solutions.Solution;

import java.util.List;
import java.util.ArrayList;

public class LC_386 implements Solution {
    @Override
    public void solve() {
        System.out.println("Solution: "+ this.lexicalOrder(13));
        System.out.println("Solution: "+ this.lexicalOrder(2));
        System.out.println("Solution: "+ this.lexicalOrderOptimizedMemory(13));
        System.out.println("Solution: "+ this.lexicalOrderOptimizedMemory(2));
    }
    private List<Integer> lexicalOrderOptimizedMemory(int n) {
        List<Integer> res = new ArrayList<>(n);
        int cur =1;
        while(res.size()<n){
            res.add(cur);
            if (cur*10<=n){
                cur *=10;
            }else {
                while (cur==n || cur%10==9){
                    cur = cur/10;
                }
                cur+=1;
            }
        }
        return res;
    }

    //Time: O(n)
    //Space: O(log10N)
    private List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>(n);
        for (int i = 1; i < 10; i++) {
            this.dfs(n, i, res);
        }
        return res;
    }

    private void dfs(int n, int curr, List<Integer> res) {
        if (curr > n) {
            return;
        }
        res.add(curr);
        curr *= 10;
        for (int i = 0; i < 10; i++) {
            this.dfs(n, curr + i, res);
        }
    }
}
