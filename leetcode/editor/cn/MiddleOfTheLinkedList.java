import java.util.Scanner;

/**
Given the head of a singly linked list, return the middle node of the linked 
list. 

 If there are two middle nodes, return the second middle node. 

 
 Example 1: 

 
Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.
 

 Example 2: 

 
Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return 
the second one.
 

 
 Constraints: 

 
 The number of nodes in the list is in the range [1, 100]. 
 1 <= Node.val <= 100 
 
 Related Topics 链表 双指针 👍 520 👎 0

*/
  
  public class MiddleOfTheLinkedList{
      public static void main(String[] args) {
           Solution solution = new MiddleOfTheLinkedList().new Solution();
          System.out.println("input:");
          Scanner scanner = new Scanner(System.in);
          int num = scanner.nextInt();
          ListNode first = new ListNode((int)(Math.random() * 100) + 1), rec = first;

          System.out.print(first.val + " ");
          while (--num != 0) {
              first.next = new ListNode((int) (Math.random() * 100) + 1);
              first = first.next;
              System.out.print(first.val + " ");
          }
          System.out.println("");
          ListNode temp = solution.middleNode(rec);
          while (temp.next != null) {
              System.out.print(temp.val + " ");
              temp = temp.next;
          }
          System.out.print(temp.val);
      }

      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode first = head, second = head;
        while (second.next != null) {
            if (second.next.next != null) {
                second = second.next.next;
            } else second = second.next;
            first = first.next;
        }
        return first;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
  /*
  *         ListNode fast = head, slow = head;

        while (fast.next != null) {
            if (fast.next.next == null) {
                fast = fast.next;
            }
            else fast = fast.next.next;
            slow = slow.next;
        }
        return slow;*/