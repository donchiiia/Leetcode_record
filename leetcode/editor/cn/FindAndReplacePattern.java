package editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
Given a list of strings words and a string pattern, return a list of words[i] 
that match pattern. You may return the answer in any order. 

 A word matches the pattern if there exists a permutation of letters p so that 
after replacing every letter x in the pattern with p(x), we get the desired word.
 

 Recall that a permutation of letters is a bijection from letters to letters: 
every letter maps to another letter, and no two letters map to the same letter. 

 
 Example 1: 

 
Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
Output: ["mee","aqq"]
Explanation: "mee" matches the pattern because there is a permutation {a -> m, 
b -> e, ...}. 
"ccc" does not match the pattern because {a -> c, b -> c, ...} is not a 
permutation, since a and b map to the same letter.
 

 Example 2: 

 
Input: words = ["a","b","c"], pattern = "a"
Output: ["a","b","c"]
 

 
 Constraints: 

 
 1 <= pattern.length <= 20 
 1 <= words.length <= 50 
 words[i].length == pattern.length 
 pattern and words[i] are lowercase English letters. 
 
 Related Topics 数组 哈希表 字符串 👍 129 👎 0

*/

public class FindAndReplacePattern{
    public static void main(String[] args) {
        Solution solution = new FindAndReplacePattern().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (match(word, pattern) && match(pattern, word)){
                res.add(word);
            }
        }
        return res;
    }

        private boolean match(String pattern, String word) {
            HashMap<Character, Character> map = new HashMap<>();
            for (int i = 0; i < word.length(); i++) {
                char x = pattern.charAt(i), y = word.charAt(i);
                if (!map.containsKey(x)) {
                    map.put(x, y);
                } else if (map.get(x) != y) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

  }