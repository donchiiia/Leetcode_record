package editor.cn;

/**
Given an integer n, return true if it is possible to represent n as the sum of 
distinct powers of three. Otherwise, return false. 

 An integer y is a power of three if there exists an integer x such that y == 3ˣ
. 

 
 Example 1: 

 
Input: n = 12
Output: true
Explanation: 12 = 3¹ + 3²
 

 Example 2: 

 
Input: n = 91
Output: true
Explanation: 91 = 3⁰ + 3² + 3⁴
 

 Example 3: 

 
Input: n = 21
Output: false
 

 
 Constraints: 

 
 1 <= n <= 10⁷ 
 

 Related Topics 数学 👍 76 👎 0

*/
public class CheckIfNumberIsASumOfPowersOfThree{
    public static void main(String[] args){
        Solution solution = new CheckIfNumberIsASumOfPowersOfThree().new Solution();
        System.out.println(solution.checkPowersOfThree(9));
    }
   
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkPowersOfThree(int n) {
        if (n == 1 || n ==3) return true;
        else if (n < 3) {
            return false;
        }

        int end = n % 3;
        if (end == 0) return checkPowersOfThree(n / 3);
        else if (end == 1) return checkPowersOfThree((n - 1) / 3);
        else return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}