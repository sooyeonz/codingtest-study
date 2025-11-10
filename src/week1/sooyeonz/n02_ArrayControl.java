package week1.sooyeonz;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class n02_ArrayControl {
	public static void main(String[] args) {
		int[] test1 = {4, 2, 2, 1, 3, 4};
		int[] test2 = {2, 1, 1, 3, 2, 5, 4};

		// 추가 테스트 케이스
		int[] test3 = {-100, -100, -25, 0, 0, 33, 2, -23};
		int[] test4 = {100, 472365, 472365, -37592, 1, 1, 0, 0, 0};

		print(test1);
		print(test2);
		print(test3);
		print(test4);
	}

	private static int[] solution(int[] arr) {
		Set<Integer> arraySet = new TreeSet<>();
		for (int i : arr) {
			arraySet.add(i);
		}

		return arraySet.stream().mapToInt(Integer::intValue).toArray();
	}

	private static void print(int[] arr) {
		System.out.println(Arrays.toString(solution(arr)));
	}
}
