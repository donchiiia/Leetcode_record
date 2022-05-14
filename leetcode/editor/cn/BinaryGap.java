  /**
Given a positive integer n, find and return the longest distance between any 
two adjacent 1's in the binary representation of n. If there are no two adjacent 1
's, return 0. 

 Two 1's are adjacent if there are only 0's separating them (possibly no 0's). 
The distance between two 1's is the absolute difference between their bit 
positions. For example, the two 1's in "1001" have a distance of 3. 

 
 Example 1: 

 
Input: n = 22
Output: 2
Explanation: 22 in binary is "10110".
The first adjacent pair of 1's is "10110" with a distance of 2.
The second adjacent pair of 1's is "10110" with a distance of 1.
The answer is the largest of these two distances, which is 2.
Note that "10110" is not a valid pair since there is a 1 separating the two 1's 
underlined.
 

 Example 2: 

 
Input: n = 8
Output: 0
Explanation: 8 in binary is "1000".
There are not any adjacent pairs of 1's in the binary representation of 8, so 
we return 0.
 

 Example 3: 

 
Input: n = 5
Output: 2
Explanation: 5 in binary is "101".
 

 
 Constraints: 

 
 1 <= n <= 10⁹ 
 
 Related Topics 位运算 数学 👍 99 👎 0

*/
  
  public class BinaryGap{
      public static void main(String[] args) {
           Solution solution = new BinaryGap().new Solution();
          System.out.println(solution.binaryGap(8));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int binaryGap(int n) {
        int[] rec = new int[]{-1, -1};
        int times = 0, max = 0;
        while (n != 0) {
            times++;
            int judge = 1;
            if ((judge & n) == 1) {
                if (rec[0] == -1) {
                    rec[0] = times;
                } else if (rec[1] == -1) {
                    rec[1] = times;
                    max = Math.max(max, times - rec[0]);
                } else {
                    rec[0] = rec[1];
                    rec[1] = times;
                    max = Math.max(max, times - rec[0]);
                }
            }
            n >>>= 1;
        }
        return rec[0] != -1 && rec[1] != -1 ? max : 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }