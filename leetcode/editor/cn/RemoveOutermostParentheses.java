import java.util.LinkedList;
import java.util.Stack;

/**
A valid parentheses string is either empty "", "(" + A + ")", or A + B, where A 
and B are valid parentheses strings, and + represents string concatenation. 

 
 For example, "", "()", "(())()", and "(()(()))" are all valid parentheses 
strings. 
 

 A valid parentheses string s is primitive if it is nonempty, and there does 
not exist a way to split it into s = A + B, with A and B nonempty valid 
parentheses strings. 

 Given a valid parentheses string s, consider its primitive decomposition: s = 
P1 + P2 + ... + Pk, where Pi are primitive valid parentheses strings. 

 Return s after removing the outermost parentheses of every primitive string in 
the primitive decomposition of s. 

 
 Example 1: 

 
Input: s = "(()())(())"
Output: "()()()"
Explanation: 
The input string is "(()())(())", with primitive decomposition "(()())" + "(())
".
After removing outer parentheses of each part, this is "()()" + "()" = "()()()".

 

 Example 2: 

 
Input: s = "(()())(())(()(()))"
Output: "()()()()(())"
Explanation: 
The input string is "(()())(())(()(()))", with primitive decomposition "(()())" 
+ "(())" + "(()(()))".
After removing outer parentheses of each part, this is "()()" + "()" + "()(())" 
= "()()()()(())".
 

 Example 3: 

 
Input: s = "()()"
Output: ""
Explanation: 
The input string is "()()", with primitive decomposition "()" + "()".
After removing outer parentheses of each part, this is "" + "" = "".
 

 
 Constraints: 

 
 1 <= s.length <= 10⁵ 
 s[i] is either '(' or ')'. 
 s is a valid parentheses string. 
 
 Related Topics 栈 字符串 👍 223 👎 0

*/

public class RemoveOutermostParentheses{
    public static void main(String[] args) {
        Solution solution = new RemoveOutermostParentheses().new Solution();
        System.out.println(solution.removeOuterParentheses("(()())(())(()(()))"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public String removeOuterParentheses(String s) {
            int left = 0;
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(' && left++ > 0) stringBuffer.append('(');
                if (s.charAt(i) == ')' && --left > 0) stringBuffer.append(')');
            }
            return stringBuffer.toString();
        }
}
//leetcode submit region end(Prohibit modification and deletion)

  }