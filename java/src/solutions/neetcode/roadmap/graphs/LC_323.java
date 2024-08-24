package solutions.neetcode.roadmap.graphs;

import solutions.Solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC_323 implements Solution {
    @Override
    public void solve() {
        int n = 6;
        int[][] edges = new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3}, new int[]{4, 5}};
        System.out.println("Solution: " + this.countComponents(n, edges));
        System.out.println("Solution: " + this.countComponentsNeetCode(n, edges));
    }

    //Union Find
    private int countComponentsNeetCode(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            rank[i] = 1;
            parent[i] = i;
        }
        int res = n;
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            if (union(parent, rank, from, to)) {
                res -= 1;
            }
        }
        return res;
    }

    private int find(int[] parent, int[] rank, int n1) {
        int res = n1;
        while (res != parent[res]) {
            parent[res] = parent[parent[res]]; //path compression set parent to its grandparent
            res = parent[res];
        }
        return res;
    }

    //returns if the union was a succesfull operation
    // (nodes got linked to the same parents)
    private boolean union(int[] parent, int[] rank, int n1, int n2) {
        int p1 = find(parent, rank, n1);
        int p2 = find(parent, rank, n2);
        if (p1 == p2) {
            return false;
        }
        if (rank[p2] > rank[p1]) {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        } else {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        }
        return true;
    }

    private int countComponents(int n, int[][] edges) {
        //adjacency list
        Map<Integer, Set<Integer>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            adjList.putIfAbsent(from, new HashSet<>());
            adjList.putIfAbsent(to, new HashSet<>());
            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }
        //for each node, do dfs
        // in dfs add visited nodes to
        Set<Integer> visited = new HashSet<>();
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (visited.contains(i)) {
                continue;
            }
            this.dfs(adjList, visited, i);
            components += 1;
        }
        return components;
    }

    private void dfs(Map<Integer, Set<Integer>> adjList, Set<Integer> visited, int node) {
        if (visited.contains(node)) {
            return;
        }
        visited.add(node);
        for (int adj : adjList.getOrDefault(node, new HashSet<>())) {
            this.dfs(adjList, visited, adj);
        }
    }
}
