  /**
Your friend is typing his name into a keyboard. Sometimes, when typing a 
character c, the key might get long pressed, and the character will be typed 1 or more 
times. 

 You examine the typed characters of the keyboard. Return True if it is 
possible that it was your friends name, with some characters (possibly none) being long 
pressed. 

 
 Example 1: 

 
Input: name = "alex", typed = "aaleex"
Output: true
Explanation: 'a' and 'e' in 'alex' were long pressed.
 

 Example 2: 

 
Input: name = "saeed", typed = "ssaaedd"
Output: false
Explanation: 'e' must have been pressed twice, but it was not in the typed 
output.
 

 
 Constraints: 

 
 1 <= name.length, typed.length <= 1000 
 name and typed consist of only lowercase English letters. 
 
 Related Topics 双指针 字符串 👍 225 👎 0

*/
  
  public class LongPressedName{
      public static void main(String[] args) {
           Solution solution = new LongPressedName().new Solution();
          System.out.println(solution.isLongPressedName("a", "b"));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0, typedlength = typed.length(), namelength = name.length();
        char[] typedl = typed.toCharArray(), namel = name.toCharArray();
        if (namelength > typedlength) return false;
        while (i < namelength) {
            if (j < typedlength) {
                if (namel[i] == typedl[j]) {
                    i++;
                    j++;
                }
                else if (j >= 1 && typedl[j] == typedl[j - 1]) j++;
                else return false;
            }else return false;
        }
        while (j < typedlength) {
            if (typed.charAt(j) == typed.charAt(j - 1)) j++;
            else return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }