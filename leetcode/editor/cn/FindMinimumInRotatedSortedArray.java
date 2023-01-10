package editor.cn;

/**
Suppose an array of length n sorted in ascending order is rotated between 1 and 
n times. For example, the array nums = [0,1,2,4,5,6,7] might become: 

 
 [4,5,6,7,0,1,2] if it was rotated 4 times. 
 [0,1,2,4,5,6,7] if it was rotated 7 times. 
 

 Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results 
in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]]. 

 Given the sorted rotated array nums of unique elements, return the minimum 
element of this array. 

 You must write an algorithm that runs in O(log n) time. 

 
 Example 1: 

 
Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.
 

 Example 2: 

 
Input: nums = [4,5,6,7,0,1,2]
Output: 0
Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
 

 Example 3: 

 
Input: nums = [11,13,15,17]
Output: 11
Explanation: The original array was [11,13,15,17] and it was rotated 4 times. 
 

 
 Constraints: 

 
 n == nums.length 
 1 <= n <= 5000 
 -5000 <= nums[i] <= 5000 
 All the integers of nums are unique. 
 nums is sorted and rotated between 1 and n times. 
 
 Related Topics 数组 二分查找 👍 686 👎 0

*/
  
  public class FindMinimumInRotatedSortedArray{
      public static void main(String[] args) {
           Solution solution = new FindMinimumInRotatedSortedArray().new Solution();
          System.out.println(solution.findMin(new int[]{279,284,285,287,288,296,2,8,10,11,12,13,14,19,20,22,25,26,27,28,29,33,37,39,42,43,47,48,49,50,57,62,63,66,68,69,71,73,74,77,78,79,85,89,92,94,99,111,113,117,120,122,125,134,145,152,155,157,160,161,167,168,181,182,188,189,190,194,199,201,204,208,213,220,223,225,226,227,231,237,240,242,247,254,259,260,261,264,267,271,275
}));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMin(int[] nums) {
        int from = 0, to = nums.length - 1, min = Integer.MAX_VALUE;
        if (nums.length > 0) {
            if (nums[from] <= nums[to]) return nums[from];
            while (from <= to) {
                int mid = from + (to - from >> 1);
                if (nums[mid] < min) min = nums[mid];
                if (nums[mid] > nums[from]) {
                    min = Math.min(min, nums[from]);
                    from = mid + 1;
                } else if (nums[mid] < nums[from]) {
                    min = Math.min(min, nums[from]);
                    to = mid - 1;
                } else {
                    from++;
                }
            }
        }
        return min;

        /*int from = 0, to = nums.length - 1;

        if (nums.length > 0) {
            int min = nums[0];
            if (nums[from] < nums[to]) return nums[from];
            while (from <= to) {
                int div = from + (to - from) / 2;
                if (min > nums[div]) {
                    min = nums[div];
                }
                if (nums[from] < nums[div]) {
                    min = nums[from];
                    from = div;
                } else if (nums[from] > nums[div]) {
                    min = nums[div];
                    to = div;
                } else {
                    if (nums[from] == nums[div])
                        from++;
                    if (nums[to] == nums[div]) {
                        to--;
                    }
                }
            }
            return min;
        }
        return Integer.MIN_VALUE;*/
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }