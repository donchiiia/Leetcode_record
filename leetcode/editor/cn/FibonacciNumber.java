package editor.cn;

import org.junit.Test;

/**
The Fibonacci numbers, commonly denoted F(n) form a sequence, called the 
Fibonacci sequence, such that each number is the sum of the two preceding ones, 
starting from 0 and 1. That is, 

 
F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.
 

 Given n, calculate F(n). 

 
 Example 1: 

 
Input: n = 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 

 Example 2: 

 
Input: n = 3
Output: 2
Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 

 Example 3: 

 
Input: n = 4
Output: 3
Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 

 
 Constraints: 

 
 0 <= n <= 30 
 
 Related Topics 递归 记忆化搜索 数学 动态规划 👍 464 👎 0

*/

public class FibonacciNumber{
    @Test
    public static void main(String[] args) {
        Solution solution = new FibonacciNumber().new Solution();
        System.out.println(solution.fib(4));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int fib(int n) {
        if (n <= 1) return n;
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int sum = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = sum;
        }
        return dp[1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }