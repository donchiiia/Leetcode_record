import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
Given an array nums of n integers, return an array of all the unique 
quadruplets [nums[a], nums[b], nums[c], nums[d]] such that: 

 
 0 <= a, b, c, d < n 
 a, b, c, and d are distinct. 
 nums[a] + nums[b] + nums[c] + nums[d] == target 
 

 You may return the answer in any order. 

 
 Example 1: 

 
Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 

 Example 2: 

 
Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]
 

 
 Constraints: 

 
 1 <= nums.length <= 200 
 -10⁹ <= nums[i] <= 10⁹ 
 -10⁹ <= target <= 10⁹ 
 
 Related Topics 数组 双指针 排序 👍 1147 👎 0

*/
  
  public class FourSum{
      public static void main(String[] args) {
          Solution solution = new FourSum().new Solution();
          int[] nums = {-3,-2,-1,0,0,1,2,3}; //-2, -1, 0, 0, 1, 2
          int[] nums1 = {1,0,-1,0,-2,2};
          int target1 = 0;
          int target = 0;
          System.out.println(solution.fourSum(nums1, target1));
          System.out.println(solution.fourSum(nums, target));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          public List<List<Integer>> fourSum(int[] nums, int target) {
              Arrays.sort(nums);
              return NSumTarget(nums, 4, 0, target);
          }
          public List<List<Integer>> NSumTarget(int[] nums, int n, int start, int target) {
              int length = nums.length;
              List<List<Integer>> res = new ArrayList<>();

              if (n < 2 || length < n) return res;
              //n==2时不用递归，属于极限情况的处理
              if (n == 2) {
                  int lo = start, hi = length - 1;
                  while (lo < hi) {
                      int sum = nums[lo] + nums[hi];
                      int leftValue = nums[lo], rightValue = nums[hi];
                      if (sum < target) {
                          while (lo < hi && nums[lo] == leftValue) lo++;
                      } else if (sum > target) {
                          while (lo < hi && nums[hi] == rightValue) hi--;
                      } else {
                          List<Integer> list = new ArrayList<Integer>();
                          list.add(nums[lo]);
                          list.add(nums[hi]);
                          res.add(list);
                          while (lo < hi && nums[lo] == leftValue) lo++;
                          while (lo < hi && nums[hi] == rightValue) hi--;
                      }
                  }
              } else {
                  for (int i = start; i < length; i++) {
                      List<List<Integer>> subLists = NSumTarget(nums, n - 1, i + 1, target - nums[i]);
                      for (List<Integer> sublist : subLists) {
                          sublist.add(nums[i]);
                          res.add(sublist);
                      }
                      while (i < length - 1 && nums[i] == nums[i + 1]) {
                          i++;
                      }
                  }
              }
              return res;
          }
}
//leetcode submit region end(Prohibit modification and deletion)

  }