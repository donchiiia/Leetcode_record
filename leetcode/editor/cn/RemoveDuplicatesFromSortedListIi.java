import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/**
Given the head of a sorted linked list, delete all nodes that have duplicate 
numbers, leaving only distinct numbers from the original list. Return the linked 
list sorted as well. 

 
 Example 1: 

 
Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]
 

 Example 2: 

 
Input: head = [1,1,1,2,3]
Output: [2,3]
 

 
 Constraints: 

 
 The number of nodes in the list is in the range [0, 300]. 
 -100 <= Node.val <= 100 
 The list is guaranteed to be sorted in ascending order. 
 
 Related Topics 链表 双指针 👍 854 👎 0

*/
  
  public class RemoveDuplicatesFromSortedListIi{
      public static void main(String[] args) {
           Solution solution = new RemoveDuplicatesFromSortedListIi().new Solution();
          ListNode n1 = new ListNode(1);
          ListNode n2 = new ListNode(2);
          n1.next = n2;
          ListNode n3 = new ListNode(3);
          n2.next = n3;
          ListNode n4 = new ListNode(3);
          n3.next = n4;
          ListNode n5 = new ListNode(4);
          n4.next = n5;
          ListNode n6 = new ListNode(4);
          n5.next = n6;
          ListNode n7 = new ListNode(5);
          n6.next = n7;
          ListNode tmp = solution.deleteDuplicates(n1);
          while (tmp != null) {
              System.out.println(tmp.val);
              tmp = tmp.next;
          }
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode res = new ListNode(), i = head, j = head, rec = res;
//        HashSet<Integer> replace = new HashSet<>();
        int recTag = Integer.MAX_VALUE;
        if (head == null || head.next == null) return head;
        else{
            while (j.next != null) {
                j = j.next;
                if (i.val != j.val) {
                    if (recTag != i.val) {
                        res.next = i;
                        res = res.next;
                    }
                } else recTag = j.val;
                i = i.next;
            }
            if (recTag != i.val) {
                res.next = i;
                res = res.next;
            }
            res.next = null;
        }

        return rec.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }