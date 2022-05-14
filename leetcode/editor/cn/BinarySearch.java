  /**
Given an array of integers nums which is sorted in ascending order, and an 
integer target, write a function to search target in nums. If target exists, then 
return its index. Otherwise, return -1. 

 You must write an algorithm with O(log n) runtime complexity. 

 
 Example 1: 

 
Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
 

 Example 2: 

 
Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1
 

 
 Constraints: 

 
 1 <= nums.length <= 10⁴ 
 -10⁴ < nums[i], target < 10⁴ 
 All the integers in nums are unique. 
 nums is sorted in ascending order. 
 
 Related Topics 数组 二分查找 👍 717 👎 0

*/
  
  public class BinarySearch{
      public static void main(String[] args) {
           Solution solution = new BinarySearch().new Solution();
          System.out.println(solution.search(new int[]{-1,0,0,0,3,5,9,12}, 0));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        int first = 0, end = nums.length, mid = 0;

        while (first < end) {
            mid = first + ((end - first) >> 1);
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) first = mid + 1;
            else end = mid;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }