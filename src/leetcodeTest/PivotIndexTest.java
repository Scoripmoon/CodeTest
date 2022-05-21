package leetcodeTest;

public class PivotIndexTest {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] nums = { 1, 7, 3, 6, 5, 6 };
		int[] nums = { 1, 2, 3 };
		int midIndex = pivotIndex(nums);
		System.out.println(midIndex);
	}

	public static int pivotIndex(int[] nums) {

		if (nums.length <= 0) {
			return -1;
		}
		int index = -1;
		for (int i = 0; i < nums.length; i++) {
			int leftTotal = Sum(nums, 0, i - 1);
			int rightTotal = Sum(nums, i + 1, nums.length - 1);
			if (leftTotal == rightTotal) {
				index = i;
				break;
			}
		}
		return index;
	}

	public static int Sum(int[] nums, int startIndex, int endIndex) {
		int total = 0;
		if (endIndex < 0 || startIndex >= nums.length) {
			return total;
		}
		for (int i = startIndex; i <= endIndex; i++) {
			total += nums[i];
		}
		return total;
	}
}
