/**
Given a (0-indexed) integer array nums and two integers low and high, return 
the number of nice pairs. 

 A nice pair is a pair (i, j) where 0 <= i < j < nums.length and low <= (nums[i]
 XOR nums[j]) <= high. 

 
 Example 1: 

 
Input: nums = [1,4,2,7], low = 2, high = 6
Output: 6
Explanation: All nice pairs (i, j) are as follows:
    - (0, 1): nums[0] XOR nums[1] = 5 
    - (0, 2): nums[0] XOR nums[2] = 3
    - (0, 3): nums[0] XOR nums[3] = 6
    - (1, 2): nums[1] XOR nums[2] = 6
    - (1, 3): nums[1] XOR nums[3] = 3
    - (2, 3): nums[2] XOR nums[3] = 5
 

 Example 2: 

 
Input: nums = [9,8,4,2,1], low = 5, high = 14
Output: 8
Explanation: All nice pairs (i, j) are as follows:
​​​​​    - (0, 2): nums[0] XOR nums[2] = 13
    - (0, 3): nums[0] XOR nums[3] = 11
    - (0, 4): nums[0] XOR nums[4] = 8
    - (1, 2): nums[1] XOR nums[2] = 12
    - (1, 3): nums[1] XOR nums[3] = 10
    - (1, 4): nums[1] XOR nums[4] = 9
    - (2, 3): nums[2] XOR nums[3] = 6
    - (2, 4): nums[2] XOR nums[4] = 5 

 
 Constraints: 

 
 1 <= nums.length <= 2 * 10⁴ 
 1 <= nums[i] <= 2 * 10⁴ 
 1 <= low <= high <= 2 * 10⁴ 
 

 Related Topics 位运算 字典树 数组 👍 79 👎 0

*/

package editor.cn;

import java.util.zip.CRC32;

public class CountPairsWithXorInARange{
    public static void main(String[] args) {
        Solution solution = new CountPairsWithXorInARange().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    class Trie{
        Trie[] child = new Trie[2];
        int sum;
        public Trie(){
            sum = 0;
        }
    }
    static final int HIGT_BITS = 14;

    Trie root = null;

    public int countPairs(int[] nums, int low, int high) {
        return f(nums, high) - f(nums, low - 1);
    }

    private int f(int[] nums, int num){
        root = new Trie();
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            add(nums[i - 1]);
            res += search(nums[i], num);
        }
        return res;
    }

    private void add(int num){
        Trie cur = root;
        for (int i = HIGT_BITS; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (cur.child[bit] == null) cur.child[bit] = new Trie();
            cur = cur.child[bit];
            cur.sum++;
        }
    }

    private int search(int num, int x){
        Trie cur = root;
        int sum = 0;
        for (int i = HIGT_BITS; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (((x >> i) & 1) == 0) {
                if (cur.child[bit] == null) return sum;
                cur = cur.child[bit];
            } else {
                if (cur.child[bit] != null) sum += cur.child[bit].sum;
                if (cur.child[bit ^ 1] == null) return sum;
                cur = cur.child[bit ^ 1];
            }
        }
        sum += cur.sum;
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}