package editor.cn;

import java.util.Arrays;

/**
Given an integer array nums of size n, return the minimum number of moves 
required to make all array elements equal. 

 In one move, you can increment or decrement an element of the array by 1. 

 Test cases are designed so that the answer will fit in a 32-bit integer. 

 
 Example 1: 

 
Input: nums = [1,2,3]
Output: 2
Explanation:
Only two moves are needed (remember each move increments or decrements one 
element):
[1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 

 Example 2: 

 
Input: nums = [1,10,2,9]
Output: 16
 

 
 Constraints: 

 
 n == nums.length 
 1 <= nums.length <= 10⁵ 
 -10⁹ <= nums[i] <= 10⁹ 
 
 Related Topics 数组 数学 排序 👍 210 👎 0

*/

public class MinimumMovesToEqualArrayElementsIi{
    public static void main(String[] args) {
        Solution solution = new MinimumMovesToEqualArrayElementsIi().new Solution();
        System.out.println(solution.minMoves2(new int[]{1, 2, 3}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1, res = 0;
        while (i < j) {
            res += nums[j--] - nums[i++];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }