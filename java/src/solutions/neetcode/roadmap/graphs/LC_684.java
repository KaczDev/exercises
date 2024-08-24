package solutions.neetcode.roadmap.graphs;

import solutions.Solution;

import java.util.Arrays;

public class LC_684 implements Solution {
    @Override
    public void solve() {
        int[][] edges = new int[][]{new int[]{1, 2}, new int[]{1, 3}, new int[]{2, 3}};
        System.out.println("Solution: " + Arrays.toString(this.findRedundantConnection(edges)));
    }

    private int[] findRedundantConnection(int[][] edges) {
        int nodes = edges.length;
        int[] par = new int[nodes + 1];
        int[] rank = new int[nodes + 1];
        for (int i = 1; i < nodes + 1; i++) {
            par[i] = i;
            rank[i] = i;
        }
        for (int[] edge : edges) {
            int n1 = edge[0];
            int n2 = edge[1];
            if (!union(par, rank, n1, n2)) {
                return new int[]{n1, n2};
            }
        }
        return new int[2];
    }

    //Return false if cant complete, that means they're already conncted
    private boolean union(int[] par, int[] rank, int n1, int n2) {
        int p1 = find(par, n1);
        int p2 = find(par, n2);
        if (p1 == p2) {
            return false;
        }
        if (rank[p1] > rank[p2]) {
            par[p2] = p1;
            rank[p1] = rank[p2];
        } else {
            par[p1] = p2;
            rank[p2] = rank[p1];
        }
        return true;
    }

    private int find(int[] par, int n) {
        int p = par[n];
        while (p != par[p]) {
            par[p] = par[par[p]];//path compression
            p = par[p];
        }
        return p;
    }
}
