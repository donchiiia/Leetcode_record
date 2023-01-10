package editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
Given a triangle array, return the minimum path sum from top to bottom. 

 For each step, you may move to an adjacent number of the row below. More 
formally, if you are on index i on the current row, you may move to either index i or 
index i + 1 on the next row. 

 
 Example 1: 

 
Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above)
.
 

 Example 2: 

 
Input: triangle = [[-10]]
Output: -10
 

 
 Constraints: 

 
 1 <= triangle.length <= 200 
 triangle[0].length == 1 
 triangle[i].length == triangle[i - 1].length + 1 
 -10⁴ <= triangle[i][j] <= 10⁴ 
 

 
Follow up: Could you do this using only O(n) extra space, where n is the total 
number of rows in the triangle? Related Topics 数组 动态规划 👍 998 👎 0

*/
  
  public class Triangle{
      public static void main(String[] args) {
           Solution solution = new Triangle().new Solution();
          ArrayList<List<Integer>> res = new ArrayList<>();
          ArrayList<List<Integer>> res1 = new ArrayList<>();
          res.add(new ArrayList<>(){{add(2);}});
          res.add(new ArrayList<>(){{add(3);add(4);}});
          res.add(new ArrayList<>(){{add(6);add(5);add(7);}});
          res.add(new ArrayList<>(){{add(4);add(1);add(8);add(3);}});
          res1.add(new ArrayList<>(){{
              add(-10);}});
          System.out.println(solution.minimumTotal(res));
          System.out.println(solution.minimumTotal(res1));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          public int minimumTotal(List<List<Integer>> triangle) {
              if (triangle == null || triangle.size() == 0){
                  return 0;
              }
              // 加1可以不用初始化最后一层
              int[][] dp = new int[triangle.size()+1][triangle.size()+1];

              for (int i = triangle.size()-1; i>=0; i--){
                  List<Integer> curTr = triangle.get(i);
                  for(int j = 0 ; j< curTr.size(); j++){
                      dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + curTr.get(j);
                  }
              }
              return dp[0][0];
          }
/*    int[] rem = null;
    public int minimumTotal(List<List<Integer>> triangle) {
        rem = new int[triangle.size()];
        List<Integer> lastLevel = triangle.get(triangle.size() - 1);
        int min = lastLevel.get(0), mark = 0, level = triangle.size();
        for (int i = 1; i < lastLevel.size(); i++) {
            if (min > lastLevel.get(i)) {
                min = lastLevel.get(i);
                mark = i;
            }
        }
        rem[level - 1] = min;
        cal(triangle, mark, level);
        return rem[0];
    }
    void cal(List<List<Integer>> triangle, int mark, int level){
        if (level == 1) return;
        for (int i = level - 2; i >= 1; i--) {
            if (mark < triangle.get(i).size() - 1 &&
                    triangle.get(i).get(mark) > triangle.get(i).get(mark - 1))
            { mark -= 1;}
            rem[i] = rem[i + 1] + triangle.get(i).get(mark);
        }
        rem[0] = triangle.get(0).get(0) + rem[1];
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

  }