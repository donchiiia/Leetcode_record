import javax.security.auth.login.AccountNotFoundException;
import java.util.*;

/**
Given a string s, find the length of the longest substring without repeating 
characters. 

 
 Example 1: 

 
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
 

 Example 2: 

 
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
 

 Example 3: 

 
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a 
substring.
 

 
 Constraints: 

 
 0 <= s.length <= 5 * 10⁴ 
 s consists of English letters, digits, symbols and spaces. 
 
 Related Topics 哈希表 字符串 滑动窗口 👍 7175 👎 0

*/
  
  public class LongestSubstringWithoutRepeatingCharacters{
      public static void main(String[] args) {
           Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
          String s = new String("dvdf" );
          System.out.println(solution.lengthOfLongestSubstring(s));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Queue<Character> q = new ArrayDeque<>();
        int count = 0, max = 0;

        for (char c : s.toCharArray()) {
            if (!q.contains(c)) {
                q.add(c);
                count++;
            } else {
                q.add(c);
                while (q.remove() != c) count--;
            }
            max = max > count ? max : count;
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
  /* char[] res = s.toCharArray();
        HashSet<Character> rem = new HashSet<>();
        int i = 0, j = 0, longest = 0;

        if (s.length() <= 1) return s.length();
        for (; i < res.length; i++) {
            if (i != 0) {
                rem.remove(res[i - 1]);
0            }****
            while (j < res.length && !rem.contains(res[j])) {
                rem.add(res[j++]);
            }
            longest = Math.max(longest, j - i);
        }
        return longest;*/