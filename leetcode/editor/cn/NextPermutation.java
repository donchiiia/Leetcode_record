import java.util.Arrays;

/**
A permutation of an array of integers is an arrangement of its members into a 
sequence or linear order. 

 
 For example, for arr = [1,2,3], the following are considered permutations of 
arr: [1,2,3], [1,3,2], [3,1,2], [2,3,1]. 
 

 The next permutation of an array of integers is the next lexicographically 
greater permutation of its integer. More formally, if all the permutations of the 
array are sorted in one container according to their lexicographical order, then 
the next permutation of that array is the permutation that follows it in the 
sorted container. If such arrangement is not possible, the array must be rearranged 
as the lowest possible order (i.e., sorted in ascending order). 

 
 For example, the next permutation of arr = [1,2,3] is [1,3,2]. 
 Similarly, the next permutation of arr = [2,3,1] is [3,1,2]. 
 While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does 
not have a lexicographical larger rearrangement. 
 

 Given an array of integers nums, find the next permutation of nums. 

 The replacement must be in place and use only constant extra memory. 

 
 Example 1: 

 
Input: nums = [1,2,3]
Output: [1,3,2]
 

 Example 2: 

 
Input: nums = [3,2,1]
Output: [1,2,3]
 

 Example 3: 

 
Input: nums = [1,1,5]
Output: [1,5,1]
 

 
 Constraints: 

 
 1 <= nums.length <= 100 
 0 <= nums[i] <= 100 
 
 Related Topics 数组 双指针 👍 1584 👎 0

*/
  
  public class NextPermutation{
      public static void main(String[] args) {
           Solution solution = new NextPermutation().new Solution();
          int[] nums = {1, 9, 2, 2, 5, 9, 6, 1, 1};
          solution.nextPermutation(nums);
          for (int i :
                  nums) {
              System.out.print(i);
          }
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void nextPermutation(int[] nums) {
        int length = nums.length;
        if (length > 2) {
            for (int i = length - 2; i >= 0; i--) {
                if (nums[i] >= nums[i + 1]) {
                    continue;
                } else {
                    for (int j = length - 1; j >= i + 1; j--) {
                        if (nums[j] > nums[i]) {
                            swap(nums, i, j);
                            Arrays.sort(nums, i + 1, length);
                            return;
                        }
                    }
                }
            }
            Arrays.sort(nums, 0, length);
        } else {
            swap(nums, 0, length - 1);
        }
    }
    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }