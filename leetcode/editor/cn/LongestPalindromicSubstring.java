package editor.cn;

/**
Given a string s, return the longest palindromic substring in s. 

 
 Example 1: 

 
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
 

 Example 2: 

 
Input: s = "cbbd"
Output: "bb"
 

 
 Constraints: 

 
 1 <= s.length <= 1000 
 s consist of only digits and English letters. 
 
 Related Topics 字符串 动态规划 👍 5072 👎 0

*/
  
  public class LongestPalindromicSubstring{
      public static void main(String[] args) {
           Solution solution = new LongestPalindromicSubstring().new Solution();
          System.out.println(solution.longestPalindrome("cbbd"));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        if (length == 2 && s.charAt(0) == s.charAt(1)) return s;
        else if (length == 1|| length == 2) return s.substring(0, 1);

        int start = 0, maxLen = 1;
        boolean[][] judgeArray = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            judgeArray[i][i] = true;
        }
        //循环字串长度，从2开始到length
        for (int L = 2; L <= length; L++) {
            for (int i = 0; i < length; i++) {
                int end = L + i - 1;    //对从0开始的字串L长度的边界限定
                //如果越界则退出当前循环
                if (end >= length) break;
                //如果L长度的字串的首和尾位置的字符不相同意味着从第i开始到end的字串不符合要求
                if (s.charAt(i) != s.charAt(end)) {
                    judgeArray[i][end] = false;
                } else {
                    //如果i和end位置的字符相等，且i和end围成的字串长度小于等于3，则这些位置上开始的i都是回文串
                    if (end - i < 3) judgeArray[i][end] = true;
                    else judgeArray[i][end] = judgeArray[i + 1][end - 1];
                }
                //记录最长字串
                if (judgeArray[i][end] && end - i + 1 > maxLen) {
                    start = i;
                    maxLen = end - i + 1;
                }
            }
        }
        return s.substring(start, start + maxLen);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }