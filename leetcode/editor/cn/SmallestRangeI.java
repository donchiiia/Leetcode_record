  /**
You are given an integer array nums and an integer k. 

 In one operation, you can choose any index i where 0 <= i < nums.length and 
change nums[i] to nums[i] + x where x is an integer from the range [-k, k]. You 
can apply this operation at most once for each index i. 

 The score of nums is the difference between the maximum and minimum elements 
in nums. 

 Return the minimum score of nums after applying the mentioned operation at 
most once for each index in it. 

 
 Example 1: 

 
Input: nums = [1], k = 0
Output: 0
Explanation: The score is max(nums) - min(nums) = 1 - 1 = 0.
 

 Example 2: 

 
Input: nums = [0,10], k = 2
Output: 6
Explanation: Change nums to be [2, 8]. The score is max(nums) - min(nums) = 8 - 
2 = 6.
 

 Example 3: 

 
Input: nums = [1,3,6], k = 3
Output: 0
Explanation: Change nums to be [4, 4, 4]. The score is max(nums) - min(nums) = 4
 - 4 = 0.
 

 
 Constraints: 

 
 1 <= nums.length <= 10⁴ 
 0 <= nums[i] <= 10⁴ 
 0 <= k <= 10⁴ 
 
 Related Topics 数组 数学 👍 83 👎 0

*/
  
  public class SmallestRangeI{
      public static void main(String[] args) {
           Solution solution = new SmallestRangeI().new Solution();
          System.out.println(solution.smallestRangeI(new int[]{0, 10}, 2));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        return max - min >= 2 * k ? (max - min - 2 * k) : 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }