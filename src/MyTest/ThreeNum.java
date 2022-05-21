package MyTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeNum {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		// int[] nums = { -1, 0, 1, 2, -1, -4 };

		int[] nums = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

		// threeSum(nums);
		// System.out.println(threeSumClosest(nums, 82));

		System.out.println(trap(nums));

	}

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(nums);

		if (nums.length < 3) {
			return result;
		}

		for (int i = 0; i < nums.length - 2; i++) {

			int left = i + 1;
			int right = nums.length - 1;

			int curValue = nums[i];

			while (left < right) {
				int sum = curValue + nums[left] + nums[right];
				if (sum == 0) {
					List<Integer> tmp = new ArrayList<Integer>();
					tmp.add(curValue);
					tmp.add(nums[left]);
					tmp.add(nums[right]);
					result.add(tmp);

					while (nums[left] == nums[left + 1] && (left + 1) < right) {
						left++;
					}
					while (nums[right] == nums[right - 1] && left < right) {
						right--;
					}
					left++;
					right--;

				} else if (sum < 0) {
					left++;
				} else {
					right--;
				}
			}

			while ((i + 1) < nums.length - 2 && nums[i] == nums[i + 1]) {
				i++;
				continue;
			}
		}
		return result;
	}

	public static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);

		int sum = nums[0] + nums[1] + nums[2];

		for (int i = 0; i < nums.length - 2; i++) {
			int left = i + 1;
			int right = nums.length - 1;

			while (left < right) {
				int tmp = nums[i] + nums[left] + nums[right];
				if (Math.abs(target - tmp) < Math.abs(target - sum)) {
					sum = tmp;
				}
				if (sum == target) {
					return sum;
				} else if (tmp > target) {
					right--;
				} else {
					left++;
				}
			}
		}
		return sum;

	}

	public boolean containsDuplicate(int[] nums) {
		Set<Integer> tmp = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			tmp.add(nums[i]);
		}
		return nums.length != tmp.size();
	}

	public int findKthLargest(int[] nums, int k) {

		// Arrays.sort(nums, new Comparator<Integer>() {
		// public int compare(Integer a, Integer b) {
		// return b - a;
		// }
		// });
		//
		// List<Integer> tmp = new ArrayList<Integer>();
		// tmp.ad
		//
		// Arrays.sort(nums, Collections.reverseOrder());
		//
		// int[] tmp = new int[nums.length];
		// int j = 0;
		// for (int i = 0; i < nums.length; i++) {
		// if (i != 0 && nums[i] == nums[i - 1]) {
		// continue;
		// }
		// tmp[j] = nums[i];
		// j++;
		// }
		// return tmp[tmp.length - K];

		Arrays.sort(nums);

		return nums[nums.length - k];
	}

	public static int trap(int[] height) {
		int sum = 0;
		for (int h = 1; h <= GetMax(height); h++) {
			int curSum = 0;
			for (int i = 0; i < height.length; i++) {
				int left = i - 1;
				int right = i + 1;
				if (left <= 0 || right >= height.length) {
					continue;
				}

				if (height[i] >= h) {
					continue;
				}

				boolean leftFlag = false;
				while (left >= 0) {
					if (height[left] < h) {
						left--;
						continue;
					}
					if (height[left] > height[i]) {
						leftFlag = true;
						break;
					}
					left--;
				}

				boolean rightFlag = false;
				while (right < height.length) {
					if (height[right] < h) {
						right++;
						continue;
					}
					if (height[right] > height[i]) {
						rightFlag = true;
						break;
					}
					right++;
				}
				if (leftFlag && rightFlag) {
					curSum++;
				}
				continue;
			}
			sum += curSum;
		}
		return sum;
	}

	public static int GetMax(int[] height) {
		int max = 0;
		for (int i = 0; i < height.length; i++) {
			if (max < height[i]) {
				max = height[i];
			}
		}
		return max;
	}

}
