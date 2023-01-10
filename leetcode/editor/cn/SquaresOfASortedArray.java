package editor.cn;

/**
Given an integer array nums sorted in non-decreasing order, return an array of 
the squares of each number sorted in non-decreasing order. 

 
 Example 1: 

 
Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
 

 Example 2: 

 
Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 

 
 Constraints: 

 
 1 <= nums.length <= 10⁴ 
 -10⁴ <= nums[i] <= 10⁴ 
 nums is sorted in non-decreasing order. 
 

 
Follow up: Squaring each element and sorting the new array is very trivial, 
could you find an O(n) solution using a different approach? Related Topics 数组 双指针 排序
 👍 471 👎 0

*/
  
  public class SquaresOfASortedArray{
      public static void main(String[] args) {
           Solution solution = new SquaresOfASortedArray().new Solution();
          int[] res = {-7,-3,2,3,11};
          res = solution.sortedSquares(res);
          for (int k :
                  res) {
              System.out.print(k + " ");
          }
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortedSquares(int[] nums) {
        int length = nums.length, i = 0, j = length - 1, k = j;
        int[] res = new int[length];

        while (i <= j) {
            int res1 = nums[i] * nums[i], res2 = nums[j] * nums[j];
            if (res1 > res2) {
                res[k--] = res1;
                ++i;
            } else {
                res[k--] = res2;
                --j;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }