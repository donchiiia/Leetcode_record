/**
You are given an integer array nums and two integers limit and goal. The array 
nums has an interesting property that abs(nums[i]) <= limit. 

 Return the minimum number of elements you need to add to make the sum of the 
array equal to goal. The array must maintain its property that abs(nums[i]) <= 
limit. 

 Note that abs(x) equals x if x >= 0, and -x otherwise. 

 
 Example 1: 

 
Input: nums = [1,-1,1], limit = 3, goal = -4
Output: 2
Explanation: You can add -2 and -3, then the sum of the array will be 1 - 1 + 1 
- 2 - 3 = -4.
 

 Example 2: 

 
Input: nums = [1,-10,9,1], limit = 100, goal = 0
Output: 1
 

 
 Constraints: 

 
 1 <= nums.length <= 10⁵ 
 1 <= limit <= 10⁶ 
 -limit <= nums[i] <= limit 
 -10⁹ <= goal <= 10⁹ 
 

 Related Topics 贪心 数组 👍 17 👎 0

*/

package editor.cn;
public class MinimumElementsToAddToFormAGivenSum{
    public static void main(String[] args) {
        Solution solution = new MinimumElementsToAddToFormAGivenSum().new Solution();
        System.out.println("solution.minElements(new int[]{1, -1, 1}, 4, -4) = " + solution.minElements(new int[]{-1,0,1,1,1}, 1, 771843707));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        long diff = Math.abs(sum - goal);
        return (int) ((diff + limit - 1) / limit);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}