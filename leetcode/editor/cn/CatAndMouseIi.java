package editor.cn;

import java.util.Arrays;

/**
A game is played by a cat and a mouse named Cat and Mouse. 

 The environment is represented by a grid of size rows x cols, where each 
element is a wall, floor, player (Cat, Mouse), or food. 

 
 Players are represented by the characters 'C'(Cat),'M'(Mouse). 
 Floors are represented by the character '.' and can be walked on. 
 Walls are represented by the character '#' and cannot be walked on. 
 Food is represented by the character 'F' and can be walked on. 
 There is only one of each character 'C', 'M', and 'F' in grid. 
 

 Mouse and Cat play according to the following rules: 

 
 Mouse moves first, then they take turns to move. 
 During each turn, Cat and Mouse can jump in one of the four directions (left, 
right, up, down). They cannot jump over the wall nor outside of the grid. 
 catJump, mouseJump are the maximum lengths Cat and Mouse can jump at a time, 
respectively. Cat and Mouse can jump less than the maximum length. 
 Staying in the same position is allowed. 
 Mouse can jump over Cat. 
 

 The game can end in 4 ways: 

 
 If Cat occupies the same position as Mouse, Cat wins. 
 If Cat reaches the food first, Cat wins. 
 If Mouse reaches the food first, Mouse wins. 
 If Mouse cannot get to the food within 1000 turns, Cat wins. 
 

 Given a rows x cols matrix grid and two integers catJump and mouseJump, return 
true if Mouse can win the game if both Cat and Mouse play optimally, otherwise 
return false. 

 
 Example 1: 

 
Input: grid = ["####F","#C...","M...."], catJump = 1, mouseJump = 2
Output: true
Explanation: Cat cannot catch Mouse on its turn nor can it get the food before 
Mouse.
 

 Example 2: 

 
Input: grid = ["M.C...F"], catJump = 1, mouseJump = 4
Output: true
 

 Example 3: 

 
Input: grid = ["M.C...F"], catJump = 1, mouseJump = 3
Output: false
 

 
 Constraints: 

 
 rows == grid.length 
 cols = grid[i].length 
 1 <= rows, cols <= 8 
 grid[i][j] consist only of characters 'C', 'M', 'F', '.', and '#'. 
 There is only one of each character 'C', 'M', and 'F' in grid. 
 1 <= catJump, mouseJump <= 8 
 
 Related Topics 广度优先搜索 图 记忆化搜索 数学 动态规划 博弈 👍 74 👎 0

*/
  
  public class CatAndMouseIi{
      public static void main(String[] args) {
           Solution solution = new CatAndMouseIi().new Solution();
          System.out.println(solution.canMouseWin(new String[]{"####F","#C...","M...."}, 1, 2));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
      class Solution {
          static int S = 8 * 8 * 8 * 8, K = 1000;
          static int[][] f = new int[S][K]; // mouse : 0 / cat : 1
          String[] g;
          int n, m, a, b, tx, ty;
          int[][] dirs = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
          // mouse : (x, y) / cat : (p, q)
          int dfs(int x, int y, int p, int q, int k) {
              int state = (x << 9) | (y << 6) | (p << 3) | q;
              if (k == K - 1) return f[state][k] = 1;
              if (x == p && y == q) return f[state][k] = 1;
              if (x == tx && y == ty) return f[state][k] = 0;
              if (p == tx && q == ty) return f[state][k] = 1;
              if (f[state][k] != -1) return f[state][k];
              if (k % 2 == 0) { // mouse
                  for (int[] di : dirs) {
                      for (int i = 0; i <= b; i++) {
                          int nx = x + di[0] * i, ny = y + di[1] * i;
                          if (nx < 0 || nx >= n || ny < 0 || ny >= m) break;
                          if (g[nx].charAt(ny) == '#') break;
                          if (dfs(nx, ny, p, q, k + 1) == 0) return f[state][k] = 0;
                      }
                  }
                  return f[state][k] = 1;
              } else { // cat
                  for (int[] di : dirs) {
                      for (int i = 0; i <= a; i++) {
                          int np = p + di[0] * i, nq = q + di[1] * i;
                          if (np < 0 || np >= n || nq < 0 || nq >= m) break;
                          if (g[np].charAt(nq) == '#') break;
                          if (dfs(x, y, np, nq, k + 1) == 1) return f[state][k] = 1;
                      }
                  }
                  return f[state][k] = 0;
              }
          }
          public boolean canMouseWin(String[] grid, int catJump, int mouseJump) {
              g = grid;
              n = g.length; m = g[0].length(); a = catJump; b = mouseJump;
              for (int i = 0; i < S; i++) Arrays.fill(f[i], -1);
              int x = 0, y = 0, p = 0, q = 0;
              for (int i = 0; i < n; i++) {
                  for (int j = 0; j < m; j++) {
                      if (g[i].charAt(j) == 'M') {
                          x = i; y = j;
                      } else if (g[i].charAt(j) == 'C') {
                          p = i; q = j;
                      } else if (g[i].charAt(j) == 'F') {
                          tx = i; ty = j;
                      }
                  }
              }
              return dfs(x, y, p, q, 0) == 0;
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }