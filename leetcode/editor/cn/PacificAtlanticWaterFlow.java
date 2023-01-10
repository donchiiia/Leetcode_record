package editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
There is an m x n rectangular island that borders both the Pacific Ocean and 
Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the 
Atlantic Ocean touches the island's right and bottom edges. 

 The island is partitioned into a grid of square cells. You are given an m x n 
integer matrix heights where heights[r][c] represents the height above sea level 
of the cell at coordinate (r, c). 

 The island receives a lot of rain, and the rain water can flow to neighboring 
cells directly north, south, east, and west if the neighboring cell's height is 
less than or equal to the current cell's height. Water can flow from any cell 
adjacent to an ocean into the ocean. 

 Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes 
that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic 
oceans. 

 
 Example 1: 

 
Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
 

 Example 2: 

 
Input: heights = [[2,1],[1,2]]
Output: [[0,0],[0,1],[1,0],[1,1]]
 

 
 Constraints: 

 
 m == heights.length 
 n == heights[r].length 
 1 <= m, n <= 200 
 0 <= heights[r][c] <= 10⁵ 
 
 Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 👍 431 👎 0

*/
  
  public class PacificAtlanticWaterFlow{
      public static void main(String[] args) {
           Solution solution = new PacificAtlanticWaterFlow().new Solution();
          System.out.println(solution.pacificAtlantic(new int[][]{
                  {2, 1},
                  {1, 2}
          }));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new LinkedList<>();
        int m = heights.length, n = heights[0].length;
        boolean[][] arriveP = new boolean[m][n], arriveA = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            canArrive(heights, i, 0, arriveP);
            canArrive(heights, i, n - 1, arriveA);
        }
        for (int j = 0; j < n; j++) {
            canArrive(heights, 0, j, arriveP);
            canArrive(heights, m - 1, j, arriveA);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arriveP[i][j] && arriveA[i][j]) {
                    ArrayList<Integer> resElem = new ArrayList<>(2);
                    resElem.add(i);
                    resElem.add(j);
                    res.add(resElem);
                }
            }
        }
        return res;
    }

    private void canArrive(int[][] heights, int i, int j, boolean[][] arriveJudge){
        if (arriveJudge[i][j]) return;
        arriveJudge[i][j] = true;

        for (int[] sub : dir) {
            int newi = i + sub[0], newj = j + sub[1];
            if (newi >= 0 && newi < heights.length && newj >= 0 && newj < heights[0].length && heights[newi][newj] >=
                    heights[i][j]) {
                canArrive(heights, newi, newj, arriveJudge);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }