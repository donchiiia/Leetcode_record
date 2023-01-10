package editor.cn;

import java.util.LinkedList;
import java.util.Queue;

/**
Given an n x n binary matrix grid, return the length of the shortest clear path 
in the matrix. If there is no clear path, return -1. 

 A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0))
 to the bottom-right cell (i.e., (n - 1, n - 1)) such that: 

 
 All the visited cells of the path are 0. 
 All the adjacent cells of the path are 8-directionally connected (i.e., they 
are different and they share an edge or a corner). 
 

 The length of a clear path is the number of visited cells of this path. 

 
 Example 1: 

 
Input: grid = [[0,1],[1,0]]
Output: 2
 

 Example 2: 

 
Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
Output: 4
 

 Example 3: 

 
Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
Output: -1
 

 
 Constraints: 

 
 n == grid.length 
 n == grid[i].length 
 1 <= n <= 100 
 grid[i][j] is 0 or 1 
 
 Related Topics 广度优先搜索 数组 矩阵 👍 181 👎 0

*/
  
  public class ShortestPathInBinaryMatrix{
      public static void main(String[] args) {
           Solution solution = new ShortestPathInBinaryMatrix().new Solution();
          System.out.println(solution.shortestPathBinaryMatrix(new int[][]{
//                  {0,0,0},
//                  {1,0,0},
//                  {1,1,0}
//
          {0,1,1,0,0,0},
          {0,1,0,1,1,0},
          {0,1,1,0,1,0},
          {0,0,0,1,1,0},
          {1,1,1,1,1,0},
          {1,1,1,1,1,0}
          }));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          public int shortestPathBinaryMatrix(int[][] grid) {
              if (grid[0][0] == 1) return -1;

              int[][] direction = {{1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}};
              int m = grid.length, n = grid[0].length, pathLength = 0;
              Queue<int[]> integers = new LinkedList<>();

              integers.add(new int[]{0, 0});
              grid[0][0] = 1;
              pathLength = 1;
              while (!integers.isEmpty()) {
                  int size = integers.size();
                  while (size-- > 0) {
                      int[] tmp = integers.poll();
                      int x = tmp[0], y = tmp[1];
                      if (x == m - 1 && y == n - 1) return pathLength;

                      for (int[] ints : direction) {
                          int x1 = x + ints[0], y1 = y + ints[1];
                          if (x1 < 0 || x1 >= m || y1 < 0 || y1 >= n || grid[x1][y1] == 1) continue;
                          integers.add(new int[]{x1, y1});
                          grid[x1][y1] = 1;
                      }
                      pathLength++;
                  }
              }
              return -1;
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }