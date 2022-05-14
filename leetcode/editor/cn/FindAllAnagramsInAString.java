import java.util.*;

/**
Given two strings s and p, return an array of all the start indices of p's 
anagrams in s. You may return the answer in any order. 

 An Anagram is a word or phrase formed by rearranging the letters of a 
different word or phrase, typically using all the original letters exactly once. 

 
 Example 1: 

 
Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
 

 Example 2: 

 
Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 

 
 Constraints: 

 
 1 <= s.length, p.length <= 3 * 10⁴ 
 s and p consist of lowercase English letters. 
 
 Related Topics 哈希表 字符串 滑动窗口 👍 833 👎 0

*/
  
  public class FindAllAnagramsInAString{
      public static void main(String[] args) {
           Solution solution = new FindAllAnagramsInAString().new Solution();
          System.out.println(solution.findAnagrams("aaaaaaaaaaaaaaaaaaaaaa", "a"));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> lists = new ArrayList<>();
        int[] aimArray = new int[26], judgeArray = new int[26];
        int slength = s.length(), plength = p.length();

        if (slength < plength) return lists;

        for (int i = 0; i < plength; i++) {
            aimArray[p.charAt(i) - 'a']++;
            judgeArray[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(aimArray, judgeArray)) lists.add(0);

        for (int i = 0, j = plength; j < slength; i++, j++) {
            judgeArray[s.charAt(i) - 'a']--;
            judgeArray[s.charAt(j) - 'a']++;
            if (Arrays.equals(aimArray, judgeArray))
                lists.add(i + 1);
        }

        return lists;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }