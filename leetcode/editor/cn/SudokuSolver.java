package editor.cn;

/**
Write a program to solve a Sudoku puzzle by filling the empty cells. 

 A sudoku solution must satisfy all of the following rules: 

 
 Each of the digits 1-9 must occur exactly once in each row. 
 Each of the digits 1-9 must occur exactly once in each column. 
 Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes 
of the grid. 
 

 The '.' character indicates empty cells. 

 
 Example 1: 

 
Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",
".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",
".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".",
"6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],
[".",".",".",".","8",".",".","7","9"]]
Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4",
"8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"]
,["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9
","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4
","5","2","8","6","1","7","9"]]
Explanation: The input board is shown above and the only valid solution is 
shown below:


 

 
 Constraints: 

 
 board.length == 9 
 board[i].length == 9 
 board[i][j] is a digit or '.'. 
 It is guaranteed that the input board has only one solution. 
 
 Related Topics 数组 回溯 矩阵 👍 1163 👎 0

*/
  
  public class SudokuSolver{
      public static void main(String[] args) {
           Solution solution = new SudokuSolver().new Solution();
          char[][] board = new char[][]{
                  {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                  {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                  {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                  {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                  {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                  {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                  {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                  {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                  {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
          };
          solution.solveSudoku(board);
          for (int i = 0; i < 9; i++) {
              for (int j = 0; j < 9; j++) {
                  System.out.print("|" + board[i][j] + "");
              }
              System.out.println("");
          }
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void solveSudoku(char[][] board) {
        int row = board.length, column = board[0].length;
        //构建3个二维数组，分别代表每行，每列以及每个3x3的子块
        boolean[][] judgeRow = new boolean[row][column];
        boolean[][] judgeColumn = new boolean[row][column];
        boolean[][] judgeBlock = new boolean[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] != '.') {
                    //由于board中每个元素是char类型，为了与判别数组对应，使用临时变量记录下来
                    //对应位置的下标要减一，同时也要通过i和j算出其位于哪个子块
                    int temp = board[i][j] - '1', tag = i / 3 * 3 + j / 3;
                    judgeRow[i][temp] = judgeColumn[j][temp] = judgeBlock[tag][temp] = true;
                }
            }
        }
        //初始化判别数组之后就是使用dfs进行递归回溯
        dfs(board, judgeRow, judgeColumn, judgeBlock, 0, 0);
    }
    public boolean dfs(char[][] board, boolean[][] judgeRow, boolean[][] judgeColumn, boolean[][] judgeBlock, int i, int j){
        //由于是递归调用，首先应当做的是递归结束的条件
        //该题的目的是解决数独，也就是二维数组board[][]中没有'.'，所以应当判断有无'.'
        while (board[i][j] != '.') {
            if (++j >= 9) {
                i++;
                j = 0;
            }
            if (i >= 9) {
                //到这一步就意味着所有位置都检查完了且没有'.'，可以正常返回
                return true;
            }
        }
        //现在是找到了空的位置
        //准备遍历各个判别数组中对应位置是否都为空(这对应数独解法中判断该位置所在行，列和九宫格是否存在待填入的数字)，
        for (int num = 0; num < 9; num++) {
            //获取改位置对应子块号
            int tag = i / 3 * 3 + j / 3;
            //对应行、列和九宫格都没有对应数字，可以将其填入
            if (!judgeRow[i][num] && !judgeColumn[j][num] && !judgeBlock[tag][num]) {
                board[i][j] = (char) ('1' + num);
                judgeRow[i][num] = judgeColumn[j][num] = judgeBlock[tag][num] = true;
                //!!!关键递归！！！
                //在上面的代码预填入的数字并不一定是正确的，除非其能使得其余空格填满后以符合数独要求的规则，
                //也就是说将这个改变后的board数组作为输入数组，最终能得到正确结果，才能判断这一位填入的数字正确
                if (dfs(board, judgeRow, judgeColumn, judgeBlock, i, j) == true) {
                    return true;
                } else {
                    //返回false意味着上述填入的数字使得后续处理后出现了矛盾
                    //！！！需要回溯处理！！！
                    board[i][j] = '.';
                    judgeRow[i][num] = judgeColumn[j][num] = judgeBlock[tag][num] = false;
                    //之后返回外层for循环，使用另外的数字重新尝试
                }
            }
        }
        //将这一层所有的数字一一尝试(上面的for循环)都不能得出结果，意味着上层调用中填入了错误的数字
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }

  /*
  *     public void solveSudoku(char[][] board) {
        int row = board.length, column = board[0].length;
        boolean[][] judgeRow = new boolean[row][column];
        boolean[][] judgeColumn = new boolean[row][column];
        boolean[][] judgeMatrix = new boolean[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] != '.') {
                    int temp = board[i][j] - '1';
                    judgeRow[i][temp] = judgeColumn[j][temp] = true;
                    judgeMatrix[i / 3 * 3 + j / 3][temp] = true;
                }
            }
        }
        dfs(board, judgeRow, judgeColumn, judgeMatrix, 0, 0);
    }

    public boolean dfs(char[][] board, boolean[][] judgeRow, boolean[][] judgeColumn, boolean[][] judgeMatrix, int i,
                    int j) {
        //先寻找到空位置，如果都没找到意味着数独已经完成
        while (board[i][j] != '.') {
            if (++j >= 9) {
                i++;
                j = 0;
            }
            if (i >= 9) {
                return true;
            }
        }
        //将1-9通过循环代入该空位置
        for (int num = 0; num < 9; num++) {
            int matrixnum = i / 3 * 3 + j / 3;
            //如果条件暂时满足就将其加入该位置
            if (!judgeRow[i][num] && !judgeColumn[j][num] && !judgeMatrix[matrixnum][num]) {
                board[i][j] = (char) ('1' + num);
                judgeRow[i][num] = judgeColumn[j][num] = judgeMatrix[matrixnum][num] = true;
                //放入该位置后，假设该位置正确，递归调用该方法
                if (dfs(board, judgeRow, judgeColumn, judgeMatrix, i, j)) {
                    return true;
                } else {
                    //当递归调用发现不满足时就回溯原先的结果
                    board[i][j] = '.';
                    judgeRow[i][num] = judgeColumn[j][num] = judgeMatrix[matrixnum][num] = false;
                }
            }
        }
        //到这个位置就意味着使用所有1-9插入board[i][j]都没有正确返回，这说明上层插入的数值有问题，使用false向上层传递信息
        return false;
    }*/