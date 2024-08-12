package solutions.neetcode.roadmap.binarysearch;

import com.sun.security.jgss.GSSUtil;
import solutions.Solution;

import java.util.Arrays;

//https://leetcode.com/problems/koko-eating-bananas/description/
public class LC_875 implements Solution {
    @Override
    public void solve() {
        try {
            int[] piles1 = {3, 6, 7, 11};
            int h1 = 8;
            int[] piles2 = {30, 11, 23, 4, 20};
            int h2 = 5;
            int[] piles3 = {30, 11, 23, 4, 20};
            int h3 = 6;
            System.out.println("Solution: " + this.minEatingSpeed(piles1, h1));
            System.out.println("Solution: " + this.minEatingSpeed(piles2, h2));
            System.out.println("Solution: " + this.minEatingSpeed(piles3, h3));
            System.out.println("Solution: " + this.minEatingSpeed(new int[]{805306368, 805306368, 805306368}, 1000000000));
            System.out.println("Solution: " + this.minEatingSpeed(new int[]{3, 6, 7, 11}, 18));
        } catch (Exception e) {
            System.out.println("dupa");
        }
    }

    private int minEatingSpeed(int[] piles, int h) {
        // h is always >= piles.length()
        int lo = 1;
        int hi = Arrays.stream(piles).max().orElseThrow();
        int res = hi;
        while (lo <= hi) {
            int speed = (lo + hi) / 2;
            long hours = 0;
            for (int pile : piles) {
                hours += (long)Math.ceil((double)pile/speed);
            }
            if (hours > h) {
                lo = speed + 1;
            } else {
                res = Math.min(speed, res);
                hi = speed - 1;
            }
        }
        return res;
    }
}
