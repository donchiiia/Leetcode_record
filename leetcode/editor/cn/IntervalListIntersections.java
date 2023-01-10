package editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
You are given two lists of closed intervals, firstList and secondList, where 
firstList[i] = [starti, endi] and secondList[j] = [startj, endj]. Each list of 
intervals is pairwise disjoint and in sorted order. 

 Return the intersection of these two interval lists. 

 A closed interval [a, b] (with a <= b) denotes the set of real numbers x with 
a <= x <= b. 

 The intersection of two closed intervals is a set of real numbers that are 
either empty or represented as a closed interval. For example, the intersection of [
1, 3] and [2, 4] is [2, 3]. 

 
 Example 1: 

 
Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[1
5,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 

 Example 2: 

 
Input: firstList = [[1,3],[5,9]], secondList = []
Output: []
 

 
 Constraints: 

 
 0 <= firstList.length, secondList.length <= 1000 
 firstList.length + secondList.length >= 1 
 0 <= starti < endi <= 10⁹ 
 endi < starti+1 
 0 <= startj < endj <= 10⁹ 
 endj < startj+1 
 
 Related Topics 数组 双指针 👍 267 👎 0

*/
  
  public class IntervalListIntersections{
      public static void main(String[] args) {
           Solution solution = new IntervalListIntersections().new Solution();
          int[][] firstList = new int[][]{{0,2},{5,10},{13,23},{24,25}}, secondList = new int[][]{
                  {1,5},{8,12},{15,24},{25,26}
          };
          int[][] res = solution.intervalIntersection(firstList, secondList);
          for (int[] r : res) {
              System.out.println(r[0]);
          }
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int firstRow = firstList.length, secondRow = secondList.length, i = 0, j = 0;
        while (i < firstRow && j < secondRow) {
            int[] rec = new int[2];
            rec[0] = Math.max(firstList[i][0], secondList[j][0]);
            rec[1] = Math.min(firstList[i][1], secondList[j][1]);
            if (rec[1] >= rec[0]) res.add(rec);
            if (secondList[j][1] > firstList[i][1]) i++;
            else j++;
        }
        return res.toArray(new int[res.size()][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }