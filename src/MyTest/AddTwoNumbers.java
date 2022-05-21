package MyTest;

/**
 * 难度中等4395收藏分享切换为英文关注反馈给出 两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序
 * 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 * 示例：
 * 
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) 输出：7 -> 0 -> 8 原因：342 + 465 = 807
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 */
public class AddTwoNumbers {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		ListNode a1 = new ListNode(9);
		ListNode a2 = new ListNode(9);
		a1.next = a2;
		// ListNode a3 = new ListNode(3);
		// a2.next = a3;
		// System.out.println(ListNode.Print(a1));

		ListNode a4 = new ListNode(1);
		// ListNode a5 = new ListNode(6);
		// a4.next = a5;
		// ListNode a6 = new ListNode(4);
		// a5.next = a6;
		// System.out.println(ListNode.Print(a4));

		ListNode result = addTwoNumbers(a1, a4);
		System.out.println(ListNode.Print(result));
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode startNode = null;
		ListNode newNode = null;
		int add = 0;
		while (l1 != null && l2 != null) {
			int value = l1.val + l2.val + add;
			if (value >= 10) {
				value = value % 10;
				add = 1;
			} else {
				add = 0;
			}

			if (newNode == null) {
				newNode = new ListNode(value);
				startNode = newNode;
			} else {
				newNode.next = new ListNode(value);
				newNode = newNode.next;
			}
			l1 = l1.next;
			l2 = l2.next;
		}
		while (l1 != null) {
			int value = l1.val + add;
			if (value >= 10) {
				value = value % 10;
				add = 1;
			} else {
				add = 0;
			}

			if (newNode == null) {
				newNode = new ListNode(value);
				startNode = newNode;
			} else {
				newNode.next = new ListNode(value);
				newNode = newNode.next;
			}
			l1 = l1.next;
		}
		while (l2 != null) {
			int value = l2.val + add;
			if (value >= 10) {
				value = value % 10;
				add = 1;
			} else {
				add = 0;
			}
			if (newNode == null) {
				newNode = new ListNode(value);
				startNode = newNode;
			} else {
				newNode.next = new ListNode(value);
				newNode = newNode.next;
			}
			l2 = l2.next;
		}
		if (add == 1) {
			if (newNode == null) {
				newNode = new ListNode(1);
				startNode = newNode;
			} else {
				newNode.next = new ListNode(1);
				newNode = newNode.next;
			}
		}
		return startNode;
	}

	public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
		ListNode startNode = null;
		ListNode newNode = null;
		int add = 0;
		while (l1 != null || l2 != null || add != 0) {
			int l1Value = 0;
			if (l1 != null) {
				l1Value = l1.val;
			}

			int l2Value = 0;
			if (l2 != null) {
				l2Value = l2.val;
			}

			int value = l1Value + l2Value + add;
			if (value >= 10) {
				value = value % 10;
				add = 1;
			} else {
				add = 0;
			}
			if (newNode == null) {
				newNode = new ListNode(value);
				startNode = newNode;
			} else {
				newNode.next = new ListNode(value);
				newNode = newNode.next;
			}

			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
		}
		return startNode;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
	}

	public static String Print(ListNode listNode) {
		String str = listNode.val + "";
		while (listNode.next != null) {
			str = str + " ->" + listNode.next.val;
			listNode = listNode.next;
		}
		return str;
	}
}
