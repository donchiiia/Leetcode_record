package editor.cn;

/**
Given an integer n, return the number of ways you can write n as the sum of 
consecutive positive integers. 

 
 Example 1: 

 
Input: n = 5
Output: 2
Explanation: 5 = 2 + 3
 

 Example 2: 

 
Input: n = 9
Output: 3
Explanation: 9 = 4 + 5 = 2 + 3 + 4
 

 Example 3: 

 
Input: n = 15
Output: 4
Explanation: 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5
 

 
 Constraints: 

 
 1 <= n <= 10⁹ 
 
 Related Topics 数学 枚举 👍 161 👎 0

*/

public class ConsecutiveNumbersSum{
    public static void main(String[] args) {
        Solution solution = new ConsecutiveNumbersSum().new Solution();
        System.out.println(solution.consecutiveNumbersSum(15));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int consecutiveNumbersSum(int n) {
        int sum = 0, nF = 0;
        for (int i = 1; nF + i <= n; i++) {
            nF += i;
            if ((n - nF) % i == 0) sum++;
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }