package editor.cn;

/**
You are given the heads of two sorted linked lists list1 and list2. 

 Merge the two lists in a one sorted list. The list should be made by splicing 
together the nodes of the first two lists. 

 Return the head of the merged linked list. 

 
 Example 1: 

 
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
 

 Example 2: 

 
Input: list1 = [], list2 = []
Output: []
 

 Example 3: 

 
Input: list1 = [], list2 = [0]
Output: [0]
 

 
 Constraints: 

 
 The number of nodes in both lists is in the range [0, 50]. 
 -100 <= Node.val <= 100 
 Both list1 and list2 are sorted in non-decreasing order. 
 
 Related Topics 递归 链表 👍 2296 👎 0

*/
  
  public class MergeTwoSortedLists{
      public static void main(String[] args) {
          Solution solution = new MergeTwoSortedLists().new Solution();
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val > list2.val) {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
        else {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
  /*        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }*/