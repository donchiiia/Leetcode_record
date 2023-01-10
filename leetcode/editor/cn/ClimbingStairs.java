package editor.cn;

/**
You are climbing a staircase. It takes n steps to reach the top. 

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you 
climb to the top? 

 
 Example 1: 

 
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
 

 Example 2: 

 
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 

 
 Constraints: 

 
 1 <= n <= 45 
 
 Related Topics 记忆化搜索 数学 动态规划 👍 2315 👎 0

*/
  
  public class ClimbingStairs{
      public static void main(String[] args) {
           Solution solution = new ClimbingStairs().new Solution();
          System.out.println(solution.climbStairs(45));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] rem = null;
    public int climbStairs(int n) {
        rem = new int[n];
        rec(n);
        return rem[n - 1];
    }
    void rec(int n){
        if (n >= 1) rem[0] = 1;
        if (n >= 2) rem[1] = 2;
        for (int i = 2; i < n; i++) {
            rem[i] = rem[i - 1] + rem[i - 2];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }