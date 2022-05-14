import java.util.ArrayList;
import java.util.List;

/**
Given an integer array nums of length n where all the integers of nums are in 
the range [1, n] and each integer appears once or twice, return an array of all 
the integers that appears twice. 

 You must write an algorithm that runs in O(n) time and uses only constant 
extra space. 

 
 Example 1: 
 Input: nums = [4,3,2,7,8,2,3,1]
Output: [2,3]
 Example 2: 
 Input: nums = [1,1,2]
Output: [1]
 Example 3: 
 Input: nums = [1]
Output: []
 
 
 Constraints: 

 
 n == nums.length 
 1 <= n <= 10⁵ 
 1 <= nums[i] <= n 
 Each element in nums appears once or twice. 
 
 Related Topics 数组 哈希表 👍 527 👎 0

*/
  
  public class FindAllDuplicatesInAnArray{
      public static void main(String[] args) {
           Solution solution = new FindAllDuplicatesInAnArray().new Solution();
          System.out.println(solution.findDuplicates(new int[]{4,3,2,7,8,2,3,1}));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int temp = Math.abs(nums[i]);
            if (nums[temp - 1] > 0) {
                nums[temp - 1] *= -1;
            } else list.add(temp);
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }