import java.util.LinkedHashSet;

/**
You are given an integer array nums with the following properties: 

 
 nums.length == 2 * n. 
 nums contains n + 1 unique elements. 
 Exactly one element of nums is repeated n times. 
 

 Return the element that is repeated n times. 

 
 Example 1: 
 Input: nums = [1,2,3,3]
Output: 3
 Example 2: 
 Input: nums = [2,1,2,5,3,2]
Output: 2
 Example 3: 
 Input: nums = [5,1,5,2,5,3,5,4]
Output: 5
 
 
 Constraints: 

 
 2 <= n <= 5000 
 nums.length == 2 * n 
 0 <= nums[i] <= 10⁴ 
 nums contains n + 1 unique elements and one of them is repeated exactly n 
times. 
 
 Related Topics 数组 哈希表 👍 123 👎 0

*/

public class NRepeatedElementInSize2nArray{
    public static void main(String[] args) {
        Solution solution = new NRepeatedElementInSize2nArray().new Solution();
        System.out.println(solution.repeatedNTimes(new int[]{5, 1, 5, 2, 5, 3, 5, 4}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int repeatedNTimes(int[] nums) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        int ans = 0;
        for (int num : nums) {
            if (set.contains(num)) {
                ans = num;
                break;
            }
            set.add(num);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }