import java.util.concurrent.atomic.AtomicMarkableReference;

/**
You are a professional robber planning to rob houses along a street. Each house 
has a certain amount of money stashed, the only constraint stopping you from 
robbing each of them is that adjacent houses have security systems connected and 
it will automatically contact the police if two adjacent houses were broken into 
on the same night. 

 Given an integer array nums representing the amount of money of each house, 
return the maximum amount of money you can rob tonight without alerting the police.
 

 
 Example 1: 

 
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
 

 Example 2: 

 
Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (
money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
 

 
 Constraints: 

 
 1 <= nums.length <= 100 
 0 <= nums[i] <= 400 
 
 Related Topics 数组 动态规划 👍 2016 👎 0

*/
  
  public class HouseRobber{
      public static void main(String[] args) {
           Solution solution = new HouseRobber().new Solution();
          System.out.println(solution.rob(new int[]{
                  226,174,214,16,218,48,153,131,128,17,157,142,88,43,37,157,43,221,191,68,206,23,225,82,54,118,111,46,80,49,245,63,25,194,72,80,143,55,209,18,55,122,65,66,177,101,63,201,172,130,103,225,142,46,86,185,62,138,212,192,125,77,223,188,99,228,90,25,193,211,84,239,119,234,85,83,123,120,131,203,219,10,82,35,120,180,249,106,37,169,225,54,103,55,166,124
//            2,1,1,2
          }));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] rem = null;
    public int rob(int[] nums) {
        int length = nums.length;
        int[] recArray = new int[length];
        if (length >= 1) recArray[0] = nums[0];
        if (length == 2) return Math.max(nums[0], nums[1]);
        if (length >= 3) {
            recArray[1] = nums[1];
            for (int k = 2; k < length; k++) {
                recArray[k] = Math.max(recArray[k - 1], nums[k] + Math.max((k >= 3 ? recArray[k - 3] : 0), recArray[k - 2]));
            }
        }
        return recArray[length - 1];
/*        int length = nums.length;
        rem = new int[length];
        if (length >= 1) rem[0] = nums[0];
        if (length >= 2) {
            rem[1] = nums[1];
            if (length >= 3) rem[2] = nums[2] + nums[0];
            return Math.max(robHelper(nums, length - 1), robHelper(nums, length - 2));
        }
        return rem[0];*/
    }
/*    int robHelper(int[] nums, int mark){
        *//*if (mark >= nums.length) return 0;
        return nums[mark] + Math.max(robHelper(nums, mark + 2), robHelper(nums, mark + 3));*//*
        for (int i = 3; i < nums.length; i++) {
            rem[i] = nums[i] + Math.max(rem[i - 2], rem[i - 3]);
        }
        return rem[mark];
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

  }