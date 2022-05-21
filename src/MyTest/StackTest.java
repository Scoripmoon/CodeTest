package MyTest;

public class StackTest {
	public Node root;
	public int num;

	class Node {
		public Node nextNode;
		public int value;

		public Node(int value) {
			this.value = value;
		}
	}

	public int put(int value) {
		Node node = new Node(value);
		if (root == null) {
			root = node;
			return value;
		}
		// node.nextNode = root;
		// root = node;
		// return value;

		// ╤сап
		Node nextNode = root;
		if (nextNode == null) {
			nextNode = node;
			return value;
		}
		while (nextNode != null) {
			if (nextNode.nextNode == null) {
				nextNode.nextNode = node;
				return value;
			}
			nextNode = nextNode.nextNode;
		}
		return -1;
	}

	public int pop() {
		if (root == null) {
		}
		int value = root.value;
		Node next = root.nextNode;
		root.nextNode = null;
		root = next;
		return value;
	}

	public void resrve() {
		Node next = null;
		Node prePare = null;
		Node currentNode = root;

		while (currentNode != null) {
			next = currentNode.nextNode;
			currentNode.nextNode = prePare;
			prePare = currentNode;
			currentNode = next;
		}

	}

}
