  /**
Given a sorted array of distinct integers and a target value, return the index 
if the target is found. If not, return the index where it would be if it were 
inserted in order. 

 You must write an algorithm with O(log n) runtime complexity. 

 
 Example 1: 

 
Input: nums = [1,3,5,6], target = 5
Output: 2
 

 Example 2: 

 
Input: nums = [1,3,5,6], target = 2
Output: 1
 

 Example 3: 

 
Input: nums = [1,3,5,6], target = 7
Output: 4
 

 
 Constraints: 

 
 1 <= nums.length <= 10⁴ 
 -10⁴ <= nums[i] <= 10⁴ 
 nums contains distinct values sorted in ascending order. 
 -10⁴ <= target <= 10⁴ 
 
 Related Topics 数组 二分查找 👍 1413 👎 0

*/
  
  public class SearchInsertPosition{
      public static void main(String[] args) {
           Solution solution = new SearchInsertPosition().new Solution();
          System.out.println(solution.searchInsert(new int[]{1,3,5,6}, 5));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int searchInsert(int[] nums, int target) {
        int from = 0, to = nums.length - 1;

        while (from <= to) {
            int mid = from + (to - from) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                from = mid + 1;
            } else {
                to = mid - 1;
            }
        }
        return from;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }