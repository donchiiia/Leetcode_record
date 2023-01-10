package editor.cn;

/**
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or 
false otherwise. 

 In other words, return true if one of s1's permutations is the substring of s2.
 

 
 Example 1: 

 
Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
 

 Example 2: 

 
Input: s1 = "ab", s2 = "eidboaoo"
Output: false
 

 
 Constraints: 

 
 1 <= s1.length, s2.length <= 10⁴ 
 s1 and s2 consist of lowercase English letters. 
 
 Related Topics 哈希表 双指针 字符串 滑动窗口 👍 616 👎 0

*/
  
  public class PermutationInString{
      public static void main(String[] args) {
           Solution solution = new PermutationInString().new Solution();
          System.out.println(solution.checkInclusion("ab", "zxkiwabcdhul"));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] st1 = s1.toCharArray(), st2 = s2.toCharArray();
        int s1l = s1.length(), s2l = s2.length();
        int[] rec = new int[26];    //用于记录s1中每个字母出现频度的记录数组
        //记录st1中每个字母出现的次数
        for (char c : st1) {
            rec[c - 'a']++;
        }
        //双指针以构造滑动窗口
        int l = 0, r = 0;
        //因为是滑动窗口，l为窗口的左边界，所以l小于等于st2和st1的长度差值就行了
        while (l <= s2l - s1l) {
            //目标的情况就是滑动窗口中刚好就是目标字符串的排列
            //即在st1长度之内，每个字母对应在rec中的出现记录都大于等于1，并且直到r == l+s1l说明找到
            while (r < l + s1l && rec[st2[r] - 'a'] >= 1) {
                //因为st1中可能存在重复的字母，为了保证每个重复的字母都匹配到，在str2中找到对应字母后，就将rec中的记录--
                rec[st2[r] - 'a']--;
                r++;
            }
            if (r == l + s1l) return true;
            //上面的while循环以及if语句是针对刚好在滑动窗口中能够匹配到的情况
            //***假如刚好窗口内前几个字母匹配，但是靠后的字符串中出现了异常字母，这意味着窗口前面的字母不属于正确匹配
            //我们要将while循环中的--操作反向补充回来，即++操作
            rec[st2[l] - 'a']++;    //滑动窗口随着左边界l不断向右，将原先尝试错误减去的记录增加回来
            l++;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
  /*if (s1.length() > s2.length()) return false;
        int[] rec = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            rec[s1.charAt(i) - 'a']++;
        }
        int l = 0, r = 0;
        while (l <= s2.length() - s1.length()) {
            while (r < l + s1.length() && rec[s2.charAt(r) - 'a'] >= 1) {
                rec[s2.charAt(r) - 'a']--;
                r++;
            }
            if (r == l + s1.length()) return true;
            rec[s2.charAt(l) - 'a']++;
            l++;
        }
        return false;*/