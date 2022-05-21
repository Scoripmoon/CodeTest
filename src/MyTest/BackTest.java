package MyTest;

public class BackTest {
	private int value[] = new int[] { 1, 2, 4, 5 };
	private int state[] = new int[4];

	public static void main(String[] args) throws Exception {
		BackTest backTest = new BackTest();
		backTest.back(0);
	}

	public void back(int t) {
		if (t >= state.length) {
			print();
			return;
		}
		state[t] = 0;
		if (isall2(t)) {
			back(t + 1);
		}

		state[t] = 1;
		if (isall2(t)) {
			back(t + 1);
		}
	}

	private void print() {
		for (int i = 0; i < state.length; i++) {
			if (state[i] == 1) {
				System.out.print(value[i]);
			}
		}
		System.out.println();
	}

	private boolean isall2(int t) {
		for (int i = 0; i <= t; i++) {
			if (state[i] == 1 && value[i] % 2 != 0) {
				return false;
			}
		}
		return true;
	}

}
