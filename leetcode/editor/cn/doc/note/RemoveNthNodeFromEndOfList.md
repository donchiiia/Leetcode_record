---
- 思路一：双指针，快指针先移动到n的位置，然后快慢指针同时移动，直到快指针到队尾时，慢指针刚好为待删除的前一位

```java
import editor.cn.ListNode;

class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || head.next == null) return null;
		ListNode fast = head, slow = head;
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
		return head;
	}
}
```

- 思路二：对下一个结点进行递归，并在递归之后记录次数（该次数就是从最底层向上的次数），当次数等于目标值就可向上层不断返回正确值

```java
import editor.cn.ListNode;

class Solution {
	int cum = 0;

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) return null;
		head.next = removeNthFromEnd(head.next, n);
		cum++;
		if (cum == n) return head.next;
		return head;
	}
}
```