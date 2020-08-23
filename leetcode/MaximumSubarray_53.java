/**
 *  https://leetcode.com/problems/maximum-subarray/
 */
// 나중에 다시 풀어보기..
class Solution {
    public int maxSubArray(int[] nums) {
        // 결과 = 이전값 + 현재값 < 현재값 
        int max = nums[0];
        int previousValue = nums[0];
        
        for (int i=1; i < nums.length; i++) {
            // -2 1 -3 4 -1 2 1 
            // -2 + 1 , 1   > -1 , 1 = max = 1, previousValue = -2
            // 1 + -3, -3   > -2 , -3 = max =1  previousValue = 1 
            // -2 + 4, 4    > 2 ,   4  = max = 4 previousValue = -2
            previousValue = Math.max(previousValue + nums[i], nums[i]);
            
            if (previousValue < max) {
                continue;
            } else {
                max = previousValue;
            }
            
            
        }

        return max;
    }
    
}
