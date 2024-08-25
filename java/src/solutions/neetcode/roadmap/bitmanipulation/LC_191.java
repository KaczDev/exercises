package solutions.neetcode.roadmap.bitmanipulation;

import solutions.Solution;

public class LC_191 implements Solution {
    @Override
    public void solve() {
        int n = 11;
        System.out.println("Solution: " + this.hammingWeight(n));
        System.out.println("Solution: " + this.hammingWeight2(n));
        n = 128;
        System.out.println("Solution: " + this.hammingWeight(n));
        System.out.println("Solution: " + this.hammingWeight2(n));
        n = 2147483645;
        System.out.println("Solution: " + this.hammingWeight(n));
        System.out.println("Solution: " + this.hammingWeight2(n));
    }

    int hammingWeight(int n) {
        int res = 0;
        while (n > 0) {
//            System.out.printf("n: %d mod: %d, aftershift: %d%n", n, n % 2, n >> 1);
            res += n % 2; // it will return 1 or 0 on the rightmost bit
            n = n >> 1; // shift bits to the right
        }
        return res;
    }

    int hammingWeight2(int n) {
        int res = 0;
        while (n > 0) {
            n = n & (n - 1);
            res += 1;
        }
        return res;
    }
}
