package MyTest;

public class Trap {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] height = new int[] { 4, 2, 0, 3, 2, 5 };
		System.out.println(trapDy(height));
	}

	public static int trap(int[] height) {
		int sum = 0;
		for (int i = 1; i < height.length - 1; i++) {

			int leftMax = 0;
			for (int j = 0; j < i; j++) {
				if (leftMax < height[j]) {
					leftMax = height[j];
				}
			}

			int rightMax = 0;
			for (int z = i + 1; z < height.length; z++) {
				if (rightMax < height[z]) {
					rightMax = height[z];
				}
			}
			int minValue = Math.min(leftMax, rightMax);
			sum += Math.max(0, minValue - height[i]);
		}
		return sum;
	}

	public static int trapDy(int[] height) {

		int[] left_max = new int[height.length];
		int[] right_max = new int[height.length];

		for (int i = 1; i < height.length - 1; i++) {
			left_max[i] = Math.max(left_max[i - 1], height[i - 1]);
		}

		for (int i = height.length - 2; i > 0; i--) {
			right_max[i] = Math.max(right_max[i + 1], height[i + 1]);
		}

		int sum = 0;
		for (int i = 1; i < height.length - 1; i++) {

			int leftMax = left_max[i];

			int rightMax = right_max[i];

			int minValue = Math.min(leftMax, rightMax);
			sum += Math.max(0, minValue - height[i]);
		}
		return sum;
	}

}
