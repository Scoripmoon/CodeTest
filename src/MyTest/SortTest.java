package MyTest;

import java.util.Arrays;
import java.util.Random;

public class SortTest {

	public static void main(String[] args) {
		int a[] = new int[2];
		for (int i = 0; i < 2; i++) {
			a[i] = new Random().nextInt(100);
		}
		quickSort(a, 0, a.length - 1);
		System.out.println("ÅÅÐò½á¹û£º" + Arrays.toString(a));
	}

	private static void chooseSort(int array[]) {
		for (int i = 0; i < array.length; i++) {
			int min = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[min] > array[j]) {
					swap(array, min, j);
				}
			}
		}
	}

	private static void buddleSort(int array[]) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - i; j++) {
				if (array[j] > array[j + 1]) {
					swap(array, j, j + 1);
				}
			}
		}
	}

	private static void insetSort(int array[]) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i; j > 0; j--) {
				if (array[j] < array[j - 1]) {
					swap(array, j, j - 1);
				}
			}
		}
	}

	private static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	private static void Sort(int[] array, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			Sort(array, left, mid);
			Sort(array, mid + 1, right);
			merge(array, left, mid, right);
		}
	}

	private static void merge(int[] array, int left, int mid, int right) {
		int temp[] = new int[right - left + 1];
		int i = left;
		int j = mid + 1;

		int tempNum = 0;
		while (i <= mid && j <= right) {
			if (array[i] <= array[j]) {
				temp[tempNum] = array[i];
				i++;
				tempNum++;
			} else {
				temp[tempNum] = array[j];
				j++;
				tempNum++;
			}
		}

		while (i <= mid) {
			temp[tempNum] = array[i];
			i++;
			tempNum++;
		}

		while (j <= right) {
			temp[tempNum] = array[j];
			j++;
			tempNum++;
		}

		for (int k = 0; k < right - left + 1; k++) {
			array[left++] = temp[k];
		}
	}

	private static void quickSort(int[] array, int left, int right) {
		if (left < right) {
			prepare(array, left, right);

			int i = left;
			int j = right - 1;

			int value = array[right - 1];
			while (i != j) {
				if (array[i] <= value) {
					i++;
					continue;
				}

				if (array[j] > value) {
					j--;
					continue;
				}
				swap(array, i, j);
			}
			if (array[i] > value) {
				swap(array, i, right - 1);
			}
			quickSort(array, left, i);
			quickSort(array, i + 1, right);
		}

	}

	private static void prepare(int[] array, int left, int right) {
		int mid = (left + right) / 2;
		if (array[left] > array[mid]) {
			swap(array, left, mid);
		}

		if (array[left] > array[right]) {
			swap(array, left, right);
		}

		if (array[mid] > array[right]) {
			swap(array, mid, right);
		}

		swap(array, mid, right - 1);
	}

}
