package editor.cn;

/**
Given two strings s and t, return true if they are equal when both are typed 
into empty text editors. '#' means a backspace character. 

 Note that after backspacing an empty text, the text will continue empty. 

 
 Example 1: 

 
Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".
 

 Example 2: 

 
Input: s = "ab##", t = "c#d#"
Output: true
Explanation: Both s and t become "".
 

 Example 3: 

 
Input: s = "a#c", t = "b"
Output: false
Explanation: s becomes "c" while t becomes "b".
 

 
 Constraints: 

 
 1 <= s.length, t.length <= 200 
 s and t only contain lowercase letters and '#' characters. 
 

 
 Follow up: Can you solve it in O(n) time and O(1) space? 
 Related Topics 栈 双指针 字符串 模拟 👍 395 👎 0

*/
  
  public class BackspaceStringCompare{
      public static void main(String[] args) {
           Solution solution = new BackspaceStringCompare().new Solution();
          System.out.println(solution.backspaceCompare("ab##ad#e#", "ac#d#"));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean backspaceCompare(String s, String t) {
        int slength = s.length() - 1, tlength = t.length() - 1;
        int sskipnum = 0, tskipnum = 0;
        while (true) {
            while (slength >= 0) {
                if (s.charAt(slength) == '#') sskipnum++;
                else if (sskipnum != 0) sskipnum--;
                else break;
                slength--;
            }
            while (tlength >= 0) {
                if (t.charAt(tlength) == '#') tskipnum++;
                else if (tskipnum != 0) tskipnum--;
                else break;
                tlength--;
            }
            if (slength < 0 || tlength < 0) break;
            if (s.charAt(slength) != t.charAt(tlength)) return false;
            slength--;
            tlength--;
        }
        if (slength == -1 && tlength == -1) return true;
        return false;

       /* int i = s.length() - 1, j = t.length() - 1;
        int sskipnum = 0, tskipnum = 0;

        while (true) {
            while (i >= 0) {
                if (s.charAt(i) == '#') sskipnum++;
                else if (sskipnum != 0) sskipnum--;
                else break;
                i--;
            }
            while (j >= 0) {
                if (t.charAt(j) == '#') tskipnum++;
                else if (tskipnum != 0) tskipnum--;
                else break;
                j--;
            }
            if (i < 0 || j < 0) break;
            if (s.charAt(i) != t.charAt(j)) return false;
            i--; j--;
        }
        if (i == -1 && j == -1) return true;
        return false;*/
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }
  /*
  *         Stack<Character> sstack = new Stack<>(), tstack = new Stack<Character>();
        for (int i = 0; i < Math.max(s.length(), t.length()); i++) {
            if (i < s.length() && i < t.length()) {
                inputJu(s, sstack, s.charAt(i));
                inputJu(s, tstack, t.charAt(i));
            } else if (i >= s.length()) {
                inputJu(s, tstack, t.charAt(i));
            } else {
                inputJu(s, sstack, s.charAt(i));
            }
        }
        return sstack.toString().equals(tstack.toString());
        *
        *
        * public void inputJu(String s, Stack sstack, char c){
        if (!sstack.isEmpty() && c == '#') {
            sstack.pop();
        } else if (c != '#') {
            sstack.push(c);
        }
    }
        * */