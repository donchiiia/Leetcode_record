package editor.cn;

/**
Given an array, rotate the array to the right by k steps, where k is non-
negative. 

 
 Example 1: 

 
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
 

 Example 2: 

 
Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
 

 
 Constraints: 

 
 1 <= nums.length <= 10⁵ 
 -2³¹ <= nums[i] <= 2³¹ - 1 
 0 <= k <= 10⁵ 
 

 
 Follow up: 

 
 Try to come up with as many solutions as you can. There are at least three 
different ways to solve this problem. 
 Could you do it in-place with O(1) extra space? 
 
 Related Topics 数组 数学 双指针 👍 1396 👎 0

*/
  
  public class RotateArray{
      public static void main(String[] args) {
           Solution solution = new RotateArray().new Solution();
          int[] ints = {1, 2, 3, 4, 5, 6, 7};
          solution.rotate(ints, 3);
          for (int k :
                  ints) {
              System.out.print(k + " ");
          }
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[] nums, int k) {
        int j = nums.length - 1;
        k %= (j + 1);
        reverse(nums, 0, j);
        reverse(nums, 0, k - 1);
        reverse(nums, k, j);
    }
    public void reverse(int[] nums, int i, int j){
        while (i < j) {
            int t = nums[i];
            nums[i++] = nums[j];
            nums[j--] = t;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }