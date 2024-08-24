package solutions.neetcode.roadmap.graphs;

import solutions.Solution;

import java.sql.Array;
import java.util.*;

public class LC_332 implements Solution {
    @Override
    public void solve() {
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(List.of("JFK", "SFO"));
        tickets.add(List.of("JFK", "ATL"));
        tickets.add(List.of("SFO", "ATL"));
        tickets.add(List.of("ATL", "JFK"));
        tickets.add(List.of("ATL", "SFO"));
        System.out.println("Solution: " + this.findItinerary(tickets));
        System.out.println("Solution: " + this.findItineraryNC(tickets));
    }
    //THIS CODE GETS TIME LIMITED BUT IT WORKS (LC ADDED A TEST)

    // Time: O(V+E)^2 = O(E^2) (because of potential backtracking)
// Space: O(E)
    public List<String> findItinerary(List<List<String>> tickets) {
        // if res lists are equal, the one that
        // is smaller alphabetically (A < B) should be returned
        // Connections should be in sorted order as we want low lexical
        Map<String, List<String>> conns = new HashMap<>();
        for (List<String> connection : tickets) {
            String from = connection.get(0);
            String to = connection.get(1);
            conns.putIfAbsent(from, new ArrayList<>());
            conns.putIfAbsent(to, new ArrayList<>());
            conns.get(from).add(to);
        }
        // Sort the connections
        for (List<String> value : conns.values()) {
            Collections.sort(value);
        }
        List<String> res = new ArrayList<>();
        res.add("JFK");
        this.dfs(conns, res, "JFK", tickets.size());
        return res;
    }

    private boolean dfs(Map<String, List<String>> adjList, List<String> res, String src, int ticketsLen) {
        if (res.size() == ticketsLen + 1) {
            return true;
        }
        if (!adjList.containsKey(src)) {
            return false;
        }
        List<String> temp = new ArrayList<>(adjList.get(src));
        for (int i = 0; i < temp.size(); i++) {
            String v = adjList.get(src).remove(i);
            res.add(v);
            if (this.dfs(adjList, res, v, ticketsLen)) {
                return true;
            }
            adjList.get(src).add(i, v);
            res.remove(res.size() - 1);
        }
        return false;
    }

    public List<String> findItineraryNC(List<List<String>> tickets) {
        Map<String, List<String>> adj = new HashMap<>();
        List<String> res = new ArrayList<>();

        for (List<String> ticket : tickets) {
            String src = ticket.get(0);
            String dst = ticket.get(1);
            adj.putIfAbsent(src, new ArrayList<>());
            adj.get(src).add(dst);
        }

        for (String key : adj.keySet()) {
            Collections.sort(adj.get(key));
        }

        dfsNC(adj, res, "JFK");
        Collections.reverse(res);

        if (res.size() != tickets.size() + 1) {
            return new ArrayList<>();
        }

        return res;
    }

    private void dfsNC(Map<String, List<String>> adj, List<String> result, String src) {
        if (adj.containsKey(src)) {
            List<String> destinations = new ArrayList<>(adj.get(src));
            while (!destinations.isEmpty()) {
                String dest = destinations.get(0);
                adj.get(src).remove(0);
                dfsNC(adj, result, dest);
                destinations = new ArrayList<>(adj.get(src));
            }
        }
        result.add(src);
    }
}
