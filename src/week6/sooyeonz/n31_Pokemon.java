package week6.sooyeonz;

import java.util.HashSet;

public class n31_Pokemon {

	public static void main(String[] args) {
		int[] nums1 = {3, 1, 2, 3};
		int[] nums2 = {3, 3, 3, 2, 2, 4};
		int[] nums3 = {3, 3, 3, 2, 2, 2};

		System.out.println(solution(nums1));
		System.out.println(solution(nums2));
		System.out.println(solution(nums3));
	}

	private static int solution(int[] nums) {

		int k = nums.length / 2;

		HashSet<Integer> hashSet = new HashSet<>();
		for (int num : nums) {
			hashSet.add(num);
		}

		return hashSet.size() > k ? k : hashSet.size();
	}
}
