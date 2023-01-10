package editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
In the "100 game" two players take turns adding, to a running total, any 
integer from 1 to 10. The player who first causes the running total to reach or exceed 
100 wins. 

 What if we change the game so that players cannot re-use integers? 

 For example, two players might take turns drawing from a common pool of 
numbers from 1 to 15 without replacement until they reach a total >= 100. 

 Given two integers maxChoosableInteger and desiredTotal, return true if the 
first player to move can force a win, otherwise, return false. Assume both players 
play optimally. 

 
 Example 1: 

 
Input: maxChoosableInteger = 10, desiredTotal = 11
Output: false
Explanation:
No matter which integer the first player choose, the first player will lose.
The first player can choose an integer from 1 up to 10.
If the first player choose 1, the second player can only choose integers from 2 
up to 10.
The second player will win by choosing 10 and get a total = 11, which is >= 
desiredTotal.
Same with other integers chosen by the first player, the second player will 
always win.
 

 Example 2: 

 
Input: maxChoosableInteger = 10, desiredTotal = 0
Output: true
 

 Example 3: 

 
Input: maxChoosableInteger = 10, desiredTotal = 1
Output: true
 

 
 Constraints: 

 
 1 <= maxChoosableInteger <= 20 
 0 <= desiredTotal <= 300 
 
 Related Topics 位运算 记忆化搜索 数学 动态规划 状态压缩 博弈 👍 387 👎 0

*/

public class CanIWin{
    public static void main(String[] args) {
        Solution solution = new CanIWin().new Solution();
        System.out.println(solution.canIWin(10, 11));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
            //总长度不满足目标值
            if (maxChoosableInteger * (maxChoosableInteger + 1) < (desiredTotal * 2)) {
                return false;
            }
            //存储state的变量值，state一共有2^maxChoosableInteger种
            Map<Integer, Boolean> memory = new HashMap<>(1 << maxChoosableInteger);
            //开始遍历整个树
            return dfs(maxChoosableInteger, 0, desiredTotal, 0, memory);
        }

        /**
         * @param maxChoosableInteger 最大可选择的数字
         * @param state               状态位
         * @param desiredTotal        目标值
         * @param curTotal            当前值
         * @param memory              存储搜索过的状态
         * @return
         */
        private boolean dfs(int maxChoosableInteger, int state, int desiredTotal, int curTotal, Map<Integer, Boolean> memory) {
            if (!memory.containsKey(state)) {
                boolean ans = false;
                for (int i = 0; i < maxChoosableInteger; i++) {
                    //state的第i位表示 第i+1个数字被使用
                    if (((state >> i) & 1) == 1) {
                        continue;
                    }
                    //先手取i看 能不能赢 不能赢则轮到对手取数字
                    if (curTotal + i + 1 >= desiredTotal) {
                        ans = true;
                        break;
                    }
                    //轮到对手取数字 若对手不能赢（必然输掉的状态） 则我方赢
                    //state | (1 << i), 将state的第i位置为已使用
                    if (!dfs(maxChoosableInteger, state | (1 << i), desiredTotal, curTotal + i + 1, memory)) {
                        ans = true;
                        break;
                    }
                }
                memory.put(state, ans);
            }
            return memory.get(state);
        }
}
//leetcode submit region end(Prohibit modification and deletion)

  }