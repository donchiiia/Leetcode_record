package editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
Given two integers n and k, return all possible combinations of k numbers out 
of the range [1, n]. 

 You may return the answer in any order. 

 
 Example 1: 

 
Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 

 Example 2: 

 
Input: n = 1, k = 1
Output: [[1]]
 

 
 Constraints: 

 
 1 <= n <= 20 
 1 <= k <= n 
 
 Related Topics 数组 回溯 👍 923 👎 0

*/
  
  public class Combinations{
      public static void main(String[] args) {
           Solution solution = new Combinations().new Solution();
          System.out.println(solution.combine(4, 2));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> lists = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        backTracking(n, k, 1);
        return lists;
    }
    public void backTracking(int n, int k, int startIndex){
        if (path.size() == k) {
            lists.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backTracking(n, k, i + 1);
            path.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }