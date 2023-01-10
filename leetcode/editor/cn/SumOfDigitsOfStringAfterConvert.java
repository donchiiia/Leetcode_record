/**
You are given a string s consisting of lowercase English letters, and an 
integer k. 

 First, convert s into an integer by replacing each letter with its position in 
the alphabet (i.e., replace 'a' with 1, 'b' with 2, ..., 'z' with 26). Then, 
transform the integer by replacing it with the sum of its digits. Repeat the 
transform operation k times in total. 

 For example, if s = "zbax" and k = 2, then the resulting integer would be 8 by 
the following operations: 

 
 Convert: "zbax" ➝ "(26)(2)(1)(24)" ➝ "262124" ➝ 262124 
 Transform #1: 262124 ➝ 2 + 6 + 2 + 1 + 2 + 4 ➝ 17 
 Transform #2: 17 ➝ 1 + 7 ➝ 8 
 

 Return the resulting integer after performing the operations described above. 

 
 Example 1: 

 
Input: s = "iiii", k = 1
Output: 36
Explanation: The operations are as follows:
- Convert: "iiii" ➝ "(9)(9)(9)(9)" ➝ "9999" ➝ 9999
- Transform #1: 9999 ➝ 9 + 9 + 9 + 9 ➝ 36
Thus the resulting integer is 36.
 

 Example 2: 

 
Input: s = "leetcode", k = 2
Output: 6
Explanation: The operations are as follows:
- Convert: "leetcode" ➝ "(12)(5)(5)(20)(3)(15)(4)(5)" ➝ "12552031545" ➝ 12552031
545
- Transform #1: 12552031545 ➝ 1 + 2 + 5 + 5 + 2 + 0 + 3 + 1 + 5 + 4 + 5 ➝ 33
- Transform #2: 33 ➝ 3 + 3 ➝ 6
Thus the resulting integer is 6.
 

 Example 3: 

 
Input: s = "zbax", k = 2
Output: 8
 

 
 Constraints: 

 
 1 <= s.length <= 100 
 1 <= k <= 10 
 s consists of lowercase English letters. 
 

 Related Topics 字符串 模拟 👍 34 👎 0

*/

package editor.cn;

import java.math.BigInteger;

public class SumOfDigitsOfStringAfterConvert{
    public static void main(String[] args) {
        Solution solution = new SumOfDigitsOfStringAfterConvert().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getLucky(String s, int k) {
        StringBuffer stringBuffer = new StringBuffer();
        for (char c : s.toCharArray()) {
            stringBuffer.append(c - 'a' + 1);
        }
        String res = stringBuffer.toString();
        while (k > 0) {
            int sum = 0;
            for (int i = 0; i < res.length(); i++) {
                sum += res.charAt(i) - '0';
            }
            res = Integer.toString(sum);
            k--;
        }
        return Integer.parseInt(res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}