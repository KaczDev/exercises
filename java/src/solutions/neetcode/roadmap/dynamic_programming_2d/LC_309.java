package solutions.neetcode.roadmap.dynamic_programming_2d;

import solutions.Solution;

import java.util.HashMap;
import java.util.Map;

public class LC_309 implements Solution {
    @Override
    public void solve() {
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println("Solution: " + this.maxProfit(prices));
    }

    // Time: O(2^n), with caching O(n)
    // Space: O(n)
    private int maxProfit(int[] prices) {
        // State: Buying or Selling
        // If Buy -> i+1
        // If Sell-> i+2
        Map<State, Integer> dp = new HashMap<>();
        return this.dfs(prices, dp, new State(0, true));
    }

    private int dfs(int[] prices, Map<State, Integer> dp, State state) {
        if (state.i >= prices.length) {
            return 0;
        }
        if (dp.containsKey(state)) {
            return dp.get(state);
        }
        if (state.buying) {
            int buy = dfs(prices, dp, new State(state.i + 1, false)) - prices[state.i]; //we decided to buy, decrease the profit
            int cooldown = dfs(prices, dp, new State(state.i + 1, state.buying));
            dp.put(state, Math.max(buy, cooldown)); //cache max profit
        } else {
            int sell = dfs(prices, dp, new State(state.i + 2, true)) + prices[state.i]; //we sold, increase the profit
            int cooldown = dfs(prices, dp, new State(state.i + 1, state.buying));
            dp.put(state, Math.max(sell, cooldown)); //cache max profit
        }
        return dp.get(state);
    }

    record State(int i, boolean buying) {
    } // false => selling state
}
