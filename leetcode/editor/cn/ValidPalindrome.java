import java.io.CharArrayReader;

/**
A phrase is a palindrome if, after converting all uppercase letters into 
lowercase letters and removing all non-alphanumeric characters, it reads the same 
forward and backward. Alphanumeric characters include letters and numbers. 

 Given a string s, return true if it is a palindrome, or false otherwise. 

 
 Example 1: 

 
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
 

 Example 2: 

 
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
 

 Example 3: 

 
Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.

Since an empty string reads the same forward and backward, it is a palindrome.
 

 
 Constraints: 

 
 1 <= s.length <= 2 * 10⁵ 
 s consists only of printable ASCII characters. 
 
 Related Topics 双指针 字符串 👍 497 👎 0

*/
  
  public class ValidPalindrome{
      public static void main(String[] args) {
           Solution solution = new ValidPalindrome().new Solution();
          System.out.println(solution.isPalindrome("race a car"));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < s.length() && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while (j >= 0 && !Character.isLetterOrDigit(s.charAt(j))) j--;
            if (i >= s.length() || j < 0 || i >= j) continue;
            char a = (char) (s.charAt(i) & 0b11011111), b = (char) (s.charAt(j) & 0b11011111);
            if (a == b) {
                i++; j--;
            } else return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }