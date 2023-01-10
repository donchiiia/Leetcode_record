package editor.cn;

import java.util.*;

/**
Given a collection of candidate numbers (candidates) and a target number (
target), find all unique combinations in candidates where the candidate numbers sum 
to target. 

 Each number in candidates may only be used once in the combination. 

 Note: The solution set must not contain duplicate combinations. 

 
 Example 1: 

 
Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
 

 Example 2: 

 
Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]
 

 
 Constraints: 

 
 1 <= candidates.length <= 100 
 1 <= candidates[i] <= 50 
 1 <= target <= 30 
 
 Related Topics 数组 回溯 👍 876 👎 0

*/
  
  public class CombinationSumIi{
      public static void main(String[] args) {
           Solution solution = new CombinationSumIi().new Solution();
/*          System.out.println(solution.combinationSum2(new int[]{
                  1,1,1,1,1,1,1,1,1,1,
                  1,1,1,1,1,1,1,1,1,1,
                  1,1,1,1,1,1,1,1,1,1,
                  1,1,1,1,1,1,1,1,1,1}, 30));*/
          System.out.println(solution.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public int sum = 0, aim = 0;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lists = new LinkedList<>();
        ArrayDeque<Integer> path = new ArrayDeque<>();
        int sum = 0, aim = target;

        Arrays.sort(candidates);
        dfs(lists, path, candidates, 0, sum, aim, target);
        return lists;

//        Arrays.sort(candidates);
//        ArrayList<List<Integer>> lists = new ArrayList<>();
//        aim = target;
//
//        dfs(candidates, 0, target, lists, new LinkedList());
//        return lists;
    }

          private void dfs(List<List<Integer>> lists, ArrayDeque<Integer> path, int[] candidates, int start, int sum, int aim, int target) {
              if (sum == target) {
                  lists.add(new ArrayList<>(path));
                  return;
              }
              for (int k = start; k < candidates.length; k++) {
                  if (candidates[k] <= aim) {
                      sum += candidates[k];
                      aim -= candidates[k];
                      path.addLast(candidates[k]);
                      if (k == start || candidates[k - 1] != candidates[k])
                      dfs(lists, path, candidates, k + 1, sum, aim, target);
                      path.removeLast();
                      aim += candidates[k];
                      sum -= candidates[k];
                  }else return;
              }
          }

//    public boolean dfs(int[] candidates, int start, int target, ArrayList<List<Integer>> lists, Deque rec){
//        if (sum == aim) {
//            lists.add(new ArrayList<>(rec));
//            return true;
//        }
//        for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
//            sum += candidates[i];
//            target -= candidates[i];
//            rec.push(candidates[i]);
//            if (i <= start || candidates[i - 1] != candidates[i]) {
//                dfs(candidates, i + 1, target, lists, rec);
//            }
//            sum -= candidates[i];
//            target += candidates[i];
//            rec.pop();
//        }
//        return false;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }