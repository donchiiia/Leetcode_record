package editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
There are several squares being dropped onto the X-axis of a 2D plane. 

 You are given a 2D integer array positions where positions[i] = [lefti, 
sideLengthi] represents the iᵗʰ square with a side length of sideLengthi that is 
dropped with its left edge aligned with X-coordinate lefti. 

 Each square is dropped one at a time from a height above any landed squares. 
It then falls downward (negative Y direction) until it either lands on the top 
side of another square or on the X-axis. A square brushing the left/right side of 
another square does not count as landing on it. Once it lands, it freezes in 
place and cannot be moved. 

 After each square is dropped, you must record the height of the current 
tallest stack of squares. 

 Return an integer array ans where ans[i] represents the height described above 
after dropping the iᵗʰ square. 

 
 Example 1: 

 
Input: positions = [[1,2],[2,3],[6,1]]
Output: [2,5,5]
Explanation:
After the first drop, the tallest stack is square 1 with a height of 2.
After the second drop, the tallest stack is squares 1 and 2 with a height of 5.
After the third drop, the tallest stack is still squares 1 and 2 with a height 
of 5.
Thus, we return an answer of [2, 5, 5].
 

 Example 2: 

 
Input: positions = [[100,100],[200,100]]
Output: [100,100]
Explanation:
After the first drop, the tallest stack is square 1 with a height of 100.
After the second drop, the tallest stack is either square 1 or square 2, both 
with heights of 100.
Thus, we return an answer of [100, 100].
Note that square 2 only brushes the right side of square 1, which does not 
count as landing on it.
 

 
 Constraints: 

 
 1 <= positions.length <= 1000 
 1 <= lefti <= 10⁸ 
 1 <= sideLengthi <= 10⁶ 
 
 Related Topics 线段树 数组 有序集合 👍 150 👎 0

*/

public class FallingSquares{
    public static void main(String[] args) {
        Solution solution = new FallingSquares().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> fallingSquares(int[][] positions) {
            int n = positions.length;
            List<Integer> heights = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                int left1 = positions[i][0], right1 = positions[i][0] + positions[i][1] - 1;
                int height = positions[i][1];
                for (int j = 0; j < i; j++) {
                    int left2 = positions[j][0], right2 = positions[j][0] + positions[j][1] - 1;
                    if (right1 >= left2 && right2 >= left1) {
                        height = Math.max(height, heights.get(j) + positions[i][1]);
                    }
                }
                heights.add(height);
            }
            for (int i = 1; i < n; i++) {
                heights.set(i, Math.max(heights.get(i), heights.get(i - 1)));
            }
            return heights;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

  }