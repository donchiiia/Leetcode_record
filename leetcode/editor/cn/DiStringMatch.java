package editor.cn;

import java.util.Arrays;

/**
A permutation perm of n + 1 integers of all the integers in the range [0, n] 
can be represented as a string s of length n where: 

 
 s[i] == 'I' if perm[i] < perm[i + 1], and 
 s[i] == 'D' if perm[i] > perm[i + 1]. 
 

 Given a string s, reconstruct the permutation perm and return it. If there are 
multiple valid permutations perm, return any of them. 

 
 Example 1: 
 Input: s = "IDID"
Output: [0,4,1,3,2]
 Example 2: 
 Input: s = "III"
Output: [0,1,2,3]
 Example 3: 
 Input: s = "DDI"
Output: [3,2,0,1]
 
 
 Constraints: 

 
 1 <= s.length <= 10⁵ 
 s[i] is either 'I' or 'D'. 
 
 Related Topics 贪心 数组 数学 双指针 字符串 👍 308 👎 0

*/
  
  public class DiStringMatch{
      public static void main(String[] args) {
           Solution solution = new DiStringMatch().new Solution();
          System.out.println(Arrays.toString(solution.diStringMatch("DDI")));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] diStringMatch(String s) {
        int len = s.length() + 1;
        int[] array = new int[len];
        int left = 0;
        int right = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                array[i] = left;
                left++;
            } else if (s.charAt(i) == 'D') {
                array[i] = right;
                right--;
            }
        }
        array[s.length()] = left;
        return array;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }