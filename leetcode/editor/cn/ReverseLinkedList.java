package editor.cn;

/**
Given the head of a singly linked list, reverse the list, and return the 
reversed list. 

 
 Example 1: 

 
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
 

 Example 2: 

 
Input: head = [1,2]
Output: [2,1]
 

 Example 3: 

 
Input: head = []
Output: []
 

 
 Constraints: 

 
 The number of nodes in the list is the range [0, 5000]. 
 -5000 <= Node.val <= 5000 
 

 
 Follow up: A linked list can be reversed either iteratively or recursively. 
Could you implement both? 
 Related Topics 递归 链表 👍 2397 👎 0

*/
  
  public class ReverseLinkedList{
      public static void main(String[] args) {
           Solution solution = new ReverseLinkedList().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class editor.cn.ListNode {
 *     int val;
 *     editor.cn.ListNode next;
 *     editor.cn.ListNode() {}
 *     editor.cn.ListNode(int val) { this.val = val; }
 *     editor.cn.ListNode(int val, editor.cn.ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }