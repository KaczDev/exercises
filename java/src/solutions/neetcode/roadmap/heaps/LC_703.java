package solutions.neetcode.roadmap.heaps;

import solutions.Solution;

import java.util.PriorityQueue;

//https://leetcode.com/problems/kth-largest-element-in-a-stream/description/?envType=daily-question&envId=2024-08-12
public class LC_703 implements Solution {
    @Override
    public void solve() {
        KthLargest kth = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kth.add(3));
        System.out.println(kth.add(5));
        System.out.println(kth.add(10));
        System.out.println(kth.add(9));
        System.out.println(kth.add(4));
    }

    class KthLargest {
        private final PriorityQueue<Integer> pq;
        private final int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            this.pq = new PriorityQueue<>();
            for (int num : nums) {
                this.pq.add(num);
            }
            this.clearElements();
        }

        public int add(int val) {
            this.pq.add(val);
            this.clearElements();
            return this.pq.peek();
        }

        private void clearElements() {
            while (this.pq.size() > this.k) {
                this.pq.remove();
            }
        }
    }
}
