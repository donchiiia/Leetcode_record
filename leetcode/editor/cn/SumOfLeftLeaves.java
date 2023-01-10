package editor.cn;

import java.util.ArrayDeque;
import java.util.Queue;

/**
Given the root of a binary tree, return the sum of all left leaves. 

 A leaf is a node with no children. A left leaf is a leaf that is the left 
child of another node. 

 
 Example 1: 

 
Input: root = [3,9,20,null,null,15,7]
Output: 24
Explanation: There are two left leaves in the binary tree, with values 9 and 15 
respectively.
 

 Example 2: 

 
Input: root = [1]
Output: 0
 

 
 Constraints: 

 
 The number of nodes in the tree is in the range [1, 1000]. 
 -1000 <= Node.val <= 1000 
 
 Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 415 👎 0

*/
  
  public class SumOfLeftLeaves{
      public static void main(String[] args) {
           Solution solution = new SumOfLeftLeaves().new Solution();
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
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> res = new ArrayDeque<>();
        res.add(root);
        int sum = 0;
        while (!res.isEmpty()) {
            TreeNode temp = res.poll();
            if (temp.left != null) {
                if (temp.left.left == null && temp.left.right == null) {
                    sum += temp.left.val;
                } else {
                    res.add(temp.left);
                }
            }
            if (temp.right != null) {
                res.add(temp.right);
            }
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }