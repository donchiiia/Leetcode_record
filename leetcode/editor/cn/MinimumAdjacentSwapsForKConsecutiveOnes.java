/**
You are given an integer array, nums, and an integer k. nums comprises of only 0
's and 1's. In one move, you can choose two adjacent indices and swap their 
values. 

 Return the minimum number of moves required so that nums has k consecutive 1's.
 

 
 Example 1: 

 
Input: nums = [1,0,0,1,0,1], k = 2
Output: 1
Explanation: In 1 move, nums could be [1,0,0,0,1,1] and have 2 consecutive 1's.
 

 Example 2: 

 
Input: nums = [1,0,0,0,0,0,1,1], k = 3
Output: 5
Explanation: In 5 moves, the leftmost 1 can be shifted right until nums = [0,0,0
,0,0,1,1,1].
 

 Example 3: 

 
Input: nums = [1,1,0,1], k = 2
Output: 0
Explanation: nums already has 2 consecutive 1's.
 

 
 Constraints: 

 
 1 <= nums.length <= 10⁵ 
 nums[i] is 0 or 1. 
 1 <= k <= sum(nums) 
 

 Related Topics 贪心 数组 前缀和 滑动窗口 👍 99 👎 0

*/

package editor.cn;

import javax.management.remote.rmi.RMIConnectionImpl;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MinimumAdjacentSwapsForKConsecutiveOnes{
    public static void main(String[] args) {
        Solution solution = new MinimumAdjacentSwapsForKConsecutiveOnes().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minMoves(int[] nums, int k) {
        List<Integer> zeros = new ArrayList<Integer>();
        int count = 0, count1 = 0;
        for (int num : nums) {
            if (num == 0) {
                count++;
            } else {
                if (count1 != 0) zeros.add(count);
                count1++;
                count = 0;
            }
        }

        int[] preSum = new int[zeros.size() + 1];
        for (int i = 0; i < zeros.size(); i++) {
            preSum[i + 1] = preSum[i] + zeros.get(i);
        }

        int cost = 0;
        int left = 0, right = k - 2;

        // 生成第一个窗口
        for (int i = left; i <= right; i++) {
            cost += zeros.get(i) * (Math.min(i + 1, right - i + 1));
        }

        int minCost = cost;
        for (int i = 1, j = i + k - 2; j < zeros.size(); i++, j++) {
            int mid = (i + j) / 2;
            cost -= preSum[mid] - preSum[i - 1];
            cost += preSum[j + 1] - preSum[mid + k % 2];
            minCost = Math.min(minCost, cost);
        }
        return minCost;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}