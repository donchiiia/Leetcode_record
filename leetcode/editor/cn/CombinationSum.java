import java.util.*;

/**
Given an array of distinct integers candidates and a target integer target, 
return a list of all unique combinations of candidates where the chosen numbers sum 
to target. You may return the combinations in any order. 

 The same number may be chosen from candidates an unlimited number of times. 
Two combinations are unique if the frequency of at least one of the chosen numbers 
is different. 

 It is guaranteed that the number of unique combinations that sum up to target 
is less than 150 combinations for the given input. 

 
 Example 1: 

 
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple 
times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
 

 Example 2: 

 
Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
 

 Example 3: 

 
Input: candidates = [2], target = 1
Output: []
 

 
 Constraints: 

 
 1 <= candidates.length <= 30 
 1 <= candidates[i] <= 200 
 All elements of candidates are distinct. 
 1 <= target <= 500 
 
 Related Topics 数组 回溯 👍 1828 👎 0

*/
  
  public class CombinationSum{
      public static void main(String[] args) {
           Solution solution = new CombinationSum().new Solution();
          System.out.println(solution.combinationSum(new int[]{2,3,6,7}, 7));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        HashSet<List<Integer>> res = new HashSet<>();
        ArrayDeque<Integer> path = new ArrayDeque<>();
        int aim = target, sum = 0;

        Arrays.sort(candidates);
        dfs(res, path, candidates, 0, sum, aim, target);
        return new ArrayList<>(res);
//        HashSet<List<Integer>> set = new HashSet<List<Integer>>();
//        ArrayDeque<Integer> path = new ArrayDeque<>();
//        int sum = 0, aim = target;
//
//        Arrays.sort(candidates);
//        dfs(set, 0, path, candidates, target, sum, aim);
//        return new ArrayList<>(set);
    }

          private void dfs(HashSet<List<Integer>> res, ArrayDeque<Integer> path, int[] candidates, int i, int sum, int aim, int target) {
              if (sum == target) {
                  res.add(new ArrayList<>(path));
                  return;
              }
              for (int k = i; k < candidates.length; k++) {
                  if (candidates[k] <= aim) {
                      sum += candidates[k];
                      aim -= candidates[k];
                      path.addLast(candidates[k]);
                      dfs(res, path, candidates, k, sum, aim, target);
                      path.removeLast();
                      aim += candidates[k];
                      sum -= candidates[k];
                  }
              }
          }
//    public boolean dfs(HashSet<List<Integer>> set, int start, ArrayDeque<Integer> path, int[] candidates, int target, int sum, int aim){
//        if (sum == aim) {
//            ArrayList<Integer> temp = new ArrayList<Integer>(path);
//            set.add(temp);
//            return true;
//        }
//        for (int i = start; i < candidates.length && target - candidates[i] >= 0; i++) {
//            sum += candidates[i];
//            target -= candidates[i];
//            path.addLast(candidates[i]);
//            dfs(set, i, path, candidates, target, sum, aim);
//            sum -= candidates[i];
//            target += candidates[i];
//            path.removeLast();
//        }
//        return false;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }