/**
Given an integer array nums, return the maximum result of nums[i] XOR nums[j], 
where 0 <= i <= j < n. 

 
 Example 1: 

 
Input: nums = [3,10,5,25,2,8]
Output: 28
Explanation: The maximum result is 5 XOR 25 = 28.
 

 Example 2: 

 
Input: nums = [14,70,53,83,49,91,36,80,92,51,66,70]
Output: 127
 

 
 Constraints: 

 
 1 <= nums.length <= 2 * 10⁵ 
 0 <= nums[i] <= 2³¹ - 1 
 

 Related Topics 位运算 字典树 数组 哈希表 👍 512 👎 0

*/

package editor.cn;
public class MaximumXorOfTwoNumbersInAnArray{
    public static void main(String[] args) {
        Solution solution = new MaximumXorOfTwoNumbersInAnArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    Trie root = new Trie();
    int HIGH_BITS = 30;
    class Trie{
        Trie left = null;
        Trie right = null;
    }
    public int findMaximumXOR(int[] nums) {
        int res = 0;
        int length = nums.length;

        for (int i = 1; i < length; i++) {
            add(nums[i - 1]);
            res = Math.max(res, check(nums[i]));
        }
        return res;
    }

    private void add(int num){
        Trie cur = root;
        for (int i = HIGH_BITS; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (bit == 0) {
                if (cur.left == null) cur.left = new Trie();
                cur = cur.left;
            } else {
                if (cur.right == null) cur.right = new Trie();
                cur = cur.right;
            }
        }
    }

    private int check(int num){
        Trie cur = root;
        int res = 0;
        for (int i = HIGH_BITS; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (bit == 0) {
                if (cur.right == null) {
                    cur = cur.left;
                    res *= 2;
                } else {
                    cur = cur.right;
                    res = res * 2 + 1;
                }
            } else {
                if (cur.left == null) {
                    cur = cur.right;
                    res = res * 2;
                } else {
                    cur = cur.left;
                    res = res * 2 + 1;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}