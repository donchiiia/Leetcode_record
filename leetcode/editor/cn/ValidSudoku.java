package editor.cn;

/**
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be 
validated according to the following rules: 

 
 Each row must contain the digits 1-9 without repetition. 
 Each column must contain the digits 1-9 without repetition. 
 Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 
without repetition. 
 

 Note: 

 
 A Sudoku board (partially filled) could be valid but is not necessarily 
solvable. 
 Only the filled cells need to be validated according to the mentioned rules. 
 

 
 Example 1: 

 
Input: board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true
 

 Example 2: 

 
Input: board = 
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being 
modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is 
invalid.
 

 
 Constrachars: 

 
 board.length == 9 
 board[i].length == 9 
 board[i][j] is a digit 1-9 or '.'. 
 
 Related Topics 数组 哈希表 矩阵 👍 794 👎 0

*/
  
  public class ValidSudoku{
      public static void main(String[] args) {
           Solution solution = new ValidSudoku().new Solution();
          char[][] board = {{'5','3','.','.','7','.','.','.','.'} ,
          {'8','.','.','1','9','5','.','.','.'} ,
          {'.','9','8','.','.','.','.','6','.'} ,
          {'8','.','.','.','6','.','.','.','3'} ,
          {'4','.','.','8','.','3','.','.','1'} ,
          {'7','.','.','.','2','.','.','.','6'} ,
          {'.','6','.','.','.','.','2','8','.'} ,
          {'.','.','.','4','1','9','.','.','5'} ,
          {'.','.','.','.','8','.','.','7','9'}};
          char[][] board1={
          {'.','.','.','9','.','.','.','.','.'},
          {'.','.','.','.','.','.','.','.','.'},
          {'.','.','3','.','.','.','.','.','1'},
          {'.','.','.','.','.','.','.','.','.'},
          {'1','.','.','.','.','.','3','.','.'},
          {'.','.','.','.','2','.','6','.','.'},
          {'.','9','.','.','.','.','.','7','.'},
          {'.','.','.','.','.','.','.','.','.'},
          {'8','.','.','8','.','.','.','.','.'}};
          char[][] board2 ={
          {'.','.','4','.','.','.','6','3','.'},
          {'.','.','.','.','.','.','.','.','.'},
          {'5','.','.','.','.','.','.','9','.'},
          {'.','.','.','5','6','.','.','.','.'},
          {'4','.','3','.','.','.','.','.','1'},
          {'.','.','.','7','.','.','.','.','.'},
          {'.','.','.','5','.','.','.','.','.'},
          {'.','.','.','.','.','.','.','.','.'},
          {'.','.','.','.','.','.','.','.','.'}
          };
          char[][] board3 = {
          {'.','.','.','.','5','.','.','1','.'},
          {'.','4','.','3','.','.','.','.','.'},
          {'.','.','.','.','.','3','.','.','1'},
          {'8','.','.','.','.','.','.','2','.'},
          {'.','.','2','.','7','.','.','.','.'},
          {'.','1','5','.','.','.','.','.','.'},
          {'.','.','.','.','.','2','.','.','.'},
          {'.','2','.','9','.','.','.','.','.'},
          {'.','.','4','.','.','.','.','.','.'}
          };
          System.out.println(solution.isValidSudoku(board));
          System.out.println(solution.isValidSudoku(board1));
          System.out.println(solution.isValidSudoku(board2));
          System.out.println(solution.isValidSudoku(board3));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int column = board.length;
        int row = board[0].length;

        char[][] judgeRow = new char[column][row];
        char[][] judgeColumn = new char[column][row];
        char[][] judgeMatrix = new char[3][row];
        
//        HashMap<Integer, HashSet<Character>> judgeMatrix = new HashMap<>();
//        for (int i = 1; i < 4; i++) {
//            judgeMatrix.put(i, new HashSet<>());
//        }
        for (char i = 0; i < row; i++) {
            if (i % 3 == 0) {
                for (int k = 0; k < 3; k++) {
//                    judgeMatrix.get(k).clear();
                    judgeMatrix[k] = new char[row];
                }
            }
            for (char j = 0; j < column; j++) {
                int tag = j > 2 ? j > 5 ? 3 : 2 : 1;
                char rec = board[i][j];
                int temp = ((int) rec - (int)('0')) - 1;
                
                if (rec == '.' ) continue;
                if (judgeRow[i][temp] == rec
                        || judgeColumn[j][temp] == rec ||
//                        judgeMatrix.get(tag).contains(rec)
                        judgeMatrix[tag - 1][temp] == rec
                ) {
                    return false;
                } else {
                    judgeColumn[j][temp] = judgeRow[i][temp] = rec;
//                    judgeMatrix.get(tag).add(rec);
                    judgeMatrix[tag - 1][temp] = rec;
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }

/*
*         char column = board.length;
        char row = board[0].length;

        HashMap<chareger, HashSet<Character>> res = new HashMap<>();
        for (char i = 1; i <= 13; i++) {
            res.put(i, new HashSet<>());
        }
        for (char i = 0; i < column; i++) {
            if (i % 3 == 0) {
                res.get(11).clear();
                res.get(12).clear();
                res.get(13).clear();
            }
            for (char j = 0; j < row; j++) {
                char temp = board[i][j];
                char tag = j>2?j>5?3:2:1;
                if (temp != '.' && (res.get(1).contains(temp) || res.get(10 + tag).contains(temp) ||
                        res.get(j + 2).contains(temp))) {
                    return false;
                } else {
                    res.get(1).add(temp);
                    res.get(j + 2).add(temp);
                    res.get(10 + tag).add(temp);
                }
            }
            res.get(1).clear();
        }
        return true;
    */