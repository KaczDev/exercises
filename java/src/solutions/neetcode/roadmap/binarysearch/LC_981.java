package solutions.neetcode.roadmap.binarysearch;

import solutions.Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC_981 implements Solution {
    @Override
    public void solve() {
//        TimeMap timeMap = new TimeMap();
//        timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
//        System.out.println(timeMap.get("foo", 1));         // return "bar"
//        System.out.println(timeMap.get("foo", 3));         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
//        timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
//        System.out.println(timeMap.get("foo", 4));         // return "bar2"
//        System.out.println(timeMap.get("foo", 5));         // return "bar2"
//

        TimeMap timeMap = new TimeMap();
        timeMap.set("love", "high", 10);
        timeMap.set("love", "low", 20);
        System.out.println(timeMap.get("love", 5));
        System.out.println(timeMap.get("love", 10));
        System.out.println(timeMap.get("love", 15));
        System.out.println(timeMap.get("love", 20));
        System.out.println(timeMap.get("love", 25));
    }

    record Tuple(String val, int tstamp) {
    }

    static class TimeMap {
        private final Map<String, List<Tuple>> cache;

        public TimeMap() {
            this.cache = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            Tuple t = new Tuple(value, timestamp);
            this.cache.putIfAbsent(key, new ArrayList<>());
            this.cache.get(key).add(t);
        }

        public String get(String key, int timestamp) {
            if (this.cache.containsKey(key)) {
                List<Tuple> list = this.cache.get(key);
                if (timestamp >= list.get(list.size() - 1).tstamp) {
                    return list.get(list.size() - 1).val;
                }
                int l = 0;
                int r = list.size() - 1;
                while (l + 1 < r) {
                    int mid = l + (r - l) / 2;
                    if (list.get(mid).tstamp == timestamp) {
                        return list.get(mid).val;
                    }
                    if (list.get(mid).tstamp < timestamp) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                if (list.get(r).tstamp <= timestamp) {
                    return list.get(r).val;
                } else if (list.get(l).tstamp <= timestamp) {
                    return list.get(l).val;
                }
            }
            return "";
        }
    }
}
