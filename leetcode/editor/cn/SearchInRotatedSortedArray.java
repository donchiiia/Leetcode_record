package editor.cn;

/**
There is an integer array nums sorted in ascending order (with distinct values).
 

 Prior to being passed to your function, nums is possibly rotated at an unknown 
pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], 
nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For 
example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1
,2]. 

 Given the array nums after the possible rotation and an integer target, return 
the index of target if it is in nums, or -1 if it is not in nums. 

 You must write an algorithm with O(log n) runtime complexity. 

 
 Example 1: 
 Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
 Example 2: 
 Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
 Example 3: 
 Input: nums = [1], target = 0
Output: -1
 
 
 Constraints: 

 
 1 <= nums.length <= 5000 
 -10⁴ <= nums[i] <= 10⁴ 
 All values of nums are unique. 
 nums is an ascending array that is possibly rotated. 
 -10⁴ <= target <= 10⁴ 
 
 Related Topics 数组 二分查找 👍 1911 👎 0

*/
  
  public class SearchInRotatedSortedArray{
      public static void main(String[] args) {
           Solution solution = new SearchInRotatedSortedArray().new Solution();
          System.out.println(solution.search(new int[]{4,5,6,7,0,1,2}, 1));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        int from = 0, to = nums.length - 1;
        if (nums.length > 0) {
            while (from <= to) {
                int mid = from + ((to - from) >> 1);
                if (nums[mid] == target) return mid;
                else if (nums[mid] > nums[from]) {
                    if (nums[from] <= target && nums[mid] >= target) to = mid - 1;
                    else from = mid + 1;
                } else if (nums[mid] < nums[from]) {
                    if (nums[mid] <= target && nums[to] >= target) from = mid + 1;
                    else to = mid - 1;
                } else from++;
            }
        }
        return -1;
        /*int from = 0, to = nums.length - 1;

        if (nums.length > 0) {
            while (from <= to) {
                int div = from + (to - from) / 2;
                if (nums[div] == target) {
                    return div;
                } else if (nums[div] > nums[from]) {
                    if (nums[from] <= target && nums[div] >= target) {
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
                } else { //此时为div等于边界的情况，意味着一边已经到头了且不满足要求，意味着要向div另一边拓展
                    if (nums[from] == nums[div]) {
                        from++;
                    }
                    if (nums[to] == nums[div]) {
                        to--;
                    }
                }
            }
        }
        return -1;*/
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }