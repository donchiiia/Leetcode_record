  /**
There is an integer array nums sorted in non-decreasing order (not necessarily 
with distinct values). 

 Before being passed to your function, nums is rotated at an unknown pivot 
index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], 
..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1
,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,
4,4]. 

 Given the array nums after the rotation and an integer target, return true if 
target is in nums, or false if it is not in nums. 

 You must decrease the overall operation steps as much as possible. 

 
 Example 1: 
 Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
 Example 2: 
 Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
 
 
 Constraints: 

 
 1 <= nums.length <= 5000 
 -10⁴ <= nums[i] <= 10⁴ 
 nums is guaranteed to be rotated at some pivot. 
 -10⁴ <= target <= 10⁴ 
 

 
 Follow up: This problem is similar to Search in Rotated Sorted Array, but nums 
may contain duplicates. Would this affect the runtime complexity? How and why? 
 Related Topics 数组 二分查找 👍 558 👎 0

*/
  
  public class SearchInRotatedSortedArrayIi{
      public static void main(String[] args) {
           Solution solution = new SearchInRotatedSortedArrayIi().new Solution();
          System.out.println(solution.search(new int[]{2}, 2));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean search(int[] nums, int target) {
        int from = 0, to = nums.length - 1;

        if (nums.length > 0) {
            while (from <= to) {
                int div = from + (to - from) / 2;
                if (nums[div] == target) {
                    return true;
                } else if (nums[div] > nums[from]) {
                    if (nums[div] >= target && nums[from] <= target) {
                        to = div - 1;
                    } else {
                        from = div + 1;
                    }
                } else if (nums[div] < nums[from]) {
                    if (nums[div] <= target && nums[to] >= target) {
                        from = div + 1;
                    } else {
                        to = div - 1;
                    }
                } else {
                    if (nums[from] == nums[div]) {
                        from++;
                    }
                    if (nums[to] == nums[div]) {
                        to--;
                    }
                }
            }
        }return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }