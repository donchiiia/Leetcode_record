import java.io.CharArrayReader;
import java.util.HashSet;

/**
A string is good if there are no repeated characters. 

 Given a string s, return the number of good substrings of length three in s. 

 Note that if there are multiple occurrences of the same substring, every 
occurrence should be counted. 

 A substring is a contiguous sequence of characters in a string. 

 
 Example 1: 

 
Input: s = "xyzzaz"
Output: 1
Explanation: There are 4 substrings of size 3: "xyz", "yzz", "zza", and "zaz". 
The only good substring of length 3 is "xyz".
 

 Example 2: 

 
Input: s = "aababcabc"
Output: 4
Explanation: There are 7 substrings of size 3: "aab", "aba", "bab", "abc", 
"bca", "cab", and "abc".
The good substrings are "abc", "bca", "cab", and "abc".
 

 
 Constraints: 

 
 1 <= s.length <= 100 
 s consists of lowercase English letters. 
 
 Related Topics 哈希表 字符串 计数 滑动窗口 👍 15 👎 0

*/
  
  public class SubstringsOfSizeThreeWithDistinctCharacters{
      public static void main(String[] args) {
           Solution solution = new SubstringsOfSizeThreeWithDistinctCharacters().new Solution();
          System.out.println(solution.countGoodSubstrings("aababcabc"));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countGoodSubstrings(String s) {
        int[] rec = new int[26];
        int i = 0, j = 0, count = 0;
        while (i <= s.length() - 3) {
            while (j < i + 3 && rec[s.charAt(j) - 'a'] == 0) {
                rec[s.charAt(j) - 'a']++;
                j++;
            }
            if (j == i + 3) count++;
            rec[s.charAt(i) - 'a']--;
            i++;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }