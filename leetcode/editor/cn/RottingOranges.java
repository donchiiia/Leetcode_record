import java.util.LinkedList;
import java.util.Queue;
import java.util.jar.JarEntry;

/**
You are given an m x n grid where each cell can have one of three values: 

 
 0 representing an empty cell, 
 1 representing a fresh orange, or 
 2 representing a rotten orange. 
 

 Every minute, any fresh orange that is 4-directionally adjacent to a rotten 
orange becomes rotten. 

 Return the minimum number of minutes that must elapse until no cell has a 
fresh orange. If this is impossible, return -1. 

 
 Example 1: 

 
Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
 

 Example 2: 

 
Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never 
rotten, because rotting only happens 4-directionally.
 

 Example 3: 

 
Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer 
is just 0.
 

 
 Constraints: 

 
 m == grid.length 
 n == grid[i].length 
 1 <= m, n <= 10 
 grid[i][j] is 0, 1, or 2. 
 
 Related Topics 广度优先搜索 数组 矩阵 👍 528 👎 0

*/
  
  public class RottingOranges{
      public static void main(String[] args) {
           Solution solution = new RottingOranges().new Solution();
          System.out.println(solution.orangesRotting(new int[][]{{2,0,1,1,1,1,1,1,1,1},
          {1,0,1,0,0,0,0,0,0,1},{1,0,1,0,1,1,1,1,0,1},{1,0,1,0,1,0,0,1,0,1},{1,0,1,0,1,0,0,1,0,1},
          {1,0,1,0,1,1,0,1,0,1},{1,0,1,0,0,0,0,1,0,1},{1,0,1,1,1,1,1,1,0,1},{1,0,0,0,0,0,0,0,0,1},{1,1,1,1,1,1,1,1,1,1}}));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int orangesRotting(int[][] grid) {
        int time = 0, nice = 0, row = grid.length, column = grid[row - 1].length, layer = 0;
        Queue<int[]> res = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 1) nice++;
                else if (grid[i][j] == 2) res.add(new int[]{i, j});
            }
        }
        while (nice > 0 && !res.isEmpty()) {
            time++;
            int n = res.size();
            for (int i = 0; i < n; i++) {
                int[] orange = res.poll();
                int rei = orange[0], rej = orange[1];

                if (rei - 1 >= 0 && grid[rei - 1][rej] == 1) {
                    nice--;
                    grid[rei - 1][rej] = 2;
                    res.add(new int[]{rei - 1, rej});
                }
                if (rei + 1 < row && grid[rei + 1][rej] == 1) {
                    nice--;
                    grid[rei + 1][rej] = 2;
                    res.add(new int[]{rei + 1, rej});
                }
                if (rej - 1 >= 0 && grid[rei][rej - 1] == 1) {
                    nice--;
                    grid[rei][rej - 1] = 2;
                    res.add(new int[]{rei, rej - 1});
                }
                if (rej + 1 < column && grid[rei][rej + 1] == 1) {
                    nice--;
                    grid[rei][rej + 1] = 2;
                    res.add(new int[]{rei, rej + 1});
                }
            }
        }
        if (nice > 0) return -1;
        return time;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }