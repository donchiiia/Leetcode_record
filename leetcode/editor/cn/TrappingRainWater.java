package editor.cn;

/**
Given n non-negative integers representing an elevation map where the width of 
each bar is 1, compute how much water it can trap after raining. 

 
 Example 1: 

 
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,
1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are 
being trapped.
 

 Example 2: 

 
Input: height = [4,2,0,3,2,5]
Output: 9
 

 
 Constraints: 

 
 n == height.length 
 1 <= n <= 2 * 10⁴ 
 0 <= height[i] <= 10⁵ 
 
 Related Topics 栈 数组 双指针 动态规划 单调栈 👍 3258 👎 0

*/
  
  public class TrappingRainWater{
      public static void main(String[] args) {
           Solution solution = new TrappingRainWater().new Solution();
          System.out.println(solution.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        int i = 0, ir = i, j = height.length - 1, jr = j, sum = 0;

        ir = i + 1; jr = j - 1;
        for (int count = 0; count < height.length && ir <= jr; count++) {
            if (height[i] <= height[j]) {
                if (ir < height.length && height[ir] < height[i]) {
                    sum += (height[i] - height[ir]);
                } else {
                    i = ir;
                }
                ir++;
            } else {
                if (jr >= 0 && height[jr] < height[j]) {
                    sum += (height[j] - height[jr]);
                } else {
                    j = jr;
                }
                jr--;
            }
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }

  /*        int i = 0, j = 0,sum = 0;
        Stack<Integer> rec = new Stack<>();

        for (j = i + 1; j < height.length; j++) {
            if (height[j] < height[i]) {
                rec.push(height[i] - height[j]);
            } else {
                i = j;
            }
        }
        if (i != height.length - 1) {
            while (--j > i) {
                rec.pop();}
            j = height.length - 1;
            for (int k = height.length - 2; k > i; k--) {
                if (height[k] < height[j]) {
                    rec.push(height[j] - height[k]);
                } else {
                    j = k;
                }
            }

        }
        while (!rec.isEmpty()) {
            sum += rec.pop();
        }

        return sum;*/