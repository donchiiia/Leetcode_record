package editor.cn;

/**
There is a robot on an m x n grid. The robot is initially located at the top-
left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner 
(i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any 
point in time. 

 Given the two integers m and n, return the number of possible unique paths 
that the robot can take to reach the bottom-right corner. 

 The test cases are generated so that the answer will be less than or equal to 2
 * 10⁹. 

 
 Example 1: 

 
Input: m = 3, n = 7
Output: 28
 

 Example 2: 

 
Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the 
bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
 

 
 Constraints: 

 
 1 <= m, n <= 100 
 
 Related Topics 数学 动态规划 组合数学 👍 1369 👎 0

*/
  
  public class UniquePaths{
      public static void main(String[] args) {
           Solution solution = new UniquePaths().new Solution();
          System.out.println(solution.uniquePaths(3, 2));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] recArray = new int[m][n];
        for (int i = 0; i < m; i++) {
            recArray[i][0] = 1;
        }
        for (int k = 0; k < n; k++) {
            recArray[0][k] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                recArray[i][j] = recArray[i][j - 1] + recArray[i - 1][j];
            }
        }
        return recArray[m - 1][n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }