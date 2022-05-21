package MyTest;

import java.util.ArrayList;

public class TestGs {
	public static void main(String[] args) throws Exception {

		int num1[] = { 1, 2 };
		int num2[] = { 3, 4 };
		// search(num, 9);
		findMedianSortedArrays(num1, num2);
	}

	// 2·Ö²éÕÒ
	private static int binarySearch(int[] array, int left, int right, int value) {
		if (left > right) {
			return -1;
		}
		int mid = (left + right) / 2;
		int midValue = array[mid];
		if (midValue == value) {
			return mid;
		} else if (midValue > value) {
			return binarySearch(array, left, mid - 1, value);
		} else {
			return binarySearch(array, mid + 1, right, value);
		}
	}

	private static int Fn(int n) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(1);
		if (n == 1 || n == 2) {
			return 1;
		}

		for (int i = 3; i <= n; i++) {
			int value = list.get(i - 2) + list.get(i - 3);
			list.add(value);
		}
		return list.get(list.size() - 1);
	}

	private static void H(int n, char start, char help, char end) {
		if (n == 1) {
			System.out.println(start + "----" + end);
			return;
		}
		H(n - 1, start, end, help);
		System.out.println(start + "----" + end);
		H(n - 1, help, start, end);
	}

	public static int search(int[] nums, int target) {
		return Find(nums, target, 0, nums.length - 1);
	}

	private static int Find(int num[], int target, int left, int right) {
		if (num.length <= 0) {
			return -1;
		}
		if (left > right) {
			return -1;
		}
		int midIndex = (left + right) / 2;
		if (target == num[midIndex]) {
			return midIndex;
		} else if (target > num[midIndex]) {
			return Find(num, target, midIndex + 1, right);
		} else {
			return Find(num, target, left, midIndex - 1);
		}
	}

	public static int searchWhile(int[] nums, int target) {
		if (nums.length <= 0) {
			return -1;
		}
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int midIndex = (left + right) / 2;
			if (target == nums[midIndex]) {
				return midIndex;
			}
			if (target > nums[midIndex]) {
				left = midIndex + 1;
			} else {
				right = midIndex - 1;
			}
		}
		return -1;
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int index1 = 0;
		int index2 = 0;

		int totalCount = nums1.length + nums2.length;
		int[] numTmp = new int[totalCount];

		int i = 0;
		while (index1 != nums1.length || index2 != nums2.length) {
			if (index1 == nums1.length) {
				numTmp[i] = nums2[index2];
				index2++;
				i++;
				continue;
			}
			if (index2 == nums2.length) {
				numTmp[i] = nums1[index1];
				index1++;
				i++;
				continue;
			}
			if (nums1[index1] < nums2[index2]) {
				numTmp[i] = nums1[index1];
				index1++;
			} else {
				numTmp[i] = nums2[index2];
				index2++;
			}
			i++;
		}

		if (numTmp.length % 2 > 0) {
			return numTmp[numTmp.length / 2];
		} else {
			return (numTmp[numTmp.length / 2] + numTmp[(numTmp.length / 2) + 1]) / 2.0;
		}
	}
}
