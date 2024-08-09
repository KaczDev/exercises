package solutions.leetcode.arrays;

import solutions.Solution;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
public class LC_121 implements Solution {
    @Override
    public void solve() {
        int[] prices1 = new int[]{7, 1, 5, 3, 6, 4};
        int[] prices2 = new int[]{7, 6, 4, 3, 1};

        System.out.println(this.solution(prices1));
        System.out.println(this.solution(prices2));
    }

    // Time: (n)
    // Space: O(1)
    private int solution(int[] prices) {
        int maxProfit = 0;
        int left = 0; //buy
        int right = 1; //sell
        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                int profit = prices[right] - prices[left];
                maxProfit = Math.max(profit, maxProfit);
            } else {
                left = right;
            }
            right += 1;
        }
        return maxProfit;
    }
}
