package editor.cn;

/**
/**
In an alien language, surprisingly, they also use English lowercase letters, 
but possibly in a different order. The order of the alphabet is some 
permutation 
of lowercase letters. 

 Given a sequence of words written in the alien language, and the order of the 
alphabet, return true if and only if the given words are sorted 
lexicographically in this alien language. 

 
 Example 1: 

 
Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is 
sorted.
 

 Example 2: 

 
Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], 

hence the sequence is unsorted.
 

 Example 3: 

 
Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is 
shorter (in size.) According to lexicographical rules "apple" > "app", because 
'l' > '∅', where '∅' is defined as the blank character which is less than any 
other character (More info).
 

 
 Constraints: 

 
 1 <= words.length <= 100 
 1 <= words[i].length <= 20 
 order.length == 26 
 All characters in words[i] and order are English lowercase letters. 
 
 Related Topics 数组 哈希表 字符串 👍 144 👎 0

*/

public class VerifyingAnAlienDictionary{
    public static void main(String[] args) {
        Solution solution = new VerifyingAnAlienDictionary().new Solution();
        System.out.println(solution.isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] newOrder = new int[26];
    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < order.toCharArray().length; i++) {
            newOrder[order.charAt(i) - 'a'] = i + 1;
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (compare(words[i], words[i + 1]) > 0) return false;
        }
        return true;
    }
        private int compare(String word1, String word2) {
            int l1 = word1.length(), l2 = word2.length();
            int min = Math.min(l1, l2);

            for (int i = 0; i < min; i++) {
                char c1 = word1.charAt(i), c2 = word2.charAt(i);
                if (c1 != c2) return newOrder[c1 - 'a'] - newOrder[c2 - 'a'];
            }
            return l1 - l2;
        }
}

//leetcode submit region end(Prohibit modification and deletion)

  }