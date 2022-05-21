package MyTest;

/**
 * ���� n ���Ǹ����� a1��a2��...��an��ÿ�������������е�һ���� (i, ai) ���������ڻ� n ����ֱ�ߣ���ֱ�� i �������˵�ֱ�Ϊ (i,
 * ai) �� (i, 0)���ҳ����е������ߣ�ʹ�������� x �Ṳͬ���ɵ�����������������ˮ��
 * 
 * ˵�����㲻����б�������� n ��ֵ����Ϊ 2��
 * 
 * ��Դ�����ۣ�LeetCode�� ���ӣ�https://leetcode-cn.com/problems/container-with-most-water
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 * ���룺[1,8,6,2,5,4,8,3,7] �����49
 */
public class maxArea {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int[] a = new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		System.err.println(maxArea(a));
	}

	public static int maxArea(int[] height) {
		int left = 0;
		int right = height.length - 1;
		int max = 0;
		int maxleft = left;
		int maxright = right;
		while (left != right) {
			int area = (right - left) * Math.min(height[left], height[right]);
			if (area > max) {
				max = area;
				maxleft = left;
				maxleft = right;
			}
			if (height[left] >= height[right]) {
				right--;
			} else {
				left++;
			}
		}
		return max;
	}

}
