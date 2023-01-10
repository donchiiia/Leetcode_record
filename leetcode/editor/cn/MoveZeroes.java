package editor.cn;

/**
Given an integer array nums, move all 0's to the end of it while maintaining 
the relative order of the non-zero elements. 

 Note that you must do this in-place without making a copy of the array. 

 
 Example 1: 
 Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
 Example 2: 
 Input: nums = [0]
Output: [0]
 
 
 Constraints: 

 
 1 <= nums.length <= 10⁴ 
 -2³¹ <= nums[i] <= 2³¹ - 1 
 

 
Follow up: Could you minimize the total number of operations done? Related 
Topics 数组 双指针 👍 1494 👎 0

*/
  
  public class MoveZeroes{
      public static void main(String[] args) {
           Solution solution = new MoveZeroes().new Solution();
          int[] temp = new int[]{0,1,0,3,12};
          solution.moveZeroes(temp);
          for (int x :
                  temp) {
              System.out.print(x + " ");
          }
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0, length = nums.length;

        while (i < length) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
            i++;
        }
        while (j < length) {
            nums[j++] = 0;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }