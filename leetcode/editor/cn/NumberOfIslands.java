package editor.cn;

/**
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0
's (water), return the number of islands. 

 An island is surrounded by water and is formed by connecting adjacent lands 
horizontally or vertically. You may assume all four edges of the grid are all 
surrounded by water. 

 
 Example 1: 

 
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
 

 Example 2: 

 
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 

 
 Constraints: 

 
 m == grid.length 
 n == grid[i].length 
 1 <= m, n <= 300 
 grid[i][j] is '0' or '1'. 
 
 Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 1646 👎 0

*/
  
  public class NumberOfIslands{
      public static void main(String[] args) {
           Solution solution = new NumberOfIslands().new Solution();
          System.out.println(solution.numIslands(new char[][]{
          {'1','1','1','1','0'}, 
          {'1','1','0','1','0'},
          {'1','1','0','0','0'}, 
          {'0','0','0','0','0'}
          }));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    infection(grid, i, j);
                }
            }
        }
        return count;
    }
    private void infection(char[][] grid, int i, int j){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length
            || grid[i][j] != '1') return;
        grid[i][j] = '2';
        infection(grid, i, j - 1);
        infection(grid, i, j + 1);
        infection(grid, i - 1, j);
        infection(grid, i + 1, j);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }