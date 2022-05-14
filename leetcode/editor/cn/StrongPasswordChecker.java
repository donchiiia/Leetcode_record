import java.util.HashMap;
import java.util.Stack;

/**
A password is considered strong if the below conditions are all met: 

 
 It has at least 6 characters and at most 20 characters. 
 It contains at least one lowercase letter, at least one uppercase letter, and 
at least one digit. 
 It does not contain three repeating characters in a row (i.e., "...aaa..." is 
weak, but "...aa...a..." is strong, assuming other conditions are met). 
 

 Given a string password, return the minimum number of steps required to make 
password strong. if password is already strong, return 0. 

 In one step, you can: 

 
 Insert one character to password, 
 Delete one character from password, or 
 Replace one character of password with another character. 
 

 
 Example 1: 
 Input: password = "a"
Output: 5
 Example 2: 
 Input: password = "aA1"
Output: 3
 Example 3: 
 Input: password = "1337C0d3"
Output: 0
 
 
 Constraints: 

 
 1 <= password.length <= 50 
 password consists of letters, digits, dot '.' or exclamation mark '!'. 
 
 Related Topics 贪心 字符串 堆（优先队列） 👍 135 👎 0

*/
  
  public class StrongPasswordChecker{
      public static void main(String[] args) {
           Solution solution = new StrongPasswordChecker().new Solution();
          System.out.println(solution.strongPasswordChecker("aaa123"));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strongPasswordChecker(String password) {
        int length = password.length(), changNum = 0, numsTag = 0;
        boolean numTag = false, lowCharTag = false, UpperCharTag = false;
        Stack<Character> s = new Stack<>();

        if (length < 6) return 6 - length;
        for (int i = 0; i < length; i++) {
            char c = password.charAt(i);
            if (!numTag && c >= '0' && c <= '9') numTag = true;
            if (!lowCharTag && c >='a' && c <= 'z') lowCharTag = true;
            if (!UpperCharTag && c >= 'A' && c <= 'Z') UpperCharTag = true;
            if (s.isEmpty() || s.peek() == c) {
                s.push(c);
            } else {
                while (!s.isEmpty()) {
                    s.pop();
                    numsTag++;
                }
                s.push(c);
                changNum += (numsTag > 2 ? numsTag - 2 : 0);
                numsTag = 0;
            }
        }
        while (!s.isEmpty()) {
            s.pop();
            numsTag++;
        }
        changNum += (numsTag > 2 ? numsTag - 2 : 0);

        if (changNum <= 1){
            if (!numTag) changNum++;
            if (!lowCharTag) changNum++;
            if (!UpperCharTag) changNum++;
            if (changNum > 0 && changNum <= 3) changNum--;
            if (length > 20 && length - 20 > changNum) changNum += (length - 20);
        }
        return changNum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }