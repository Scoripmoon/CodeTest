package MyTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 86153
 *
 */
public class GenerateParenthesis {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		generateParenthesis(3);
		System.err.println(generateParenthesis(3).toString());
	}

	public static List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		if (n <= 0) {
			return res;
		}
		GenStringF("", n, n, res);
		return res;
	}

	public static List<String> GenString(int n) {
		if (n == 0) {
			return new ArrayList<String>();
		}
		Set<String> tmp = new HashSet<String>();
		if (n >= 1) {
			tmp.add("()");
		}
		Set<String> result = getF(new HashSet<String>(), n, 1);
		return new ArrayList<String>(result);
	}

	public static Set<String> getF(Set<String> result, int aim, int cur) {
		if (aim == cur) {
			return result;
		}
		Set<String> tmp = new HashSet<String>();
		for (String s : result) {
			for (int i = 0; i < s.length(); i++) {
				// 每个位置插入"()"
				tmp.add(s.substring(0, i) + "()" + s.substring(i, s.length()));
			}
		}
		return getF(tmp, aim, cur + 1);
	}

	/**
	 * 深度优先
	 * 
	 * @param path
	 * @param left
	 * @param right
	 * @param result
	 */
	public static void GenStringF(String path, int left, int right, List<String> result) {
		if (left == 0 && right == 0) {
			result.add(path);
			return;
		}
		if (left > right) { // 情况不可能
			return;
		}
		if (left > 0) {
			GenStringF(path + "(", left - 1, right, result);
		}
		if (right > 0) {
			GenStringF(path + ")", left, right - 1, result);
		}
	}

}
