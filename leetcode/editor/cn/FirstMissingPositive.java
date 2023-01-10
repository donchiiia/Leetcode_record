package editor.cn;

/**
Given an unsorted integer array nums, return the smallest missing positive 
integer. 

 You must implement an algorithm that runs in O(n) time and uses constant extra 
space. 

 
 Example 1: 
 Input: nums = [1,2,0]
Output: 3
 Example 2: 
 Input: nums = [3,4,-1,1]
Output: 2
 Example 3: 
 Input: nums = [7,8,9,11,12]
Output: 1
 
 
 Constraints: 

 
 1 <= nums.length <= 5 * 10⁵ 
 -2³¹ <= nums[i] <= 2³¹ - 1 
 
 Related Topics 数组 哈希表 👍 1397 👎 0

*/
  
  public class FirstMissingPositive{
      public static void main(String[] args) {
           Solution solution = new FirstMissingPositive().new Solution();
          System.out.println(solution.firstMissingPositive(new int[]{7,8,9,11,12}));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstMissingPositive(int[] nums) {
        int length = nums.length, mark = 1;
        boolean[] search = new boolean[length];

        for (int i = 0; i < length; i++) {
            int value = nums[i];
            if (nums[i] > 0 && value <= length) {
                search[value - 1] = true;
            }
        }
        for (mark = 1; mark <= length; mark++) {
            if (search[mark-1] == false) break;
        }
        return mark;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }