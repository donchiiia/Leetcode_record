import java.util.*;

/**
Given a collection of numbers, nums, that might contain duplicates, return all 
possible unique permutations in any order. 

 
 Example 1: 

 
Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
 

 Example 2: 

 
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 

 
 Constraints: 

 
 1 <= nums.length <= 8 
 -10 <= nums[i] <= 10 
 
 Related Topics 数组 回溯 👍 970 👎 0

*/
  
  public class PermutationsIi{
      public static void main(String[] args) {
           Solution solution = new PermutationsIi().new Solution();
          int[] nums = {1, 3, 2};
          System.out.println(solution.permuteUnique(nums));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashSet<List<Integer>> set = new HashSet<>();

        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        ArrayDeque<Integer> path = new ArrayDeque<>();
        dfs(set, path, nums, 0, nums.length, used);
        return new ArrayList<>(set);
//        ArrayList<List<Integer>> lists = new ArrayList<>();
//        HashSet<List<Integer>> set = new HashSet<>();
//        int length = nums.length;
//
//        if (length == 0) {
//            return lists;
//        }
//        boolean[] used = new boolean[length];
//        ArrayDeque<Integer> path = new ArrayDeque<>();
//        dfs(nums, 0, length, path, used, set);
//        for (List n :
//                set) {
//            lists.add(n);
//        }
//        return lists;
    }

          private void dfs(HashSet<List<Integer>> set, ArrayDeque<Integer> path, int[] nums, int i, int length, boolean[] used) {
              if (i == length) {
                  set.add(new ArrayList<>(path));
                  return;
              }
              for (int k = 0; k < length; k++) {
                  if (!used[k]) {
                      path.addLast(nums[k]);
                      used[k] = true;
                      dfs(set, path, nums, i + 1, length, used);
                      used[k] = false;
                      path.removeLast();
                  }
              }
          }


//    private void dfs(int[] nums, int depth, int length, ArrayDeque<Integer> path, boolean[] used, HashSet<List<Integer>> set) {
//        if (length == depth) {
//            set.add(new ArrayList<>(path));
//            return;
//        }
//        for (int i = 0; i < length; i++) {
//            if (!used[i]) {
//                path.addLast(nums[i]);
//                used[i] = true;
//                dfs(nums, depth + 1, length, path, used, set);
//                path.removeLast();
//                used[i] = false;
//            }
//        }
//    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }