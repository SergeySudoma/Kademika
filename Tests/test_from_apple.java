package Test;

import java.util.Arrays;

public class test_from_apple {

	static int max1;
	static int max2;
	static int max3;

	public static void main(String[] args) {

		int[] list = { -4, -3, -2, -1 };

		findMaxComp(list);

	}

	public static void findMaxComp(int[] list) {

		Arrays.sort(list);

		if (list.length < 3) {
			System.out.println("array has less than 3 elems");
		} else {

			if (list[0] > 0 || list[0] < 0 && list[1] > 0 || list[0] < 0
					&& list[list.length - 1] <= 0) {
				max1 = list[list.length - 1];
				max2 = list[list.length - 2];
				max3 = list[list.length - 3];
				print();
			}

			else if (list[0] < 0 && list[1] < 0) {
				max1 = list[0];
				max2 = list[1];
				max3 = list[list.length - 1];
				print();
			}
		}
	}

	private static void print() {
		System.out.println(max1 * max2 * max3);
	}
}
