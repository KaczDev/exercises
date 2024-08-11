package solutions.leetcode.twopointers;

import solutions.Solution;

public class LC_42 implements Solution {
    @Override
    public void solve() {
        int[] height1 = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] height2 = new int[]{4, 2, 0, 3, 2, 5};
        System.out.println("Solution: " + this.trap(height1));
        System.out.println("Solution: " + this.trap(height2));
    }

    //Time: O(n)
    //Space: O(1)
    private int trap(int[] height) {
        if (height.length == 0) return 0;
        int res = 0;
        int l = 0, r = height.length - 1;
        int maxL = height[l], maxR = height[r];
        while (l < r) {
            if (maxL < maxR) {
                l += 1;
                maxL = Math.max(maxL, height[l]);
                res += Math.max(maxL - height[l], 0); // Just in case we meet negative number, shouldn't
            } else {
                r -= 1;
                maxR = Math.max(maxR, height[r]);
                res += Math.max(maxR - height[r], 0); // Just in case we meet negative number, shouldn't
            }
        }

        return res;
    }


    // My try (I had issues with second block when height[l]>height[r]
    //We then put R = L+1 and we calculate the height of each met block.
//    private int trap(int[] height) {
//        int res = 0;
//        //I think that we should start L=0, R=1;
//        int l = 0, r = 1;
//        while (l < height.length && r < height.length) {
//            //Then we move L until it meets a block.
//            while (height[l] == 0) {
//                l++;
//            }
//            //L hits the block
//            //We then put R = L+1 and until it meets an higher or equal block to nums[L].
//            r = l + 1;
//            System.out.printf("l: %d, r: %d%n", l, r);
//            while (height[r] <= height[l] && r < height.length - 2 && height[r] < height[r + 1]) {
//                r++;
//            }
//            //Then we move L until it reaches R and we remember the height of L.
//            // We then calculate how much water is in each block.
//            int leftHeight = height[l];
//            int rightHeight = height[r];
//            int maxDepth = Math.min(leftHeight, rightHeight);
//            System.out.printf("lH: %d(i:%d) rH: %d(i:%d) maxD: %d%n", leftHeight, l, rightHeight, r, maxDepth);
//            while (l < r) {
//                if (leftHeight > height[l] && height[l] <= rightHeight) {
//                    leftHeight = height[l];
//                }
//                System.out.printf("Depth of block %d(i:%d): %d%n", height[l], l, maxDepth - height[l]);
//                if (maxDepth - height[l] > 0) {
//                    res += maxDepth - height[l];
//                }
//            }
//            System.out.println("Res: " + res);
//            l = r;
//            r = l + 1;
//            //If nums[R] > nums[L] we move L to R and we continue
//
//        }
//
//        return res;
//    }
}
