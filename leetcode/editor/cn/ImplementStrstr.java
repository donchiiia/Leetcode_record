package editor.cn;

import java.util.Arrays;

/**
Implement strStr(). 

 Return the index of the first occurrence of needle in haystack, or -1 if 
needle is not part of haystack. 

 Clarification: 

 What should we return when needle is an empty string? This is a great question 
to ask during an interview. 

 For the purpose of this problem, we will return 0 when needle is an empty 
string. This is consistent to C's strstr() and Java's indexOf(). 

 
 Example 1: 
 Input: haystack = "hello", needle = "ll"
Output: 2
 Example 2: 
 Input: haystack = "aaaaa", needle = "bba"
Output: -1
 Example 3: 
 Input: haystack = "", needle = ""
Output: 0
 
 
 Constraints: 

 
 0 <= haystack.length, needle.length <= 5 * 10⁴ 
 haystack and needle consist of only lower-case English characters. 
 
 Related Topics 双指针 字符串 字符串匹配 👍 1323 👎 0

*/
  
  public class ImplementStrstr{
      public static void main(String[] args) {
           Solution solution = new ImplementStrstr().new Solution();
          System.out.println(solution.strStr("aabaab", "czoomiza"));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int[] next = new int[needle.length()];
        getNext(next, needle);
        System.out.println(Arrays.toString(next));
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    //KMP算法求next前缀数组
    /*
    * 前缀数组是记录：字符串中后端位置与前端位置中相同特征字串最大长度的数组（实际上起的另外一个重要作用就是标记
    * 相同符号串在前面出现的最近位置）
    * [a] = 0           自身位置为0，没有与之匹配的特征字符串
    * [a,a] = 1         特征字符串为 a， 对后一个字符串a而言，与之相等的最长特征字符串为前一个a
    * [a,a,b] = 0       对于b而言，没有与之相等的特征字符串
    * [a,a,b,a] = 1     0号位a和3号位构成对应最大长度字符串
    * [a,a,b,a,a] = 2   0，1号位a和3，4号位a构成最大长度字符串，当与[a,a,b,a,f]匹配时，f与next数组4号位a不匹配
    *                   寻找next数组中3号位a在前端位置中相同特征字符串的位置，可以发现，该位置就是1号位置。
    * 而getNext()方法的目的就是
    * */
    public void getNext(int[] next, String s){
        int j = 0;
        next[j] = 0;    //单独一个没有匹配的字符串

        //对i初始化，因为next[0]已经初始化了，所以从1开始构造next数组
        for (int i = 1; i < s.length(); i++) {
            //处理不相等的情况
            //保证j>0，因为不相等时为j赋予前一位的值，如果j==0会访问越界，不相等的处理是连续的，为的是
            //出现排除干扰项对最大特征字符串长度的影响。
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            //处理相等的情况:如果相等，就接着判断下一个字符是否继续相等，i由外部的循环改变，该条件判断用于改变j
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            //无论是是否找到相等的位置或者没找到（上面的while循环至j==0），接着就是为next每一位赋值
            next[i] = j;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }