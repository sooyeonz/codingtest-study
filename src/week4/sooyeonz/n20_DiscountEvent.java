package week4.sooyeonz;

import java.util.HashMap;

public class n20_DiscountEvent {

	public static void main(String[] args) {
		String[] want1 = {"banana", "apple", "rice", "pork", "pot"};
		int[] number1 = {3, 2, 2, 2, 1};
		String[] discount1 = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice",
			"pot", "banana", "apple", "banana"};
		String[] want2 = {"apple"};
		int[] number2 = {10};
		String[] discount2 = {"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana",
			"banana"};

		// 추가 테스트 케이스
		String[] want3 = {"apple", "banana", "rice", "meat"};
		int[] number3 = {3, 2, 3, 2};
		String[] discount3 = {"bread", "apple", "banana", "apple", "rice",
			"rice", "meat", "rice", "banana", "apple",
			"meat", "rice", "apple", "banana", "rice"};

		System.out.println(solution(want1, number1, discount1));
		System.out.println(solution(want2, number2, discount2));
		System.out.println(solution(want3, number3, discount3));
	}

	private static int solution(String[] want, int[] number, String[] discount) {
		HashMap<String, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < want.length; i++) {
			hashMap.put(want[i], number[i]);
		}

		int result = 0;
		for (int i = 0; i < discount.length - 9; i++) {
			HashMap<String, Integer> discountMap = new HashMap<>();

			for (int j = i; j < i + 10; j++) {
				discountMap.put(discount[j], discountMap.getOrDefault(discount[j], 0) + 1);
			}

			if (discountMap.equals(hashMap)) {
				result++;
			}
		}

		return result;
	}
}
