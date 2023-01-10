package editor.cn;

/**
Write an efficient algorithm that searches for a value target in an m x n 
integer matrix matrix. This matrix has the following properties: 

 
 Integers in each row are sorted from left to right. 
 The first integer of each row is greater than the last integer of the previous 
row. 
 

 
 Example 1: 

 
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
 

 Example 2: 

 
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
 

 
 Constraints: 

 
 m == matrix.length 
 n == matrix[i].length 
 1 <= m, n <= 100 
 -10⁴ <= matrix[i][j], target <= 10⁴ 
 
 Related Topics 数组 二分查找 矩阵 👍 611 👎 0

*/
  
  public class SearchA2dMatrix{
      public static void main(String[] args) {
           Solution solution = new SearchA2dMatrix().new Solution();
          System.out.println(solution.searchMatrix(new int[][]{
                  {1}/*,{3}*//*{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}*/}, 1));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0, rowEnd = matrix.length - 1, column = 0, columnEnd = matrix[row].length - 1;
        while (row < rowEnd) {
            int rowMid = row + (rowEnd - row >> 1);
            if (matrix[rowMid][columnEnd] == target) return true;
            else if (matrix[rowMid][columnEnd] > target) rowEnd = rowMid;
            else row = rowMid + 1;
        }
        while (column <= columnEnd) {
            int columnMid = column + (columnEnd - column >> 1);
            if (matrix[row][columnMid] == target) return true;
            else if (matrix[row][columnMid] > target) columnEnd = columnMid - 1;
            else column = columnMid + 1;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }