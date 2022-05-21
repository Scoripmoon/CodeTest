package MyTest;

/**
 * �Ѷ��е�4395�ղط����л�ΪӢ�Ĺ�ע�������� ���� �ǿ� ������������ʾ�����Ǹ������������У����Ǹ��Ե�λ���ǰ��� ����
 * �ķ�ʽ�洢�ģ��������ǵ�ÿ���ڵ�ֻ�ܴ洢 һλ ���֡�
 * 
 * ��������ǽ��������������������᷵��һ���µ���������ʾ���ǵĺ͡�
 * 
 * �����Լ���������� 0 ֮�⣬���������������� 0 ��ͷ��
 * 
 * ʾ����
 * 
 * ���룺(2 -> 4 -> 3) + (5 -> 6 -> 4) �����7 -> 0 -> 8 ԭ��342 + 465 = 807
 * 
 * ��Դ�����ۣ�LeetCode�� ���ӣ�https://leetcode-cn.com/problems/add-two-numbers
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * 
 */
public class AddTwoNumbers {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
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
