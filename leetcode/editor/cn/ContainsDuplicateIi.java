import java.util.HashMap;
import java.util.HashSet;

/**
Given an integer array nums and an integer k, return true if there are two 
distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= 
k. 

 
 Example 1: 

 
Input: nums = [1,2,3,1], k = 3
Output: true
 

 Example 2: 

 
Input: nums = [1,0,1,1], k = 1
Output: true
 

 Example 3: 

 
Input: nums = [1,2,3,1,2,3], k = 2
Output: false
 

 
 Constraints: 

 
 1 <= nums.length <= 10⁵ 
 -10⁹ <= nums[i] <= 10⁹ 
 0 <= k <= 10⁵ 
 
 Related Topics 数组 哈希表 滑动窗口 👍 461 👎 0

*/
  
  public class ContainsDuplicateIi{
      public static void main(String[] args) {
           Solution solution = new ContainsDuplicateIi().new Solution();
          System.out.println(solution.containsNearbyDuplicate(new int[]{2,2}, 3));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> res = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (res.containsKey(nums[i])) {
                if (i - res.get(nums[i]) <= k) {
                    return true;
                }
            }
            res.put(nums[i], i);
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }