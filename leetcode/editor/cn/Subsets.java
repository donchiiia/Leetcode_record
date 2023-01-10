package editor.cn;

import java.util.LinkedList;
import java.util.List;

/**
Given an integer array nums of unique elements, return all possible subsets (
the power set). 

 The solution set must not contain duplicate subsets. Return the solution in 
any order. 

 
 Example 1: 

 
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 

 Example 2: 

 
Input: nums = [0]
Output: [[],[0]]
 

 
 Constraints: 

 
 1 <= nums.length <= 10 
 -10 <= nums[i] <= 10 
 All the numbers of nums are unique. 
 
 Related Topics 位运算 数组 回溯 👍 1572 👎 0

*/
  
  public class Subsets{
      public static void main(String[] args) {
           Solution solution = new Subsets().new Solution();
          System.out.println(solution.subsets(new int[]{1,2,3}));

      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      public List<List<Integer>> subsets(int[] nums){
          LinkedList<List<Integer>> res = new LinkedList<>();
          int judgeInt = (int) Math.pow(2, nums.length), markTag = 1;

          for (int i = 0; i < judgeInt; i++) {
              LinkedList<Integer> temp = new LinkedList<>();
              for (int j = i; j != 0; j >>>= 1) {
                  if ((j & 1) == 1) temp.add(nums[markTag - 1]);
                  markTag++;
              }
              markTag = 1;
              res.add(temp);
          }
          return res;
      }

    //dfs实现
    /*public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new LinkedList<>();
        ArrayList<Integer> temp = new ArrayList<>();

        lists.add(new ArrayList<>());

        dfs(nums, 0, lists, temp);
        return lists;
    }

    private void dfs(int[] nums, int i, List<List<Integer>> lists, ArrayList<Integer> temp) {
        if (i == nums.length) return;
        for (int j = i; j < nums.length; j++) {
            temp.add(nums[j]);
            lists.add(new ArrayList<>(temp));
            dfs(nums, j + 1, lists, temp);
            temp.remove(temp.size() - 1);
        }
    }*/
      }
//leetcode submit region end(Prohibit modification and deletion)

  }