  /**
A pangram is a sentence where every letter of the English alphabet appears at 
least once. 

 Given a string sentence containing only lowercase English letters, return true 
if sentence is a pangram, or false otherwise. 

 
 Example 1: 

 
Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
Output: true
Explanation: sentence contains at least one of every letter of the English 
alphabet.
 

 Example 2: 

 
Input: sentence = "leetcode"
Output: false
 

 
 Constraints: 

 
 1 <= sentence.length <= 1000 
 sentence consists of lowercase English letters. 
 

 Related Topics 哈希表 字符串 👍 42 👎 0

*/
  
  package editor.cn;
  public class CheckIfTheSentenceIsPangram{
      public static void main(String[] args) {
          Solution solution = new CheckIfTheSentenceIsPangram().new Solution();
          System.out.println(solution.checkIfPangram("tleetcode"));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkIfPangram(String sentence) {
        int count = 26;
        int[] rec = new int[26];
        for (char c : sentence.toCharArray()) {
            if (rec[c - 'a'] == 0){
                count--;
                rec[c - 'a'] = 1;
            }
        }
        return count == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }