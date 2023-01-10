package editor.cn;

import java.util.Arrays;

/**
You are given an array of logs. Each log is a space-delimited string of words, 
where the first word is the identifier. 

 There are two types of logs: 

 
 Letter-logs: All words (except the identifier) consist of lowercase English 
letters. 
 Digit-logs: All words (except the identifier) consist of digits. 
 

 Reorder these logs so that: 

 
 The letter-logs come before all digit-logs. 
 The letter-logs are sorted lexicographically by their contents. If their 
contents are the same, then sort them lexicographically by their identifiers. 
 The digit-logs maintain their relative ordering. 
 

 Return the final order of the logs. 

 
 Example 1: 

 
Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3
 art zero"]
Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 
3 6"]
Explanation:
The letter-log contents are all different, so their ordering is "art can", "art 
zero", "own kit dig".
The digit-logs have a relative order of "dig1 8 1 5 1", "dig2 3 6".
 

 Example 2: 

 
Input: logs = ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act 
zoo"]
Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
 

 
 Constraints: 

 
 1 <= logs.length <= 100 
 3 <= logs[i].length <= 100 
 All the tokens of logs[i] are separated by a single space. 
 logs[i] is guaranteed to have an identifier and at least one word after the 
identifier. 
 
 Related Topics 数组 字符串 排序 👍 107 👎 0

*/
  
  public class ReorderDataInLogFiles{
      public static void main(String[] args) {
           Solution solution = new ReorderDataInLogFiles().new Solution();
          for (String s : solution.reorderLogFiles(new String[]{
                  "dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"
          })) {
              System.out.println(s);
          }
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (logs1, logs2) ->{
            String[] split1 = logs1.split(" ", 2);
            String[] split2 = logs2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0)), isDigit2 = Character.isDigit(split2[1].charAt(0));
            if (!isDigit1 && !isDigit2) {
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp != 0) return cmp;
                return split1[0].compareTo(split2[0]);
            }
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });
        return logs;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }