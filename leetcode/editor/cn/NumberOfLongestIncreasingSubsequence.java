package editor.cn;

/**
Given an integer array nums, return the number of longest increasing 
subsequences. 

 Notice that the sequence has to be strictly increasing. 

 
 Example 1: 

 
Input: nums = [1,3,5,4,7]
Output: 2
Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3,
 5, 7].
 

 Example 2: 

 
Input: nums = [2,2,2,2,2]
Output: 5
Explanation: The length of longest continuous increasing subsequence is 1, and 
there are 5 subsequences' length is 1, so output 5.

 

 
 Constraints: 

 
 1 <= nums.length <= 2000 
 -10⁶ <= nums[i] <= 10⁶ 
 
 Related Topics 树状数组 线段树 数组 动态规划 👍 590 👎 0

*/
  
  public class NumberOfLongestIncreasingSubsequence{
      public static void main(String[] args) {
           Solution solution = new NumberOfLongestIncreasingSubsequence().new Solution();
          System.out.println(solution.findNumberOfLIS(new int[]{1}));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = count[i] = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (max < dp[i]) max = dp[i];
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] == max) sum += count[i];
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }