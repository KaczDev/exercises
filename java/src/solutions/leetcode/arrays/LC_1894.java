package solutions.leetcode.arrays;

import solutions.Solution;

public class LC_1894 implements Solution {

    @Override
    public void solve() {
        int[] nums = {5,1,5};
        int k =22;
        System.out.println("Solution: "+this.chalkReplacerSlower(nums,k));
        System.out.println("Solution: "+this.chalkReplacerFaster(nums,k));
        nums = new int[]{3,4,1,2};
        k=25;
        System.out.println("Solution: "+this.chalkReplacerSlower(nums,k));
        System.out.println("Solution: "+this.chalkReplacerFaster(nums,k));
    }

        private int chalkReplacerFaster(int[] chalk, int initialChalkPieces) {
            long totalChalkNeeded = 0;
            for (int studentChalkUse : chalk) {
                totalChalkNeeded += studentChalkUse;
            }

            int remainingChalk = (int)(initialChalkPieces % totalChalkNeeded);

            for (int studentIndex = 0; studentIndex < chalk.length; studentIndex++) {
                if (remainingChalk < chalk[studentIndex]) {
                    return studentIndex;
                }
                remainingChalk -= chalk[studentIndex];
            }

            return 0;
        }
        private int chalkReplacerSlower(int[] chalk, int k) {
            int i =0;
            while (k>=0){
                if (i==chalk.length){
                    i=0;
                }
                k-=chalk[i];
                i+=1;
            }
            return i-1;
    }


}
