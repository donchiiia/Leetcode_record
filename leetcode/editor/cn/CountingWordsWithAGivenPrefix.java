package editor.cn;

import java.util.Arrays;

/**
You are given an array of strings words and a string pref. 

 Return the number of strings in words that contain pref as a prefix. 

 A prefix of a string s is any leading contiguous substring of s. 

 
 Example 1: 

 
Input: words = ["pay","attention","practice","attend"], pref = "at"
Output: 2
Explanation: The 2 strings that contain "at" as a prefix are: "attention" and 
"attend".
 

 Example 2: 

 
Input: words = ["leetcode","win","loops","success"], pref = "code"
Output: 0
Explanation: There are no strings that contain "code" as a prefix.
 

 
 Constraints: 

 
 1 <= words.length <= 100 
 1 <= words[i].length, pref.length <= 100 
 words[i] and pref consist of lowercase English letters. 
 

 Related Topics 数组 字符串 👍 12 👎 0

*/
public class CountingWordsWithAGivenPrefix{
    public static void main(String[] args){
        Solution solution = new CountingWordsWithAGivenPrefix().new Solution();
        System.out.println(solution.prefixCount(new String[]{"pay","attention","pratctice","attend"}, "at"));
    }
    class Solution {
        public int prefixCount(String[] words, String pref) {
            int sum = 0;
            for (String word : words){
                if (word.startsWith(pref)) sum++;
            }
            return sum;
        }
    }
}

//leetcode submit region begin(Prohibit modification and deletion)

//leetcode submit region end(Prohibit modification and deletion)
