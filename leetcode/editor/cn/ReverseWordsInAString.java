package editor.cn;

/**
Given an input string s, reverse the order of the words. 

 A word is defined as a sequence of non-space characters. The words in s will 
be separated by at least one space. 

 Return a string of the words in reverse order concatenated by a single space. 

 Note that s may contain leading or trailing spaces or multiple spaces between 
two words. The returned string should only have a single space separating the 
words. Do not include any extra spaces. 

 
 Example 1: 

 
Input: s = "the sky is blue"
Output: "blue is sky the"
 

 Example 2: 

 
Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.

 

 Example 3: 

 
Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single 
space in the reversed string.
 

 
 Constraints: 

 
 1 <= s.length <= 10⁴ 
 s contains English letters (upper-case and lower-case), digits, and spaces ' '.
 
 There is at least one word in s. 
 

 
 Follow-up: If the string data type is mutable in your language, can you solve 
it in-place with O(1) extra space? 
 Related Topics 双指针 字符串 👍 490 👎 0

*/
  
  public class ReverseWordsInAString{
      public static void main(String[] args) {
           Solution solution = new ReverseWordsInAString().new Solution();
          System.out.println(solution.reverseWords("  hello  a new world "));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0, j = s.length() - 1;

        while (s.charAt(i) == ' ') i++;
        while (s.charAt(j) == ' ') j--;
        while (j >= i) {
            int index = j;
            while (index >= i && s.charAt(index) != ' ') index--;
            stringBuffer.append(s.substring(index + 1, j + 1));
            if (index > i)stringBuffer.append(' ');
            while (index >= i && s.charAt(index) == ' ') index--;
            j = index;
        }
        return stringBuffer.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }