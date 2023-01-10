package editor.cn;

/**
A message containing letters from A-Z can be encoded into numbers using the 
following mapping: 

 
'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
 

 To decode an encoded message, all the digits must be grouped then mapped back 
into letters using the reverse of the mapping above (there may be multiple ways).
 For example, "11106" can be mapped into: 

 
 "AAJF" with the grouping (1 1 10 6) 
 "KJF" with the grouping (11 10 6) 
 

 Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 
'F' since "6" is different from "06". 

 Given a string s containing only digits, return the number of ways to decode 
it. 

 The test cases are generated so that the answer fits in a 32-bit integer. 

 
 Example 1: 

 
Input: s = "12"
Output: 2
Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
 

 Example 2: 

 
Input: s = "226"
Output: 3
Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6
).
 

 Example 3: 

 
Input: s = "06"
Output: 0
Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is 
different from "06").
 

 
 Constraints: 

 
 1 <= s.length <= 100 
 s contains only digits and may contain leading zero(s). 
 
 Related Topics 字符串 动态规划 👍 1157 👎 0

*/
  
  public class DecodeWays{
      public static void main(String[] args) {
           Solution solution = new DecodeWays().new Solution();
          System.out.println(solution.numDecodings("1201234"));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDecodings(String s) {
        int fi1 = 1, fi2 = 0, fi = 0;
        int length = s.length();
        for (int k = 1; k <= length; k++) {
            fi = 0;
            if (s.charAt(k - 1) != '0') fi += fi1;
            if (k > 1 && s.charAt(k - 2) != '0' && ((s.charAt(k - 2) - '0') * 10 +
                    (s.charAt(k - 1) - '0')) <= 26) fi += fi2;
            fi2 = fi1;
            fi1 = fi;
        }
        return fi;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }