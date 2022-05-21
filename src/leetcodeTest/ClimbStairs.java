package leetcodeTest;

public class ClimbStairs {

	public static void main(String[] args) {

		System.out.println(climbStairs(3));
	}

	public static int climbStairs(int n) {

		int[] result = new int[n];
		result[0] = 1;
		result[1] = 2;

		for (int i = 2; i < n; i++) {
			result[i] = result[i - 1] + result[i - 2];
		}
		return result[n - 1];
	}
}
