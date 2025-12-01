package week4.sooyeonz;

import java.util.HashSet;

public class n18_TwoSum {

	public static void main(String[] args) {
		int[] arr1 = {1, 2, 3, 4, 8};
		int target1 = 6;
		int[] arr2 = {2, 3, 5, 9};
		int target2 = 10;

		// 추가 테스트 케이스
		int[] arr3 = {3, 6, 7, 15, 36};
		int target3 = 22;

		System.out.println(solution(arr1, target1));
		System.out.println(solution(arr2, target2));
		System.out.println(solution(arr3, target3));
	}

	private static boolean solution(int[] arr, int target) {
		HashSet<Integer> hashSet = new HashSet<>();

		for (int i : arr) {
			if (hashSet.contains(target - i)) {
				return true;
			}

			hashSet.add(i);
		}

		return false;
	}
}
