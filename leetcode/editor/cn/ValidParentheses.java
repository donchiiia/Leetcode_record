package editor.cn;

import java.util.Stack;

/**
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 determine if the input string is valid. 

 An input string is valid if: 

 
 Open brackets must be closed by the same type of brackets. 
 Open brackets must be closed in the correct order. 
 

 
 Example 1: 

 
Input: s = "()"
Output: true
 

 Example 2: 

 
Input: s = "()[]{}"
Output: true
 

 Example 3: 

 
Input: s = "(]"
Output: false
 

 
 Constraints: 

 
 1 <= s.length <= 10⁴ 
 s consists of parentheses only '()[]{}'. 
 
 Related Topics 栈 字符串 👍 3100 👎 0

*/
  
  public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        System.out.println(solution.isValid(new String("()")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            if (s == null) return false;
            Stack<Character> res = new Stack<>();
            for (char c :
                    s.toCharArray()) {
                if (c == '(') res.push(')');
                else if (c == '[') res.push(']');
                else if (c == '{') res.push('}');
                else if (res.isEmpty() || c != res.pop()) return false;
            }
            return res.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}