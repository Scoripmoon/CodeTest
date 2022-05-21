package MyTest;

public class BagTest {
	private static int weight[] = new int[] { 0, 2, 3, 4, 5 };
	private static int value[] = new int[] { 0, 3, 4, 5, 6 };
	private static int bag = 8;

	private static int deph[][] = new int[5][9];

	private static int item[] = new int[5];

	public static void main(String[] args) throws Exception {
		System.err.println(maxValue());
	}

	private static int maxValue() {
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 8; j++) {
				if (j < weight[i]) {
					deph[i][j] = deph[i - 1][j];
				} else {
					deph[i][j] = Math.max(deph[i - 1][j], deph[i - 1][j - weight[i]] + value[i]);
				}
			}
		}
		findItem(4, 8);
		return deph[4][8];
	}

	private static void findItem(int i, int j) {
		if (i <= 0) {
			for (int k = 0; i < 5; i++) {
				if (item[i] == 1) {
					System.err.println(i);
				}
			}
			return;
		}
		if (deph[i][j] == deph[i - 1][j]) {
			item[i] = 0;
			findItem(i - 1, j);
		} else {
			item[i] = 1;
			findItem(i - 1, j - weight[i]);
		}
	}

}
