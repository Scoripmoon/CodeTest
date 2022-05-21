package MyTest;

import java.awt.List;
import java.util.Arrays;
import java.util.LinkedList;

public class ReconstructQueue {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

	public int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o2[0] - o1[0] : o1[1] - o2[1]);
		
		List<[]int> list = new LinkedList<>();
	}
}
