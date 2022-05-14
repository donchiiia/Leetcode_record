  /**
An integer array is called arithmetic if it consists of at least three elements 
and if the difference between any two consecutive elements is the same. 

 
 For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
 
 

 Given an integer array nums, return the number of arithmetic subarrays of nums.
 

 A subarray is a contiguous subsequence of the array. 

 
 Example 1: 

 
Input: nums = [1,2,3,4]
Output: 3
Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,2,
3,4] itself.
 

 Example 2: 

 
Input: nums = [1]
Output: 0
 

 
 Constraints: 

 
 1 <= nums.length <= 5000 
 -1000 <= nums[i] <= 1000 
 
 Related Topics 数组 动态规划 👍 438 👎 0

*/
  
  public class ArithmeticSlices{
      public static void main(String[] args) {
           Solution solution = new ArithmeticSlices().new Solution();
          System.out.println(solution.numberOfArithmeticSlices(new int[]{1,2,3,4}));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int length = nums.length;
        //连续的等差数列，总子数组的数量随着个数的增加线性增加
        //[1,2,3]=1
        //[1,2,3,4]=3=1+2
        //[1,2,3,4,5]=6=1+2+3
        int res = 0, add = 0;
        if (nums == null || length < 3) return 0;
        for (int k = 2; k < length; k++) {
            if (nums[k] - nums[k - 1] == nums[k - 1] - nums[k - 2]) {
                res += ++add;
            }
            else add = 0;   //如果出现使得等差数列不连续的元素，就将递增变量add置零
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }