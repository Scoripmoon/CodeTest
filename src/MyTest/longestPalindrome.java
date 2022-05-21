package MyTest;

/**
 * 5. ������Ӵ� �Ѷ� �е� ����һ���ַ��� s���ҵ� s ����Ļ����Ӵ�������Լ��� s ����󳤶�Ϊ 1000�� ʾ�� 1�� ����:
 * "babad" ���: "bab" ע��: "aba" Ҳ��һ����Ч�𰸡� ʾ�� 2�� ����: "cbbd" ���: "bb"
 *
 */
public class longestPalindrome {
	public static void main(String[] args) {
		String s = "bb";
		System.out.println(longestPalindrome(s));
	}

	public static String longestPalindrome(String s) {
		int length = s.length();
		String StringMax = "";
		for (int i = 0; i < length; i++) {
			if (i == 0) {
				StringMax = s.charAt(i) + "";
				continue;
			}
			String leftstr = s.substring(0, i);
			String rightstr1 = s.substring(i);
			String str1 = getSameCharLength(leftstr, rightstr1, "");

			String rightstr2 = "";
			String str2 = "";
			if (i + 1 < length) {
				rightstr2 = s.substring(i + 1);
				str2 = getSameCharLength(leftstr, rightstr2, s.charAt(i) + "");
			}

			String tmp = str1.length() > str2.length() ? str1 : str2;
			StringMax = tmp.length() > StringMax.length() ? tmp : StringMax;
		}
		return StringMax;
	}

	public static String getSameCharLength(String str1, String str2, String base) {
		int j = str1.length() - 1;
		int i = 0;
		int count = 0;
		while (j >= 0 && i < str2.length()) {
			if ((str1.charAt(j)) != (str2.charAt(i))) {
				break;
			}
			base = str1.charAt(j) + base + str2.charAt(i);
			j--;
			i++;
		}
		return base;
	}
}
