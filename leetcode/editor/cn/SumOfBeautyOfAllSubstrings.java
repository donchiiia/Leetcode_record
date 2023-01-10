  /**
The beauty of a string is the difference in frequencies between the most 
frequent and least frequent characters. 

 
 For example, the beauty of "abaacc" is 3 - 1 = 2. 
 

 Given a string s, return the sum of beauty of all of its substrings. 

 
 Example 1: 

 
Input: s = "aabcb"
Output: 5
Explanation: The substrings with non-zero beauty are ["aab","aabc","aabcb",
"abcb","bcb"], each with beauty equal to 1. 

 Example 2: 

 
Input: s = "aabcbaa"
Output: 17
 

 
 Constraints: 

 
 1 <= s.length <= 500 
 s consists of only lowercase English letters. 
 

 Related Topics 哈希表 字符串 计数 👍 32 👎 0

*/
  
  package editor.cn;

  import java.util.Arrays;
  import java.util.Collection;
  import java.util.HashMap;

  public class SumOfBeautyOfAllSubstrings{
      public static void main(String[] args) {
           Solution solution = new SumOfBeautyOfAllSubstrings().new Solution();
          System.out.println(solution.beautySum("aabcbaa"));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          public int beautySum(String s) {
              if (s.length() <= 2) return 0;
              int sum = 0;
              for (int i = 0; i < s.length(); i++) {
                  int[] alpha = new int[26];
                  int maxLength = 0;
                  for (int j = i; j < s.length(); j++) {
                      alpha[s.charAt(j) - 'a']++;
                      int minLength = s.length();
                      maxLength = Math.max(maxLength, alpha[s.charAt(j) - 'a']);
                      for (int k : alpha) {
                          if (k > 0) minLength = Math.min(minLength, k);
                      }
                      sum += (maxLength - minLength);
                  }
              }
              return sum;
          }
}
//leetcode submit region end(Prohibit modification and deletion)

  }