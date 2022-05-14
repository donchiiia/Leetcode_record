import java.awt.image.Kernel;

/**
Given an array of non-negative integers nums, you are initially positioned at 
the first index of the array. 

 Each element in the array represents your maximum jump length at that position.
 

 Your goal is to reach the last index in the minimum number of jumps. 

 You can assume that you can always reach the last index. 

 
 Example 1: 

 
Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 
step from index 0 to 1, then 3 steps to the last index.
 

 Example 2: 

 
Input: nums = [2,3,0,1,4]
Output: 2
 

 
 Constraints: 

 
 1 <= nums.length <= 10⁴ 
 0 <= nums[i] <= 1000 
 
 Related Topics 贪心 数组 动态规划 👍 1552 👎 0

*/
  
  public class JumpGameIi{
      public static void main(String[] args) {
           Solution solution = new JumpGameIi().new Solution();
          System.out.println(solution.jump(new int[]{/*5,9,3,2,1,0,2,3,3,1,0,0*/1,2,3}));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int jump(int[] nums) {
        //对于每一步，都可以知道由此步能够达到最远的范围，将这个范围作为边界记录，在遍历这个边界过程中，时刻记录更新能达到的最远距离，
        //当游标i到达边界时，用最远距离更新边界
        int length = nums.length, end = 0, maxPosition = 0, steps = 0;

        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }