package editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
Given two binary search trees root1 and root2, return a list containing all the 
integers from both trees sorted in ascending order. 

 
 Example 1: 

 
Input: root1 = [2,1,4], root2 = [1,0,3]
Output: [0,1,1,2,3,4]
 

 Example 2: 

 
Input: root1 = [1,null,8], root2 = [8,1]
Output: [1,1,8,8]
 

 
 Constraints: 

 
 The number of nodes in each tree is in the range [0, 5000]. 
 -10⁵ <= Node.val <= 10⁵ 
 
 Related Topics 树 深度优先搜索 二叉搜索树 二叉树 排序 👍 80 👎 0

*/
  
  public class AllElementsInTwoBinarySearchTrees{
      public static void main(String[] args) {
           Solution solution = new AllElementsInTwoBinarySearchTrees().new Solution();
          TreeNode root1 = new AllElementsInTwoBinarySearchTrees().new TreeNode(2);
          root1.left = new AllElementsInTwoBinarySearchTrees().new TreeNode(1);
          root1.right = new AllElementsInTwoBinarySearchTrees().new TreeNode(4);
          TreeNode root2 = new AllElementsInTwoBinarySearchTrees().new TreeNode(1);
          root2.left = new AllElementsInTwoBinarySearchTrees().new TreeNode(0);
          root2.right = new AllElementsInTwoBinarySearchTrees().new TreeNode(3);
          System.out.println(solution.getAllElements(root1, root2));

      }
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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root1 != null) slover(root1, res);
        if (root2 != null) slover(root2, res);
        Integer[] arr = Arrays.copyOfRange(res.toArray(), 0, res.size(), Integer[].class);
        Arrays.sort(arr);
        ArrayList<Integer> integers = new ArrayList<>(arr.length);
        for (Integer integer : arr) {
            integers.add(integer);
        }
        return integers;
    }
    private void slover(TreeNode tree, LinkedList<Integer> res){
        if (tree.left == null && tree.right == null){
            res.add(tree.val);
            return;
        }
        if (tree.left != null) {
            slover(tree.left, res);
        }
        if (tree.right != null) {
            slover(tree.right, res);
        }
        res.add(tree.val);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }