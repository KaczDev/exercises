package solutions.leetcode.arrays;

import solutions.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class LC_539 implements Solution {
    @Override
    public void solve() {
        List<String> l = new ArrayList<>();
        l.add("23:59");
        l.add("00:00");
        System.out.println("Solution:" + this.findMinDifference(l));
        System.out.println("Solution:" + this.findMinDifferenceBucketSort(l));
        l.clear();
        l.add("00:00");
        l.add("23:59");
        l.add("00:00");
        System.out.println("Solution:" + this.findMinDifference(l));
        System.out.println("Solution:" + this.findMinDifferenceBucketSort(l));
        l.clear();
        l.add("00:10");
        l.add("23:40");
        System.out.println("Solution:" + this.findMinDifference(l));
        System.out.println("Solution:" + this.findMinDifferenceBucketSort(l));
    }

    private int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        // we set the res to the minutes between the last and first time in the list.
        int res = 24 * 60
                - getMinutes(timePoints.get(timePoints.size() - 1))
                + getMinutes(timePoints.get(0));
        for (int i = 0; i < timePoints.size() - 1; i++) {
            int cur = getMinutes(timePoints.get(i + 1));
            int prev = getMinutes(timePoints.get(i));
            res = Math.min(res, cur - prev);
        }
        return res;
    }

    private int findMinDifferenceBucketSort(List<String> timePoints) {
        boolean[] exists = new boolean[60 * 24];
        int first_m = 60 * 24;
        int last_m = 0;
        for (String t : timePoints) {
            int m = getMinutes(t);
            if (exists[m]) {
                return 0;
            }
            exists[m] = true;
            first_m = Math.min(first_m, m);
            last_m = Math.max(last_m, m);
        }
        int res = 60 * 24 - last_m + first_m;
        int prev_m = first_m;
        for (int m = first_m + 1; m <= last_m; m++) {
            if (exists[m]){
                res = Math.min(m-prev_m,res);
                prev_m = m;
            }
        }
        return res;
    }

    private int getMinutes(String time) {
        String[] hourMinutes = time.split(":");
        int minutes = Integer.parseInt(hourMinutes[1]);
        minutes += Integer.parseInt(hourMinutes[0]) * 60;
        return minutes;
    }
}
