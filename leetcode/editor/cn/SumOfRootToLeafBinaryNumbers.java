/**
You are given the root of a binary tree where each node has a value 0 or 1. 
Each root-to-leaf path represents a binary number starting with the most 
significant bit. 

 
 For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01
101 in binary, which is 13. 
 

 For all leaves in the tree, consider the numbers represented by the path from 
the root to that leaf. Return the sum of these numbers. 

 The test cases are generated so that the answer fits in a 32-bits integer. 

 
 Example 1: 

 
Input: root = [1,0,1,0,1,0,1]
Output: 22
Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 

 Example 2: 

 
Input: root = [0]
Output: 0
 

 
 Constraints: 

 
 The number of nodes in the tree is in the range [1, 1000]. 
 Node.val is 0 or 1. 
 
 Related Topics 树 深度优先搜索 二叉树 👍 156 👎 0

*/

public class SumOfRootToLeafBinaryNumbers{
    public static void main(String[] args) {
        Solution solution = new SumOfRootToLeafBinaryNumbers().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int aim) {
        if (root == null) return 0;
        aim = (aim << 1) | root.val;
        if (root.left == null && root.right == null) return aim;
        return dfs(root.left, aim) + dfs(root.right, aim);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }