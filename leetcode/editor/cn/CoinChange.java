import java.lang.reflect.Array;
import java.rmi.ConnectIOException;
import java.util.Arrays;

/**
You are given an integer array coins representing coins of different 
denominations and an integer amount representing a total amount of money. 

 Return the fewest number of coins that you need to make up that amount. If 
that amount of money cannot be made up by any combination of the coins, return -1. 

 You may assume that you have an infinite number of each kind of coin. 

 
 Example 1: 

 
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
 

 Example 2: 

 
Input: coins = [2], amount = 3
Output: -1
 

 Example 3: 

 
Input: coins = [1], amount = 0
Output: 0
 

 
 Constraints: 

 
 1 <= coins.length <= 12 
 1 <= coins[i] <= 2³¹ - 1 
 0 <= amount <= 10⁴ 
 
 Related Topics 广度优先搜索 数组 动态规划 👍 1889 👎 0

*/
  
  public class CoinChange{
      public static void main(String[] args) {
           Solution solution = new CoinChange().new Solution();
          System.out.println(solution.coinChange(new int[]{1,2,5}, 11));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.sort(coins);
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        //每个硬币可以选择无数次
        for (int i = 0; i < coins.length; i++) {
            //这是背包循环，j为背包容量，如果背包容量小于硬币面值就结束循环
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

/*    private int dfs(int[] coins, int start, int amount, int min, int temp) {
        if (amount <= 0) return temp;

        for (int i = start; i < coins.length; i++) {
            amount -= coins[i];
            if (amount < 0) break;
            temp++;
            min = dfs(coins, i, amount, min, temp);
            if (amount == 0) {
                if (min < 0) min = temp;
                else min = Math.min(min, temp);
            }
            temp--;
            amount += coins[i];
        }
        return min;
    }*/
      }
//leetcode submit region end(Prohibit modification and deletion)

  }