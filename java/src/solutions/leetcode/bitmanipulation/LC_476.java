package solutions.leetcode.bitmanipulation;

import solutions.Solution;

public class LC_476 implements Solution {
    @Override
    public void solve() {
        System.out.println("Solution: "+this.findComplement(5));
    }

    public int findComplement(int num) {
        if (num == 0) return 1;

        int bitLength = Integer.toBinaryString(num).length();

        int mask = (1 << bitLength) - 1;

        return num ^ mask;
    }

}
