package editor.cn;

/**
Given an integer n, break it into the sum of k positive integers, where k >= 2, 
and maximize the product of those integers. 

 Return the maximum product you can get. 

 
 Example 1: 

 
Input: n = 2
Output: 1
Explanation: 2 = 1 + 1, 1 × 1 = 1.
 

 Example 2: 

 
Input: n = 10
Output: 36
Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 

 
 Constraints: 

 
 2 <= n <= 58 
 
 Related Topics 数学 动态规划 👍 795 👎 0

*/
  
  public class IntegerBreak{
      public static void main(String[] args) {
           Solution solution = new IntegerBreak().new Solution();
          System.out.println(solution.integerBreak(2));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i - 1; j++) {
                dp[i] = Math.max(dp[i], j * Math.max((i - j), dp[i - j]));
            }
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
  /*
  *         int[] dp = new int[n + 1];
        dp[0] = dp[1] = 0;
        dp[2] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(j * (i - j), Math.max(j * dp[i - j], dp[i]));
            }
        }
        return dp[n];*/