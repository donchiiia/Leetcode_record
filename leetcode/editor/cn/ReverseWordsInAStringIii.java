  /**
Given a string s, reverse the order of characters in each word within a 
sentence while still preserving whitespace and initial word order. 

 
 Example 1: 
 Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
 Example 2: 
 Input: s = "God Ding"
Output: "doG gniD"
 
 
 Constraints: 

 
 1 <= s.length <= 5 * 10⁴ 
 s contains printable ASCII characters. 
 s does not contain any leading or trailing spaces. 
 There is at least one word in s. 
 All the words in s are separated by a single space. 
 
 Related Topics 双指针 字符串 👍 416 👎 0

*/
  
  public class ReverseWordsInAStringIii{
      public static void main(String[] args) {
           Solution solution = new ReverseWordsInAStringIii().new Solution();
          String ans = "Let's take LeetCode contest";
          System.out.println(solution.reverseWords(ans));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        int i = 0;
        char[] res = s.toCharArray();
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == ' ') {
                reverse(res, i, j - 1);
                j = j + 1;
                i = j;
            }
        }
        reverse(res, i, s.length() - 1);
        return new String(res);
    }
    public void reverse(char[] s, int i, int j ){
        while (i < j) {
            s[i] ^= s[j];
            s[j] ^= s[i];
            s[i++] ^= s[j--];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
  /*        int i = 0, j = 0;
        char[] ans = s.toCharArray();
        for (; j < ans.length; j++) {
            if (ans[j] == ' ') {
                reverse(ans, i, j - 1);
                i = j + 1;
                j = i;
            }
        }
        reverse(ans, i, ans.length - 1);
        return new String(ans);
    }
    public void reverse(char[] ans, int i , int j){
        while(i<j) {
            char temp = ans[i];
            ans[i] = ans[j];
            ans[j] = temp;
            i++;
            j--;
        }
    }*/