package solutions.leetcode.bitmanipulation;

import solutions.Solution;

public class LC_2220 implements Solution {
    @Override
    public void solve() {
        System.out.println("Solution: "+this.minBitFlips(10,7));
    }
    private int minBitFlips(int start, int goal) {
        int t = start ^ goal;
        int res=0;
        while (t!=0){
            res += t&1;
            t=t>>1;
        }
        return res;
    }
}
