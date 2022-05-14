import javax.swing.text.GapContent;
import javax.swing.text.html.HTML;
import java.text.Normalizer;

/**
Given an array of integers nums sorted in non-decreasing order, find the 
starting and ending position of a given target value. 

 If target is not found in the array, return [-1, -1]. 

 You must write an algorithm with O(log n) runtime complexity. 

 
 Example 1: 
 Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
 Example 2: 
 Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
 Example 3: 
 Input: nums = [], target = 0
Output: [-1,-1]
 
 
 Constraints: 

 
 0 <= nums.length <= 10⁵ 
 -10⁹ <= nums[i] <= 10⁹ 
 nums is a non-decreasing array. 
 -10⁹ <= target <= 10⁹ 
 
 Related Topics 数组 二分查找 👍 1529 👎 0

*/
  
  public class FindFirstAndLastPositionOfElementInSortedArray{
      public static void main(String[] args) {
           Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
          int[] ans = solution.searchRange(new int[]{5,7,7,8,8,10}, 6);
          System.out.println(ans[0] + "#" + ans[1]);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
/*        int[] ans = {-1, -1};
        int from = 0, to = nums.length - 1;
        if (nums.length > 0) {
            while (from <= to) {
                int mid = from + (to - from) >> 1;
                if (nums[mid] < target) from = mid + 1;
                else if (nums[mid] > target) {
                    to = mid - 1;
                } else {
                    ans[0] = searchHelper(nums, target, from, mid, 0);
                    ans[1] = searchHelper(nums, target, mid ,to, 1) - 1;
                    break;
                }
            }
        }
        return ans;
    }
    public int searchHelper(int[] nums, int target, int from, int to, int tag){
        if (from == to) return to;
        while (from < to) {
            int mid = from + ((to - from) >> 1);
            if (nums[mid] < target) from = mid + 1;
            else if (nums[mid] > target) to = mid - 1;
            else return searchHelper(nums, target, (tag == 0) ? (to - 1) : to, (tag == 1) ? (from + 1) : from, tag);
        }
        return tag == 0 ? from : to;
    }*/
        int[] ans = {-1, -1};
        int from = 0, to = nums.length - 1;

        if (nums.length > 0) {
            while (from <= to) {
                int div = from + (to - from) / 2;
                if (nums[div] < target) {
                    from = div+1;
                } else if (nums[div] > target) {
                    to = div-1;
                } else {
                    ans[0] = returnFirst(nums, from, div, target);
                    ans[1] = returnLast(nums, div, to, target);
                    break;
                }
            }
        }
        return ans;
    }
    public int returnFirst(int[] nums, int from, int to, int target){
        while (from <= to) {
            int div = from + (to - from) / 2;
            if (nums[div] < target) {
                from = div+1;
            } else if (nums[div] > target) {
                to = div-1;
            } else {
                return returnFirst(nums, from, --to, target);
            }
        }
        return from;
    }
    public int returnLast(int[] nums, int from, int to ,int target){
        while (from <= to) {
            int div = from + (to - from) / 2;
            if (nums[div] < target) {
                from = div+1;
            } else if (nums[div] > target) {
                to = div-1;
            } else {
                return returnLast(nums, ++from, to, target);
            }
        }
        return to;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }