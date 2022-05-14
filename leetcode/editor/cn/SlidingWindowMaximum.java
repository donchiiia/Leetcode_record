import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
You are given an array of integers nums, there is a sliding window of size k 
which is moving from the very left of the array to the very right. You can only 
see the k numbers in the window. Each time the sliding window moves right by one 
position. 

 Return the max sliding window. 

 
 Example 1: 

 
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 

 Example 2: 

 
Input: nums = [1], k = 1
Output: [1]
 

 
 Constraints: 

 
 1 <= nums.length <= 10⁵ 
 -10⁴ <= nums[i] <= 10⁴ 
 1 <= k <= nums.length 
 
 Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 👍 1480 👎 0

*/
  
  public class SlidingWindowMaximum{
      public static void main(String[] args) {
           Solution solution = new SlidingWindowMaximum().new Solution();
          int[] res = {1, 3, -1, -3, 5, 3, 6, 7};
          int[] aim = solution.maxSlidingWindow(res, 3);
          for (int x :
                  aim) {
              System.out.print(x + " ");
          }
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>(k);
        int[] res = new int[nums.length - k + 1];
        int num = 0;

        if (res.length == 1) return nums;
        for (int i = 0; i < k; i++) {
            deque.add(nums[i]);
        }
        for (int i = k; i < res.length; i++) {
            while (!deque.isEmpty() && nums[i - k] == deque.peek()) {
                deque.poll();
            }
            while (!deque.isEmpty() && nums[i] > deque.getLast()) {
                deque.removeLast();
            }
            deque.add(nums[i]);
            res[num++] = deque.peek();
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }