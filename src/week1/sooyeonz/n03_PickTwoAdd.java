package week1.sooyeonz;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class n03_PickTwoAdd {
	public static void main(String[] args) {
		int[] test1 = {2, 1, 3, 4, 1};
		int[] test2 = {5, 0, 2, 7};

		// 추가 테스트 케이스
		int[] test3 = {5, 0, 12, 4, 59};
		int[] test4 = {21, 13, 3, 4, 1, 1, 20};

		System.out.println(Arrays.toString(solution(test1)));
		System.out.println(Arrays.toString(solution(test2)));
		System.out.println(Arrays.toString(solution(test3)));
		System.out.println(Arrays.toString(solution(test4)));
	}

	private static int[] solution(int[] arr) {
		Set<Integer> result = new TreeSet<>();

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				result.add(arr[i] + arr[j]);
			}
		}
		return result.stream().mapToInt(Integer::intValue).toArray();
	}
}
