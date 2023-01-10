package editor.cn;

import java.util.Arrays;

/**
Given an integer array nums of length n and an integer target, find three 
integers in nums such that the sum is closest to target. 

 Return the sum of the three integers. 

 You may assume that each input would have exactly one solution. 

 
 Example 1: 

 
Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 

 Example 2: 

 
Input: nums = [0,0,0], target = 1
Output: 0
 

 
 Constraints: 

 
 3 <= nums.length <= 1000 
 -1000 <= nums[i] <= 1000 
 -10⁴ <= target <= 10⁴ 
 
 Related Topics 数组 双指针 排序 👍 1068 👎 0

*/
  
  public class ThreeSumClosest{
      public static void main(String[] args) {
           Solution solution = new ThreeSumClosest().new Solution();
           int[] nums = new int[]{-1, 2, 1, -4};
           int target = 1;
          System.out.println(solution.threeSumClosest(nums, target));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int closest = 10000;

        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;

            int L = i + 1, R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }
                if (sum < target) {
                    int L0 = L + 1;
                    while (L0 < R && nums[L0] == nums[L]) {
                        L0++;
                    }
                    L = L0;
                } else {
                    int R0 = R - 1;
                    while (L < R0 && nums[R0] == nums[R]) {
                        R0--;
                    }
                    R = R0;
                }
            }
        }
        return closest;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }