import java.util.*;

/**
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0. 

 Notice that the solution set must not contain duplicate triplets. 

 
 Example 1: 
 Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
 Example 2: 
 Input: nums = []
Output: []
 Example 3: 
 Input: nums = [0]
Output: []
 
 
 Constraints: 

 
 0 <= nums.length <= 3000 
 -10⁵ <= nums[i] <= 10⁵ 
 
 Related Topics 数组 双指针 排序 👍 4593 👎 0

*/
  
  public class ThreeSum{
      public static void main(String[] args) {
           Solution solution = new ThreeSum().new Solution();
          System.out.println(solution.threeSum(new int[]{/*-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6*//*-2,0,0,2,2*//*-1,0,1,2,-1,-4*//*1,1,-2*/0,0,0}));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new LinkedList<>();
        Arrays.sort(nums);
        if (nums.length < 3 || nums[nums.length - 1] < 0 || nums[0] > 0) return lists;
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1, k = nums.length - 1;
            if (i > 0 && nums[i] == nums[i - 1])continue;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    ArrayList<Integer> integers = new ArrayList<>(3);
                    integers.add(nums[i]);
                    integers.add(nums[j]);
                    integers.add(nums[k]);
                    lists.add(integers);
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    while (j < k && nums[k] == nums[k - 1]) k--;
                    j++;
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < 0 ) j++;
                else k--;
            }
        }
        return lists;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }