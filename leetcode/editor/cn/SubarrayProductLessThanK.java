  /**
Given an array of integers nums and an integer k, return the number of 
contiguous subarrays where the product of all the elements in the subarray is strictly 
less than k. 

 
 Example 1: 

 
Input: nums = [10,5,2,6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are:
[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
Note that [10, 5, 2] is not included as the product of 100 is not strictly less 
than k.
 

 Example 2: 

 
Input: nums = [1,2,3], k = 0
Output: 0
 

 
 Constraints: 

 
 1 <= nums.length <= 3 * 10⁴ 
 1 <= nums[i] <= 1000 
 0 <= k <= 10⁶ 
 
 Related Topics 数组 滑动窗口 👍 380 👎 0

*/
  
  public class SubarrayProductLessThanK{
      public static void main(String[] args) {
           Solution solution = new SubarrayProductLessThanK().new Solution();
          System.out.println(solution.numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int left = 0, right = 0;
        int count = 0, mul = 1;
        while (right < nums.length) {
            mul *= nums[right];
            while (mul >= k) {
                mul /= nums[left++];
            }
            count += (right++ - left + 1);
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
  /*        int[] sumArray = new int[nums.length];
        int index = 0, count = 0;

        sumArray[index] = nums[index];
        if (nums[index] < k) count++;
        else index++;
        for (int i = 1; i < nums.length; i++) {
            while (nums[i] >= k) {
                if (i == nums.length - 1) return count;
                index = ++i;
                continue;
            }
            count++;
            if (sumArray[i - 1] >= k || sumArray[i - 1] == 0) {
                sumArray[i] = nums[i];
                 continue;
            }
            sumArray[i] = sumArray[i - 1] * nums[i];
            while (sumArray[i] >= k) {
                sumArray[i] /= nums[index++];
            }
            count += (i - index);
        }
        return count;*/