package editor.cn;

/**
A teacher is writing a test with n true/false questions, with 'T' denoting true 
and 'F' denoting false. He wants to confuse the students by maximizing the 
number of consecutive questions with the same answer (multiple trues or multiple 
falses in a row). 

 You are given a string answerKey, where answerKey[i] is the original answer to 
the iᵗʰ question. In addition, you are given an integer k, the maximum number 
of times you may perform the following operation: 

 
 Change the answer key for any question to 'T' or 'F' (i.e., set answerKey[i] 
to 'T' or 'F'). 
 

 Return the maximum number of consecutive 'T's or 'F's in the answer key after 
performing the operation at most k times. 

 
 Example 1: 

 
Input: answerKey = "TTFF", k = 2
Output: 4
Explanation: We can replace both the 'F's with 'T's to make answerKey = "TTTT".
There are four consecutive 'T's.
 

 Example 2: 

 
Input: answerKey = "TFFT", k = 1
Output: 3
Explanation: We can replace the first 'T' with an 'F' to make answerKey = 
"FFFT".
Alternatively, we can replace the second 'T' with an 'F' to make answerKey = 
"TFFF".
In both cases, there are three consecutive 'F's.
 

 Example 3: 

 
Input: answerKey = "TTFTTFTT", k = 1
Output: 5
Explanation: We can replace the first 'F' to make answerKey = "TTTTTFTT"
Alternatively, we can replace the second 'F' to make answerKey = "TTFTTTTT". 
In both cases, there are five consecutive 'T's.
 

 
 Constraints: 

 
 n == answerKey.length 
 1 <= n <= 5 * 10⁴ 
 answerKey[i] is either 'T' or 'F' 
 1 <= k <= n 
 
 Related Topics 字符串 二分查找 前缀和 滑动窗口 👍 147 👎 0

*/
  
  public class MaximizeTheConfusionOfAnExam{
      public static void main(String[] args) {
           Solution solution = new MaximizeTheConfusionOfAnExam().new Solution();
          System.out.print(solution.maxConsecutiveAnswers("FTFFTFTFTTFTTFTTFFTTFFTTTTTFTTTFTFFTTFFFFFTTTTFTTTTTTTTTFTTFFTTFTFFTTTFFFFFTTTFFTTTTFTFTFFTTFTTTTTTF", 32));
          System.out.println(" # " + solution.maxConsecutiveAnswers("FFFTTFTTFT", 3));
          System.out.print(solution.maxConsecutiveAnswers("TTFF", 2));
          System.out.print(" # " + solution.maxConsecutiveAnswers("TFFT", 1));
          System.out.println(" # " + solution.maxConsecutiveAnswers("TTFTTFTT", 1));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    String s = null;
    int rk, length;
    public int maxConsecutiveAnswers(String answerKey, int k) {
        rk = k;
        length = answerKey.length();
        s = answerKey;
        return Math.max(getCnt('T'), getCnt('F'));
    }

    int getCnt(char c){
        int max = 0;
        for (int i = 0, j = 0, count = 0; i < length; i++) {
            if (s.charAt(i) == c) count++;
            while (count > rk) {
                if (s.charAt(j) == c) count--;
                j++;
            }
            max = Math.max(i - j + 1, max);
        }
        return max;
    }
/*    public int MaxLength(String answerKey, int k, char model){
        int count = 0, max = 0, m = 0, n = m;
        int[] rec = new int[answerKey.length()];
        for (int i = 0, j = 0; j < answerKey.length(); j++) {
            if (answerKey.charAt(j) == model) {
                count++;
                continue;
            }
            if (k > 0) {
                count++;
                max = Math.max(max, count);
                if (answerKey.charAt(j) != model) {
                    k--;
                    rec[m++] = j;
                }
            } else {
                k++;
                count -= (rec[n] - i + 1);
                i = rec[n++] + 1;
                j--;
            }
        max = Math.max(max, count);
        return max;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

  }