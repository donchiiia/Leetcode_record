import java.util.jar.JarEntry;

/**
Write a function that reverses a string. The input string is given as an array 
of characters s. 

 You must do this by modifying the input array in-place with O(1) extra memory. 


 
 Example 1: 
 Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
 Example 2: 
 Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
 
 
 Constraints: 

 
 1 <= s.length <= 10⁵ 
 s[i] is a printable ascii character. 
 
 Related Topics 递归 双指针 字符串 👍 547 👎 0

*/
  
  public class ReverseString {
    public static void main(String[] args) {
        Solution solution = new ReverseString().new Solution();
        char[] res = new char[]{'H', 'e', 'l', 'l', 'o', 'W'};
        solution.reverseString(res);
        for (char c :
                res) {
            System.out.print(c + " ");
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void reverseString(char[] s) {
            for (int i = 0; i < s.length / 2; i++) {
                s[i] ^= s[s.length - 1 - i];
                s[s.length - 1 - i] ^= s[i];
                s[i] ^= s[s.length - 1 - i];
            }
        }
/*    public void swap(char[] s, int i, int j){
        if (i < j) {
            s[i] ^= s[j];
            s[j] ^= s[i];
            s[i] ^= s[j];
            swap(s, i + 1, j - 1);
        }
        return;
    }*/
    }
//leetcode submit region end(Prohibit modification and deletion)
}
  /*        for (int i = 0; i <= length; i++) {
            char temp = s[i];
            s[i] = s[length];
            s[length--] = temp;
        }*/