package leetcodeTest;

public class searchInsert {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] nums = { 1, 2, 5, 6 };
		int index = searchInsert(nums, 0);
		System.out.println(index);
	}

	public static int searchInsert(int[] nums, int target) {
		int midIndex = 0;
		if (nums.length == 0) {
			return midIndex;
		}

		int startIndex = 0;
		int endTndex = nums.length - 1;

		while (startIndex <= endTndex) {
			if (target == nums[startIndex]) {
				return startIndex;
			}
			if (target == nums[endTndex]) {
				return endTndex;
			}
			midIndex = (startIndex + endTndex) / 2;
			if (target == nums[midIndex]) {
				return midIndex;
			}

			if (target < nums[midIndex]) {
				endTndex = midIndex - 1;
			} else {
				startIndex = midIndex + 1;
			}
		}
		return startIndex;

		// if (target < nums[startIndex]) {
		// return startIndex;
		// } else {
		// return startIndex + 1;
		// }
	}

}
