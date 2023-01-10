package editor.cn;

import java.util.Arrays;

/**
You are given an m x n binary matrix grid. An island is a group of 1's (
representing land) connected 4-directionally (horizontal or vertical.) You may assume 
all four edges of the grid are surrounded by water. 

 The area of an island is the number of cells with a value 1 in the island. 

 Return the maximum area of an island in grid. If there is no island, return 0. 


 
 Example 1: 

 
Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,
1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,
0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-
directionally.
 

 Example 2: 

 
Input: grid = [[0,0,0,0,0,0,0,0]]
Output: 0
 

 
 Constraints: 

 
 m == grid.length 
 n == grid[i].length 
 1 <= m, n <= 50 
 grid[i][j] is either 0 or 1. 
 
 Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 732 👎 0

*/
  
  public class MaxAreaOfIsland{
      public static void main(String[] args) {
           Solution solution = new MaxAreaOfIsland().new Solution();
          int[][] qu = new int[][]{
                  {0,0,1,0,0,0,0,1,0,0,0,0,0},
                  {0,0,0,0,0,0,0,1,1,1,0,0,0},
                  {0,1,1,0,1,0,0,0,0,0,0,0,0},
                  {0,1,0,0,1,1,0,0,1,0,1,0,0},
                  {0,1,0,0,1,1,0,0,1,1,1,0,0},
                  {0,0,0,0,0,0,0,0,0,0,1,0,0},
                  {0,0,0,0,0,0,0,1,1,1,0,0,0},
                  {0,0,0,0,0,0,0,1,1,0,0,0,0}};
          int rec  = solution.maxAreaOfIsland(qu);
          for (int[] c : qu) {
              System.out.println(Arrays.toString(c));
          }
          System.out.println("###" + rec +"###");
      }

      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int i = 0, j = 0, max = 0;
        for (; i < grid.length; i++) {
            for (; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(dfs(grid, i, j), max);
                }
            }
            j = 0;
        }
        return max;
    }
    public int dfs(int[][] search, int i, int j){
        if (i < 0 || i >= search.length || j < 0 || j >= search[0].length || search[i][j] == 0) {
            return 0;
        }
        search[i][j] = 0;
        int count = 1;
        count += dfs(search, i + 1, j);
        count += dfs(search, i - 1, j);
        count += dfs(search, i, j + 1);
        count += dfs(search, i, j - 1);
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }