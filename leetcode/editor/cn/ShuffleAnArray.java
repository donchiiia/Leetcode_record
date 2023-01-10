package editor.cn;

import java.util.Arrays;
import java.util.Random;

/**
Given an integer array nums, design an algorithm to randomly shuffle the array. 
All permutations of the array should be equally likely as a result of the 
shuffling. 

 Implement the Solution class: 

 
 Solution(int[] nums) Initializes the object with the integer array nums. 
 int[] reset() Resets the array to its original configuration and returns it. 
 int[] shuffle() Returns a random shuffling of the array. 
 

 
 Example 1: 

 
Input
["Solution", "shuffle", "reset", "shuffle"]
[[[1, 2, 3]], [], [], []]
Output
[null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]

Explanation
Solution solution = new Solution([1, 2, 3]);
solution.shuffle();    // Shuffle the array [1,2,3] and return its result.
                       // Any permutation of [1,2,3] must be equally likely to 
be returned.
                       // Example: return [3, 1, 2]
solution.reset();      // Resets the array back to its original configuration [1
,2,3]. Return [1, 2, 3]
solution.shuffle();    // Returns the random shuffling of array [1,2,3]. 
Example: return [1, 3, 2]

 

 
 Constraints: 

 
 1 <= nums.length <= 50 
 -10⁶ <= nums[i] <= 10⁶ 
 All the elements of nums are unique. 
 At most 10⁴ calls in total will be made to reset and shuffle. 
 
 Related Topics 数组 数学 随机化 👍 273 👎 0

*/
  
  public class ShuffleAnArray{
      public static void main(String[] args) {
          Solution solution = new ShuffleAnArray().new Solution(new int[]{1, 2, 3, 4, 5});
          System.out.println(Arrays.toString(solution.reset()));
          System.out.println(Arrays.toString(solution.shuffle()));
          System.out.println(Arrays.toString(solution.reset()));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] aim = null;
    public int[] sour = null;
    Random random = new Random();
    public Solution(int[] nums) {
        aim = nums;
        sour = aim.clone();
    }
    
    public int[] reset() {
        aim = sour;
        sour = sour.clone();
        return aim;
    }
    
    public int[] shuffle() {
        for (int i = aim.length; i > 1; i--) {
            swap(i - 1, random.nextInt(i));
        }
        return aim;
    }
    private void swap(int a, int b){
        int temp = aim[a];
        aim[a] = aim[b];
        aim[b] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
//leetcode submit region end(Prohibit modification and deletion)

  }