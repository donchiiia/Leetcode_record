import java.util.Arrays;

/**
Given an m x n matrix board containing 'X' and 'O', capture all regions that 
are 4-directionally surrounded by 'X'. 

 A region is captured by flipping all 'O's into 'X's in that surrounded region. 


 
 Example 1: 

 
Input: board = [['X','X','X','X'],['X','O','O','X'],['X','X','O','X'],['X','O',
'X','X']]
Output: [['X','X','X','X'],['X','X','X','X'],['X','X','X','X'],['X','O','X','X']
]
Explanation: Surrounded regions should not be on the border, which means that 
any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on 
the border and it is not connected to an 'O' on the border will be flipped to 
'X'. Two cells are connected if they are adjacent cells connected horizontally or 
vertically.
 

 Example 2: 

 
Input: board = [['X']]
Output: [['X']]
 

 
 Constraints: 

 
 m == board.length 
 n == board[i].length 
 1 <= m, n <= 200 
 board[i][j] is 'X' or 'O'. 
 
 Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 769 👎 0

*/
  
  public class SurroundedRegions{
      public static void main(String[] args) {
           Solution solution = new SurroundedRegions().new Solution();
          char[][] chars = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
          solution.solve(chars);
          for (char[] aChar : chars) {
              System.out.println(Arrays.toString(aChar));
          }
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < n; i++) {
            dfs(board, 0, i);
            dfs(board, m - 1, i);
        }
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }
        for (int j = 0; j < m; j++) {
            for (int k = 0; k < n; k++) {
                if (board[j][k] == 'O') board[j][k] = 'X';
                else if (board[j][k] == '#') board[j][k] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i >= 0 && i < board.length && j >= 0 && j < board[i].length &&
        board[i][j] == 'O') {
            board[i][j] = '#';
            dfs(board, i + 1, j);
            dfs(board, i - 1, j);
            dfs(board, i, j + 1);
            dfs(board, i, j - 1);
        }
    }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }