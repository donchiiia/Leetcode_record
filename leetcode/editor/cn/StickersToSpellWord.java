package editor.cn;

import java.util.Arrays;

/**
/**
/**
////////////We are given n different types of stickers. Each sticker has a 
//////lowercase 
////////////English word on it. 
////////////
//////////// You would like to spell out the given string target by cutting 
////////individual 
////////////letters from your collection of stickers and rearranging them. You 
////can 
////////use 
//////////each 
////////////sticker more than once if you want, and you have infinite 
//quantities 
////of 
//////
//////////each 
////////////sticker. 
////////////
//////////// Return the minimum number of stickers that you need to spell out 
//////target. 
////////
//////////If 
////////////the task is impossible, return -1. 
////////////
//////////// Note: In all test cases, all words were chosen randomly from the 10



//00
//// 
////////most 
//////////
////////////common US English words, and target was chosen as a concatenation 
//of 
//////two 
//////////random 
////////////words. 
////////////
//////////// 
//////////// Example 1: 
////////////
//////////// 
////////////Input: stickers = ["with","example","science"], target = "thehat"
////////////Output: 3
////////////Explanation:
////////////We can use 2 "with" stickers, and 1 "example" sticker.
////////////After cutting and rearrange the letters of those stickers, we can 
////form 
////////the 
////////////target "thehat".
////////////Also, this is the minimum number of stickers necessary to form the 
//////target 
////////
////////////string.
//////////// 
////////////
//////////// Example 2: 
////////////
//////////// 
////////////Input: stickers = ["notice","possible"], target = "basicbasic"
////////////Output: -1
////////////Explanation:
////////////We cannot form the target "basicbasic" from cutting letters from 
//the 
////////given 
////////////stickers.
//////////// 
////////////
//////////// 
//////////// Constraints: 
////////////
//////////// 
//////////// n == stickers.length 
//////////// 1 <= n <= 50 
//////////// 1 <= stickers[i].length <= 10 
//////////// 1 <= target.length <= 15 
//////////// stickers[i] and target consist of lowercase English letters. 
//////////// 
//////////// Related Topics 位运算 动态规划 回溯 状态压缩 👍 166 👎 0
//////////
////////
//////
////
//

*/


public class StickersToSpellWord{
    public static void main(String[] args) {
        Solution solution = new StickersToSpellWord().new Solution();
        System.out.println(solution.minStickers(new String[]{"with", "example", "science"}, "thehat"));
    }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      public int minStickers(String[] stickers, String target) {
          int m = target.length();
          int[] memo = new int[1 << m];
          Arrays.fill(memo, -1);
          memo[0] = 0;
          int res = dp(stickers, target, memo, (1 << m) - 1);
          return res <= m ? res : -1;
      }

      public int dp(String[] stickers, String target, int[] memo, int mask) {
          int m = target.length();
          if (memo[mask] < 0) {
              int res = m + 1;
              for (String sticker : stickers) {
                  int left = mask;
                  int[] cnt = new int[26];
                  for (int i = 0; i < sticker.length(); i++) {
                      cnt[sticker.charAt(i) - 'a']++;
                  }
                  for (int i = 0; i < target.length(); i++) {
                      char c = target.charAt(i);
                      if (((mask >> i) & 1) == 1 && cnt[c - 'a'] > 0) {
                          cnt[c - 'a']--;
                          left ^= 1 << i;
                      }
                  }
                  if (left < mask) {
                      res = Math.min(res, dp(stickers, target, memo, left) + 1);
                  }
              }
              memo[mask] = res;
          }
          return memo[mask];
      }
}
//leetcode submit region end(Prohibit modification and deletion)

  }