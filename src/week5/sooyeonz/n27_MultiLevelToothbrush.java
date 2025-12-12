package week5.sooyeonz;

import java.util.Arrays;
import java.util.HashMap;

public class n27_MultiLevelToothbrush {

	public static void main(String[] args) {
		String[] enroll1 = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] referral1 = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] seller1 = {"young", "john", "tod", "emily", "mary"};
		int[] amount1 = {12, 4, 2, 5, 10};
		String[] enroll2 = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] referral2 = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] seller2 = {"sam", "emily", "jaimie", "edward"};
		int[] amount2 = {2, 3, 5, 4};

		System.out.println(Arrays.toString(solution(enroll1, referral1, seller1, amount1)));
		System.out.println(Arrays.toString(solution(enroll2, referral2, seller2, amount2)));
	}

	private static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		HashMap<String, String> parent = new HashMap<>();
		for (int i = 0; i < enroll.length; i++) {
			parent.put(enroll[i], referral[i]);
		}

		HashMap<String, Integer> total = new HashMap<>();

		for (int i = 0; i < seller.length; i++) {
			String curName = seller[i];
			int money = amount[i] * 100;
			while (money > 0 && !curName.equals("-")) {
				total.put(curName, total.getOrDefault(curName, 0) + money - (money / 10));
				curName = parent.get(curName);
				money /= 10;
			}
		}

		int[] answer = new int[enroll.length];
		for (int i = 0; i < enroll.length; i++) {
			answer[i] = total.getOrDefault(enroll[i], 0);
		}

		return answer;
	}
}
