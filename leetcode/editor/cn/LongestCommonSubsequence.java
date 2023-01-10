package editor.cn;

/**
Given two strings text1 and text2, return the length of their longest common 
subsequence. If there is no common subsequence, return 0. 

 A subsequence of a string is a new string generated from the original string 
with some characters (can be none) deleted without changing the relative order of 
the remaining characters. 

 
 For example, "ace" is a subsequence of "abcde". 
 

 A common subsequence of two strings is a subsequence that is common to both 
strings. 

 
 Example 1: 

 
Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
 

 Example 2: 

 
Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
 

 Example 3: 

 
Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
 

 
 Constraints: 

 
 1 <= text1.length, text2.length <= 1000 
 text1 and text2 consist of only lowercase English characters. 
 
 Related Topics 字符串 动态规划 👍 942 👎 0

*/
  
  public class LongestCommonSubsequence{
      public static void main(String[] args) {
           Solution solution = new LongestCommonSubsequence().new Solution();
          System.out.println(solution.longestCommonSubsequence("abcde", "ace"));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        //一维dp
/*        int[] dp = new int[text1.length() + 1];
        int rec = 0;
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = text2.length() - 1; j >= 0; j--) {

            }
        }*/


        //二维dp
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            char temp1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char temp2 = text2.charAt(j - 1);
                if (temp1 == temp2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }