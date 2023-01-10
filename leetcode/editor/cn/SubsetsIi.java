package editor.cn;

import java.util.*;

/**
Given an integer array nums that may contain duplicates, return all possible 
subsets (the power set). 

 The solution set must not contain duplicate subsets. Return the solution in 
any order. 

 
 Example 1: 
 Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 Example 2: 
 Input: nums = [0]
Output: [[],[0]]
 
 
 Constraints: 

 
 1 <= nums.length <= 10 
 -10 <= nums[i] <= 10 
 
 Related Topics 位运算 数组 回溯 👍 791 👎 0

*/
  
  public class SubsetsIi{
      public static void main(String[] args) {
           Solution solution = new SubsetsIi().new Solution();
          System.out.println(solution.subsetsWithDup(new int[]{4,4,4,1,4}));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        HashSet<List<Integer>> res = new HashSet<List<Integer>>();
        int judgeInt = (int) Math.pow(2, nums.length), markTag = 1;

        Arrays.sort(nums);
        for (int i = 0; i < judgeInt; i++) {
            LinkedList<Integer> temp = new LinkedList<>();
            for (int j = i; j != 0; j >>>= 1) {
                if ((j & 1) == 1) temp.add(nums[markTag - 1]);
                markTag++;
            }
            markTag = 1;
            res.add(temp);
        }
        return new ArrayList<List<Integer>>(res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }