package editor.cn;

/**
There are three types of edits that can be performed on strings: insert a 
character, remove a character, or replace a character. Given two strings, write a 
function to check if they are one edit (or zero edits) away. 

 

 Example 1: 

 
Input: 
first = "pale"
second = "ple"
Output: True
 

 Example 2: 

 
Input: 
first = "pales"
second = "pal"
Output: False
 
 Related Topics 双指针 字符串 👍 161 👎 0

*/
  
  public class OneAwayLcci{
      public static void main(String[] args) {
           Solution solution = new OneAwayLcci().new Solution();
          System.out.println(solution.oneEditAway("", ""));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean oneEditAway(String first, String second) {
        int fl = 0, sl = 0, fr = first.length() - 1, sr = second.length() - 1;
        if (Math.abs(fr - sr) >= 2 || fr == -1 && sr == -1) return false;
        while (true) {
            if (first.charAt(fl) == second.charAt(sl)) {
                fl++;
                sl++;
            } else if (first.charAt(fr) == second.charAt(sr)) {
                fr--;
                sr--;
            }else break;
        }
        return Math.abs((fr - fl) + (sr - sl)) <= 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }