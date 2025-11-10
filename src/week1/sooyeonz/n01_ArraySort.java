package week1.sooyeonz;

import java.util.Arrays;

public class n01_ArraySort {
	public static void main(String[] args) {
		int[] test1 = {1, -5, 2, 4, 3};
		int[] test2 = {2, 1, 1, 3, 2, 5, 4,};
		int[] test3 = {6, 1, 7};

		// 추가 테스트 케이스
		int[] test4 = {-100, -25, 0, 33, 2, -23};
		int[] test5 = {100, 472365, -37592, 1, 0};

		print(solution(test1));
		print(solution(test2));
		print(solution(test3));
		print(solution(test4));
		print(solution(test5));
	}

	private static int[] solution(int[] arr) {
		int[] copyArray = arr.clone();
		Arrays.sort(copyArray);
		return copyArray;
	}

	private static void print(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}
}
