package editor.cn;

import java.util.List;

/**
Given a string s and a dictionary of strings wordDict, return true if s can be 
segmented into a space-separated sequence of one or more dictionary words. 

 Note that the same word in the dictionary may be reused multiple times in the 
segmentation. 

 
 Example 1: 

 
Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
 

 Example 2: 

 
Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen 
apple".
Note that you are allowed to reuse a dictionary word.
 

 Example 3: 

 
Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false
 

 
 Constraints: 

 
 1 <= s.length <= 300 
 1 <= wordDict.length <= 1000 
 1 <= wordDict[i].length <= 20 
 s and wordDict[i] consist of only lowercase English letters. 
 All the strings of wordDict are unique. 
 
 Related Topics 字典树 记忆化搜索 哈希表 字符串 动态规划 👍 1542 👎 0

*/
  
  public class WordBreak{
      public static void main(String[] args) {
           Solution solution = new WordBreak().new Solution();
//          System.out.println(solution.wordBreak());
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] judge = new boolean[s.length() + 1];
        judge[0] = true;
        for (int Len = 1; Len <= judge.length; Len++) {
            for (int i = 0; i < Len; i++) {
                if (judge[i] && wordDict.contains(s.substring(i, Len))) {
                    judge[Len] = true;
                    break;
                }
            }
        }
        return judge[s.length()];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }