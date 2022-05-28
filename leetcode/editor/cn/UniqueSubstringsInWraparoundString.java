import java.util.Arrays;

/**
We define the string s to be the infinite wraparound string of 
"abcdefghijklmnopqrstuvwxyz", so s will look like this: 

 
 "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....". 
 

 Given a string p, return the number of unique non-empty substrings of p are 
present in s. 

 
 Example 1: 

 
Input: p = "a"
Output: 1
Explanation: Only the substring "a" of p is in s.
 

 Example 2: 

 
Input: p = "cac"
Output: 2
Explanation: There are two substrings ("a", "c") of p in s.
 

 Example 3: 

 
Input: p = "zab"
Output: 6
Explanation: There are six substrings ("z", "a", "b", "za", "ab", and "zab") of 
p in s.
 

 
 Constraints: 

 
 1 <= p.length <= 10⁵ 
 p consists of lowercase English letters. 
 
 Related Topics 字符串 动态规划 👍 282 👎 0

*/

public class UniqueSubstringsInWraparoundString{
    public static void main(String[] args) {
        Solution solution = new UniqueSubstringsInWraparoundString().new Solution();
        System.out.println(solution.findSubstringInWraproundString("zab"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findSubstringInWraproundString(String p) {
        int[] dp = new int[26];
        int k = 0;
        for (int i = 0; i < p.length(); i++) {
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) + 26) % 26 == 1) {
                k++;
            }else k = 1;
            dp[p.charAt(i) - 'a'] = Math.max(k, dp[p.charAt(i) - 'a']);
        }
        return Arrays.stream(dp).sum();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }