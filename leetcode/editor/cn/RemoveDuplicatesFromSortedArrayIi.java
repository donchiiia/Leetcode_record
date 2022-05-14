  /**
Given an integer array nums sorted in non-decreasing order, remove some 
duplicates in-place such that each unique element appears at most twice. The relative 
order of the elements should be kept the same. 

 Since it is impossible to change the length of the array in some languages, 
you must instead have the result be placed in the first part of the array nums. 
More formally, if there are k elements after removing the duplicates, then the 
first k elements of nums should hold the final result. It does not matter what you 
leave beyond the first k elements. 

 Return k after placing the final result in the first k slots of nums. 

 Do not allocate extra space for another array. You must do this by modifying 
the input array in-place with O(1) extra memory. 

 Custom Judge: 

 The judge will test your solution with the following code: 

 
int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
 

 If all assertions pass, then your solution will be accepted. 

 
 Example 1: 

 
Input: nums = [1,1,1,2,2,3]
Output: 5, nums = [1,1,2,2,3,_]
Explanation: Your function should return k = 5, with the first five elements of 
nums being 1, 1, 2, 2 and 3 respectively.
It does not matter what you leave beyond the returned k (hence they are 
underscores).
 

 Example 2: 

 
Input: nums = [0,0,1,1,1,1,2,3,3]
Output: 7, nums = [0,0,1,1,2,3,3,_,_]
Explanation: Your function should return k = 7, with the first seven elements 
of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
It does not matter what you leave beyond the returned k (hence they are 
underscores).
 

 
 Constraints: 

 
 1 <= nums.length <= 3 * 10⁴ 
 -10⁴ <= nums[i] <= 10⁴ 
 nums is sorted in non-decreasing order. 
 
 Related Topics 数组 双指针 👍 649 👎 0

*/
  
  public class RemoveDuplicatesFromSortedArrayIi{
      public static void main(String[] args) {
           Solution solution = new RemoveDuplicatesFromSortedArrayIi().new Solution();
          int[] nums = {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 3, 3};
          System.out.print(solution.removeDuplicates(nums) + "#");
          for (int i :
                  nums) {
              System.out.print(i);
          }
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        //题目要求最多出现2次，故此处length<=2，对应的如果要求出现n次，改成length<=n
        if (length <= 2) {
            return length;
        }
        int k = 2, i = 2;
        while (i < length) {
            //因为数组是递增连续的，检查当前元素nums[i]和上上个应该保留的元素nums[k-2]是否相等，如果相等意味着超过了3个的连续
            //这意味着要继续向后探测，即i++。否则意味着出现了新元素，要覆盖原先的值。
            if (nums[k - 2] != nums[i]) {
                nums[k++] = nums[i];
            }
            i++;
        }
        return k;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }