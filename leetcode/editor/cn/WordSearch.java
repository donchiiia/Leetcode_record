import java.util.WeakHashMap;

/**
Given an m x n grid of characters board and a string word, return true if word 
exists in the grid. 

 The word can be constructed from letters of sequentially adjacent cells, where 
adjacent cells are horizontally or vertically neighboring. The same letter cell 
may not be used more than once. 

 
 Example 1: 

 
Input: board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word = 
'ABCCED'
Output: true
 

 Example 2: 

 
Input: board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word = 
'SEE'
Output: true
 

 Example 3: 

 
Input: board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word = 
'ABCB'
Output: false
 

 
 Constraints: 

 
 m == board.length 
 n = board[i].length 
 1 <= m, n <= 6 
 1 <= word.length <= 15 
 board and word consists of only lowercase and uppercase English letters. 
 

 
 Follow up: Could you use search pruning to make your solution faster with a 
larger board? 
 Related Topics 数组 回溯 矩阵 👍 1256 👎 0

*/
  
  public class WordSearch{
      public static void main(String[] args) {
           Solution solution = new WordSearch().new Solution();
           char[][] board = {
                   {'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}
           };
          String word = "SEK";
          System.out.println(solution.exist(board, word));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (search(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

          private boolean search(char[][] board, String word, int i, int j, int index) {
              if (index >= word.length()) return true;
              if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
                  return false;
              }
              char temp = board[i][j];
              board[i][j] = '#';
              boolean res = search(board, word, i - 1, j, index + 1) || search(board, word, i + 1, j, index + 1) ||
                      search(board, word, i, j + 1, index + 1) || search(board, word, i, j - 1, index + 1);
              board[i][j] = temp;
              return res;
          }

      }
//leetcode submit region end(Prohibit modification and deletion)

  }