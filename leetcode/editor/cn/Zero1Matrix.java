package editor.cn;

import java.util.Arrays;

/**
Given an m x n binary matrix mat, return the distance of the nearest 0 for each 
cell. 

 The distance between two adjacent cells is 1. 

 
 Example 1: 

 
Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]
 

 Example 2: 

 
Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]
 

 
 Constraints: 

 
 m == mat.length 
 n == mat[i].length 
 1 <= m, n <= 10⁴ 
 1 <= m * n <= 10⁴ 
 mat[i][j] is either 0 or 1. 
 There is at least one 0 in mat. 
 
 Related Topics 广度优先搜索 数组 动态规划 矩阵 👍 643 👎 0

*/
  
  public class Zero1Matrix{
      public static void main(String[] args) {
           Solution solution = new Zero1Matrix().new Solution();
          int[][] test = new int[][]{
                  {0, 0, 1, 0, 1, 1, 1, 0, 1, 1},
                  {1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                  {1, 1, 1, 1, 1, 0, 0, 0, 1, 1},
                  {1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
                  {0, 0, 1, 1, 1, 0, 1, 1, 1, 1},
                  {1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                  {1, 1, 1, 1, 0, 1, 0, 1, 0, 1},
                  {0, 1, 0, 0, 0, 1, 0, 0, 1, 1},
                  {1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
                  {1, 0, 1, 1, 1, 0, 1, 1, 1, 0}

          };
          int[][] res = solution.updateMatrix(test/*new int[][]{
                  {0,0,0},{0,1,0},{0,0,0}*//*{0, 0, 0}, {0, 1, 0}, {1, 1, 1}*//*}*/);
          for (int k = 0; k < test.length; k++) {
              System.out.println(Arrays.toString(test[k]) + "            " +Arrays.toString(res[k]));
          }
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[m - 1].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    res[i][j] = m + n;
                }
                if (i > 0) res[i][j] = Math.min(res[i][j], 1 + res[i - 1][j]);
                if (j > 0) res[i][j] = Math.min(res[i][j], 1 + res[i][j - 1]);
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i < m - 1) res[i][j] = Math.min(res[i][j], 1 + res[i + 1][j]);
                if (j < n - 1) res[i][j] = Math.min(res[i][j], 1 + res[i][j + 1]);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }