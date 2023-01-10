package editor.cn;

/**
You are given an n x n grid where we place some 1 x 1 x 1 cubes that are axis-
aligned with the x, y, and z axes. 

 Each value v = grid[i][j] represents a tower of v cubes placed on top of the 
cell (i, j). 

 We view the projection of these cubes onto the xy, yz, and zx planes. 

 A projection is like a shadow, that maps our 3-dimensional figure to a 2-
dimensional plane. We are viewing the "shadow" when looking at the cubes from the top,
 the front, and the side. 

 Return the total area of all three projections. 

 
 Example 1: 

 
Input: grid = [[1,2],[3,4]]
Output: 17
Explanation: Here are the three projections ("shadows") of the shape made with 
each axis-aligned plane.
 

 Example 2: 

 
Input: grid = [[2]]
Output: 5
 

 Example 3: 

 
Input: grid = [[1,0],[0,2]]
Output: 8
 

 
 Constraints: 

 
 n == grid.length == grid[i].length 
 1 <= n <= 50 
 0 <= grid[i][j] <= 50 
 
 Related Topics 几何 数组 数学 矩阵 👍 93 👎 0

*/
  
  public class ProjectionAreaOf3dShapes{
      public static void main(String[] args) {
           Solution solution = new ProjectionAreaOf3dShapes().new Solution();
          System.out.println(solution.projectionArea(new int[][]{
                  {1, 0},
                  {0, 2}
          }));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int projectionArea(int[][] grid) {
        int floorNums = 0, leftNums = 0, frontNums = 0;
        int[] frontRec = new int[grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            int leftMax = 0;
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) floorNums++;
                leftMax = Math.max(leftMax, grid[i][j]);
                frontRec[j] = Math.max(frontRec[j], grid[i][j]);
            }
            leftNums += leftMax;
        }
        for (int i : frontRec) {
            frontNums += i;
        }
        return floorNums + leftNums + frontNums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }