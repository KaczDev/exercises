package solutions.neetcode.roadmap.bitmanipulation;

import solutions.Solution;

public class LC_190 implements Solution {
    @Override
    public void solve() {
        System.out.println("Solution: "+this.reverseBits(43261596));
    }
    // you need treat n as an unsigned value
    private int reverseBits(int n) {
        int res =0;
        for (int i =0;i<32;i++ ){
            int bit = (n>>i) & 1; //ith bit
            res = res | (bit << (31-i));
        }
        return res;
    }
}
