package MyTest;

import java.util.Stack;

public class SignisValid {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

	public static boolean isValid(String s) {
		if (s.isEmpty()) {
			return true;
		}
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == '(') {
				stack.push(')');
			} else if (c == '{') {
				stack.push('}');
			} else if (c == '[') {
				stack.push(']');
			} else if (c != stack.pop()) {
				return false;
			}
		}
		if (stack.isEmpty()) {
			return true;
		}
		return false;
		// if (s.isEmpty())
		// return true;
		// Stack<Character> stack = new Stack<Character>();
		// for (char c : s.toCharArray()) {
		// if (c == '(')
		// stack.push(')');
		// else if (c == '{')
		// stack.push('}');
		// else if (c == '[')
		// stack.push(']');
		// else if (stack.empty() || c != stack.pop())
		// return false;
		// }
		// if (stack.empty())
		// return true;
		// return false;
	}

}
