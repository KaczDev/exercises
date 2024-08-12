package solutions.neetcode.roadmap.binarysearch;

import solutions.Solution;

public class LC_4 implements Solution {
    @Override
    public void solve() {
        int[] nums11 = {1, 3};
        int[] nums12 = {2};
        int[] nums21 = {1, 2};
        int[] nums22 = {3, 4};
        System.out.println("Solution: " + this.findMedianSortedArrays(nums11,nums12));
        System.out.println("Solution: " + this.findMedianSortedArrays(nums21, nums22));
    }

    // Time: O( log(min(n,m)) )
    private double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1, B = nums2;
        int total = A.length + B.length;
        int half = total / 2;

        if (B.length < A.length) {
            int[] tmp = A;
            A = B;
            B = tmp;
        }
        //A is shorter
        //B is longer
        int l = 0, r = A.length - 1;
        while (true) {
            int i = (l + r) / 2; //middle val of Array A
            int j = half - i - 2; //partition index of Array B

            //Any of those could be out of bounds that's why we have if statements
            int Aleft = i >= 0 ? A[i] : Integer.MIN_VALUE;
            int Aright = (i + 1) < A.length ? A[i + 1] : Integer.MAX_VALUE;
            int Bleft = j >= 0 ? B[j] : Integer.MIN_VALUE;
            int Bright = (j + 1) < B.length ? B[j + 1] : Integer.MAX_VALUE;

            //partition is correct
            if (Aleft <= Bright && Bleft <= Aright) {
                //odd
                if (total % 2 != 0) {
                    return Math.min(Aright, Bright);
                }
                //even
                return (float) (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2;
            } else if (Aleft > Bright) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }
    }
}
