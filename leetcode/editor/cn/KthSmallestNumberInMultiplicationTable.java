package editor.cn;

/**
Nearly everyone has used the Multiplication Table. The multiplication table of 
size m x n is an integer matrix mat where mat[i][j] == i * j (1-indexed). 

 Given three integers m, n, and k, return the kᵗʰ smallest element in the m x n 
multiplication table. 

 
 Example 1: 

 
Input: m = 3, n = 3, k = 5
Output: 3
Explanation: The 5ᵗʰ smallest number is 3.
 

 Example 2: 

 
Input: m = 2, n = 3, k = 6
Output: 6
Explanation: The 6ᵗʰ smallest number is 6.
 

 
 Constraints: 

 
 1 <= m, n <= 3 * 10⁴ 
 1 <= k <= m * n 
 
 Related Topics 二分查找 👍 270 👎 0

*/

public class KthSmallestNumberInMultiplicationTable{
    public static void main(String[] args) {
        Solution solution = new KthSmallestNumberInMultiplicationTable().new Solution();
        System.out.println(solution.findKthNumber(3, 3, 5));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int m1, n1, k1;
    public int findKthNumber(int m, int n, int k) {
        m1 = Math.max(m, n);
        n1 = Math.min(m, n);
        k1 = k;
        int l = 1, r = m1 * n1;
        while (l < r) {
            int mid = l + r >> 1, cnt = getCnt(mid);
            if (cnt >= k) r = mid;
            else l = mid + 1;
        }
        return r;
    }
    private int getCnt(int mid){
        int ans = 0;
        for (int i = 1; i <= n1; i++) ans += (i * m1) <= mid ? m1 : mid / i;
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }