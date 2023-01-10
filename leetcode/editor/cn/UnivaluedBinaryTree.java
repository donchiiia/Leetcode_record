package editor.cn;

/**
A binary tree is uni-valued if every node in the tree has the same value. 

 Given the root of a binary tree, return true if the given tree is uni-valued, 
or false otherwise. 

 
 Example 1: 

 
Input: root = [1,1,1,1,1,null,1]
Output: true
 

 Example 2: 

 
Input: root = [2,2,2,5,2]
Output: false
 

 
 Constraints: 

 
 The number of nodes in the tree is in the range [1, 100]. 
 0 <= Node.val < 100 
 
 Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 110 👎 0

*/

public class UnivaluedBinaryTree{
    public static void main(String[] args) {
        Solution solution = new UnivaluedBinaryTree().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class editor.cn.TreeNode {
 *     int val;
 *     editor.cn.TreeNode left;
 *     editor.cn.TreeNode right;
 *     editor.cn.TreeNode() {}
 *     editor.cn.TreeNode(int val) { this.val = val; }
 *     editor.cn.TreeNode(int val, editor.cn.TreeNode left, editor.cn.TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

  public class TreeNode {
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
    public boolean isUnivalTree(TreeNode root) {
        return helper(root, root.val);
    }

    public boolean helper(TreeNode root, int val) {
        if (root == null) return true;
        if (root.val != val) return false;
        if (!helper(root.left, val) || !helper(root.right, val)) return false;
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }