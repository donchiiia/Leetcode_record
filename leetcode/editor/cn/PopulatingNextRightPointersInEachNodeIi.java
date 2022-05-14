import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
Given a binary tree 

 
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
 

 Populate each next pointer to point to its next right node. If there is no 
next right node, the next pointer should be set to NULL. 

 Initially, all next pointers are set to NULL. 

 
 Example 1: 

 
Input: root = [1,2,3,4,5,null,7]
Output: [1,#,2,3,#,4,5,7,#]
Explanation: Given the above binary tree (Figure A), your function should 
populate each next pointer to point to its next right node, just like in Figure B. 
The serialized output is in level order as connected by the next pointers, with '#
' signifying the end of each level.
 

 Example 2: 

 
Input: root = []
Output: []
 

 
 Constraints: 

 
 The number of nodes in the tree is in the range [0, 6000]. 
 -100 <= Node.val <= 100 
 

 
 Follow-up: 

 
 You may only use constant extra space. 
 The recursive approach is fine. You may assume implicit stack space does not 
count as extra space for this problem. 
 
 Related Topics 树 深度优先搜索 广度优先搜索 链表 二叉树 👍 535 👎 0

*/
  
  public class PopulatingNextRightPointersInEachNodeIi{
      public static void main(String[] args) {
           Solution solution = new PopulatingNextRightPointersInEachNodeIi().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        if (root.left != null && root.right != null) root.left.next = root.right;
        if (root.left != null && root.right == null) root.left.next = getNextInLevel(root.next);
        if (root.right != null) root.right.next = getNextInLevel(root.next);
        connect(root.right);
        connect(root.left);
        return root;
    }

    private Node getNextInLevel(Node aim) {
        if (aim == null) return null;
        if (aim.left != null) return aim.left;
        if (aim.right != null) return aim.right;
        if (aim.next != null) return getNextInLevel(aim.next);
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
  /*public Node connect(Node root) {
        if (root == null) return null;
        if (root.left != null && root.right != null) root.left.next = root.right;
        if (root.left != null && root.right == null) root.left.next = getNextInLevel(root.next);
        if (root.right != null) root.right.next = getNextInLevel(root.next);
        connect(root.right);
        connect(root.left);
        return root;
    }

    private Node getNextInLevel(Node aim) {
        if (aim == null) return null;
        if (aim.left != null) return aim.left;
        if (aim.right != null) return aim.right;
        if (aim.next != null) return getNextInLevel(aim.next);
        return null;
    }*/