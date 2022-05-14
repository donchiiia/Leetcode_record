
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
You are given a perfect binary tree where all leaves are on the same level, and 
every parent has two children. The binary tree has the following definition: 

 
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

 
Input: root = [1,2,3,4,5,6,7]
Output: [1,#,2,3,#,4,5,6,7,#]
Explanation: Given the above perfect binary tree (Figure A), your function 
should populate each next pointer to point to its next right node, just like in 
Figure B. The serialized output is in level order as connected by the next pointers, 
with '#' signifying the end of each level.
 

 Example 2: 

 
Input: root = []
Output: []
 

 
 Constraints: 

 
 The number of nodes in the tree is in the range [0, 2¹² - 1]. 
 -1000 <= Node.val <= 1000 
 

 
 Follow-up: 

 
 You may only use constant extra space. 
 The recursive approach is fine. You may assume implicit stack space does not 
count as extra space for this problem. 
 
 Related Topics 树 深度优先搜索 广度优先搜索 链表 二叉树 👍 709 👎 0

*/
  
  public class PopulatingNextRightPointersInEachNode{
      public static void main(String[] args) {
           Solution solution = new PopulatingNextRightPointersInEachNode().new Solution();
          int[] rem = new int[]{/*1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15*/0};
          ArrayDeque<Node> rootQueue = new ArrayDeque<>();
          Node root = new Node();
          int i = 0;

          root.val = rem[i++];
          rootQueue.add(root);
          while (!rootQueue.isEmpty()) {
              Node temp = rootQueue.remove();
              System.out.print(temp.val + " ");
              if (i < rem.length - 1) {
                  temp.left = new Node(rem[i++]);
                  temp.right = new Node(rem[i++]);
                  rootQueue.add(temp.left);
                  rootQueue.add(temp.right);
              }
          }
          System.out.println("");
          System.out.println("####################");
          root = solution.connect(root);
          Node tmp = root.left;
          while (!(root.left == null && root.right == null && root.next == null)) {
              if (root.next == null) {
                  System.out.print(root.val + " #");
                  root = tmp;
                  tmp = root.left;
              }
              else {
                  System.out.print(root.val + " ");
                  root = root.next;
              }
          }
          System.out.print(root.val);
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
        if (root == null || root.left == null) return root;
        root.left.next = root.right;
        if (root.next != null) root.right.next = root.next.left;
        connect(root.left);
        connect(root.right);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
  /*        int rec = 1, count = 0;
        Deque<Node> res = new LinkedList<Node>();
        if (root == null) return null;
        res.add(root);
        while (!res.isEmpty()) {
            Node temp = res.poll();
            if (++count == rec) {
                rec *= 2;
                count = 0;
            } else temp.next = res.peek();
            if (temp != null)
            if (temp.left != null) res.add(temp.left);
            if (temp.right != null) res.add(temp.right);
        }
        return root;*/