package editor.cn;

/**
You are given an integer array nums. You want to maximize the number of points 
you get by performing the following operation any number of times: 

 
 Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must 
delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1. 
 

 Return the maximum number of points you can earn by applying the above 
operation some number of times. 

 
 Example 1: 

 
Input: nums = [3,4,2]
Output: 6
Explanation: You can perform the following operations:
- Delete 4 to earn 4 points. Consequently, 3 is also deleted. nums = [2].
- Delete 2 to earn 2 points. nums = [].
You earn a total of 6 points.
 

 Example 2: 

 
Input: nums = [2,2,3,3,3,4]
Output: 9
Explanation: You can perform the following operations:
- Delete a 3 to earn 3 points. All 2's and 4's are also deleted. nums = [3,3].
- Delete a 3 again to earn 3 points. nums = [3].
- Delete a 3 once more to earn 3 points. nums = [].
You earn a total of 9 points. 

 
 Constraints: 

 
 1 <= nums.length <= 2 * 10⁴ 
 1 <= nums[i] <= 10⁴ 
 
 Related Topics 数组 哈希表 动态规划 👍 630 👎 0

*/

public class DeleteAndEarn{
    public static void main(String[] args) {
        Solution solution = new DeleteAndEarn().new Solution();
        System.out.println(solution.deleteAndEarn(new int[]{2,2,3,3,3,4}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] rec = new int[10001];
        for (int num : nums) {
            rec[num] += num;
        }
        int[] dp = new int[3];
        dp[0] = 0;
        dp[1] = rec[1];
        dp[2] = dp[0] + rec[2];
        for (int i = 3; i < rec.length; i++){
            int m = Math.max(dp[0], dp[1]) + rec[i];
            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = m;
        }
        return Math.max(dp[1], dp[2]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }