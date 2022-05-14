import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
Given a string s, you can transform every letter individually to be lowercase 
or uppercase to create another string. 

 Return a list of all possible strings we could create. Return the output in 
any order. 

 
 Example 1: 

 
Input: s = "a1b2"
Output: ["a1b2","a1B2","A1b2","A1B2"]
 

 Example 2: 

 
Input: s = "3z4"
Output: ["3z4","3Z4"]
 

 
 Constraints: 

 
 1 <= s.length <= 12 
 s consists of lowercase English letters, uppercase English letters, and digits.
 
 
 Related Topics 位运算 字符串 回溯 👍 369 👎 0

*/
  
  public class LetterCasePermutation{
      public static void main(String[] args) {
           Solution solution = new LetterCasePermutation().new Solution();
          System.out.println(solution.letterCasePermutation("a1b2"));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> lists = new ArrayList<>();
    int dis = 'a' - 'A';

    public List<String> letterCasePermutation(String s) {
        if (s.length() == 0) return lists;
        char[] rec = s.toCharArray();
        backTracking(rec, 0);
        return lists;
    }
    private void backTracking(char[] s, int startIndex){
        lists.add(String.valueOf(s));
        for (int i = startIndex; i < s.length; i++) {
            if (s[i] >= '0' && s[i] <= '9') continue;
            else if (s[i] >= 'a' && s[i] <= 'z') {
                s[i] = (char) (s[i] - dis);
                backTracking(s, i + 1);
                s[i] = (char) (s[i] + dis);
            } else {
                s[i] = (char) (s[i] + dis);
                backTracking(s, i + 1);
                s[i] = (char) (s[i] - dis);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }