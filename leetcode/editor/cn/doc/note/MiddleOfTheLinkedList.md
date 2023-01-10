---
- 求链表中间结点的值也可以考虑双指针
- 当fast.next.next!=null时，让fast指针等于fast.next.next，一次性跳两个位置，而对应的slow指针一次性跳一个位置，就可以保证
当fast为尾端时，slow为中间位置。

```java
import editor.cn.ListNode;

class Solution {
	public ListNode middleNode(ListNode head) {
		ListNode fast = head, slow = head;

		while (fast.next != null) {
			if (fast.next.next == null) {
				fast = fast.next;
			} else fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
}
```