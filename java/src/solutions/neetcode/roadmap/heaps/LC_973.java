package solutions.neetcode.roadmap.heaps;

import solutions.Solution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC_973 implements Solution {
    @Override
    public void solve() {

        int[][] points = new int[][]{new int[]{1, 3}, new int[]{-2, 2}};
        int k = 1;
        int[][] res = this.kClosest(points, k);
        System.out.println("Solution: ");
        for (int[] p : res) {
            System.out.println("\t- " + Arrays.toString(p));
        }
    }

    record DistancePoint(double distance, int[] point) {
    }

    private int[][] kClosest(int[][] points, int k) {
        PriorityQueue<DistancePoint> distances = new PriorityQueue<>(
                Comparator.comparingDouble(DistancePoint::distance));
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            double distance = Math.sqrt(Math.pow(0 - x, 2) + Math.pow(0 - y, 2));
            distances.add(new DistancePoint(distance, new int[]{x, y}));
        }
        int[][] res = new int[k][2];
        int i = 0;
        while (i < k) {
            res[i] = distances.remove().point;
            i++;
        }
        return res;
    }
}
