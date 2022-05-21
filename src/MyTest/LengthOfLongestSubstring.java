package MyTest;

import java.util.HashSet;

/**
 * ����һ���ַ����������ҳ����в������ظ��ַ��� ��Ӵ� �ĳ��ȡ�
 * 
 * ʾ�� 1:
 * 
 * ����: "abcabcbb" ���: 3 ����: ��Ϊ���ظ��ַ�����Ӵ��� "abc"�������䳤��Ϊ 3��
 * 
 * 
 * ʾ�� 2:
 * 
 * ����: "bbbbb" ���: 1 ����: ��Ϊ���ظ��ַ�����Ӵ��� "b"�������䳤��Ϊ 1��
 * 
 * 
 * ʾ�� 3:
 * 
 * ����: "pwwkew" ���: 3 ����: ��Ϊ���ظ��ַ�����Ӵ��� "wke"�������䳤��Ϊ 3�� ��ע�⣬��Ĵ𰸱����� �Ӵ�
 * �ĳ��ȣ�"pwke" ��һ�������У������Ӵ���
 * 
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 */
public class LengthOfLongestSubstring {

	public static void main(String[] args) {

	}

	public int lengthOfLongestSubstring(String s) {

		if (s == null || s.isEmpty()) {
			return 0;
		}
		HashSet<Character> maxCharacter = new HashSet<Character>();

		int length = s.length();
		int max = 1;

		int index = 0;
		for (int i = 0; i < length; i++) {

			while (index < length && !maxCharacter.contains(s.charAt(index))) {
				maxCharacter.add(s.charAt(index));
				index++;
			}
			max = Math.max(max, maxCharacter.size());
			maxCharacter.remove(s.charAt(i));
		}
		return max;
	}
}
