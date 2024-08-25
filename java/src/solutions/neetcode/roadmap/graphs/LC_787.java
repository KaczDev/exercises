package solutions.neetcode.roadmap.graphs;

import solutions.Solution;

import java.util.Arrays;

public class LC_787 implements Solution {
    @Override
    public void solve() {
        int n = 4;
        int[][] flights = new int[][]{{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        int src = 0;
        int dst = 3;
        int k = 1;
        System.out.println(this.findCheapestPrice(n, flights, src, dst, k));
        n = 10;
        flights = new int[][]{{0, 1, 20}, {1, 2, 20}, {2, 3, 30}, {3, 4, 30}, {4, 5, 30}, {5, 6, 30}, {6, 7, 30}, {7, 8, 30}, {8, 9, 30}, {0, 2, 9999}, {2, 4, 9998}, {4, 7, 9997}};
        src = 0;
        dst = 9;
        k = 4;
        System.out.println(this.findCheapestPrice(n, flights, src, dst, k));
    }
    // Time: O(E*K)
    private int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;
        for (int i = 0; i < k + 1; i++) {
            int[] tmpPrices = Arrays.copyOf(prices, n);
            for (int[] flight : flights) {
                int s = flight[0];
                int d = flight[1];
                int p = flight[2];
                if (prices[s] == Integer.MAX_VALUE) {
                    continue;
                }
                if ((prices[s] + p) < tmpPrices[d]) {
                    tmpPrices[d] = prices[s] + p;
                }
            }
            prices = tmpPrices;
        }
        return prices[dst] == Integer.MAX_VALUE
                ? -1
                : prices[dst];
    }
}
