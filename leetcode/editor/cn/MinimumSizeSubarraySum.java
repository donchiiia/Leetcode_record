package editor.cn;

/**
Given an array of positive integers nums and a positive integer target, return 
the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr]
 of which the sum is greater than or equal to target. If there is no such 
subarray, return 0 instead. 

 
 Example 1: 

 
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem 
constraint.
 

 Example 2: 

 
Input: target = 4, nums = [1,4,4]
Output: 1
 

 Example 3: 

 
Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
 

 
 Constraints: 

 
 1 <= target <= 10⁹ 
 1 <= nums.length <= 10⁵ 
 1 <= nums[i] <= 10⁵ 
 

 
Follow up: If you have figured out the O(n) solution, try coding another 
solution of which the time complexity is O(n log(n)). Related Topics 数组 二分查找 前缀和 滑动窗口 ?
? 1061 👎 0

*/
  
  public class MinimumSizeSubarraySum{
      public static void main(String[] args) {
           Solution solution = new MinimumSizeSubarraySum().new Solution();
          System.out.println(solution.minSubArrayLen(4, new int[]{1,4,4}));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE, sum = 0, left = 0, right = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                sum -= nums[left];
                min = Math.min(min, right - left + 1);
                left++;
            }
            right++;
        }
        if (min == Integer.MAX_VALUE) return 0;
        return min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }