package editor.cn;

import java.util.Scanner;

/**
Given the head of a linked list, remove the nᵗʰ node from the end of the list 
and return its head. 

 
 Example 1: 

 
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
 

 Example 2: 

 
Input: head = [1], n = 1
Output: []
 

 Example 3: 

 
Input: head = [1,2], n = 1
Output: [1]
 

 
 Constraints: 

 
 The number of nodes in the list is sz. 
 1 <= sz <= 30 
 0 <= Node.val <= 100 
 1 <= n <= sz 
 

 
 Follow up: Could you do this in one pass? 
 Related Topics 链表 双指针 👍 1890 👎 0

*/


  public class RemoveNthNodeFromEndOfList{
      public static void main(String[] args) {
           RemoveNthNodeFromEndOfList.Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
          System.out.println("input:");
          Scanner scanner = new Scanner(System.in);
          int num = scanner.nextInt(), i = 1;
          ListNode first = new ListNode(i++), rec = first;

          System.out.print(first.val + " ");
          while (--num != 0) {
              first.next = new ListNode(i++);
              first = first.next;
              System.out.print(first.val + " ");
          }
          System.out.println("");
          ListNode temp = solution.removeNthFromEnd(rec, 4);
          while (temp != null) {
              System.out.print(temp.val + " ");
              temp = temp.next;
          }
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
    int cum = 0;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        head.next = removeNthFromEnd(head.next, n);
        if (++cum == n) return head.next;
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    /*
    *         if (head == null) return null;
        head.next = removeNthFromEnd(head.next, n);
        cum++;
        if (cum == n) return head.next;
        return head;*/
/*    if (head == null || head.next == null) return null;
    editor.cn.ListNode fast = head, slow = head;

        for (int i = 0; i < n; i++) {
        fast = fast.next;
    }
    //当n等于链表长度时，意味着删除第一个结点，此时fast刚好为null
        if (fast == null) {
        return head.next;
    }
        while (fast.next != null) {
        fast = fast.next;
        slow = slow.next;
    }
    slow.next = slow.next.next;
        return head;*/
  }