package editor.cn;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
Given a string containing digits from 2-9 inclusive, return all possible letter 
combinations that the number could represent. Return the answer in any order. 

 A mapping of digit to letters (just like on the telephone buttons) is given 
below. Note that 1 does not map to any letters. 

 

 
 Example 1: 

 
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 

 Example 2: 

 
Input: digits = ""
Output: []
 

 Example 3: 

 
Input: digits = "2"
Output: ["a","b","c"]
 

 
 Constraints: 

 
 0 <= digits.length <= 4 
 digits[i] is a digit in the range ['2', '9']. 
 
 Related Topics 哈希表 字符串 回溯 👍 1844 👎 0

*/
  
  public class LetterCombinationsOfAPhoneNumber{
      public static void main(String[] args) {
           Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
          System.out.println(solution.letterCombinations("2"));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if (digits.length() == 0) return res;

        HashMap<Character, String> dial = new HashMap<>(){{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backTrack(res, dial, digits, 0, new StringBuffer());
        return res;
    }

    private void backTrack(LinkedList<String> res, HashMap<Character, String> dial, String digits, int index, StringBuffer stringBuffer) {
        if (index == digits.length()) {
            res.add(stringBuffer.toString());
            return;
        }
        for (int start = 0; start < dial.get(digits.charAt(index)).length(); start++) {
            stringBuffer.append(dial.get(digits.charAt(index)).charAt(start));
            backTrack(res, dial, digits, index + 1, stringBuffer);
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
    }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }