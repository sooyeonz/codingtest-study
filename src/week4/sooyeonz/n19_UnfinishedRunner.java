package week4.sooyeonz;

import java.util.HashMap;
import java.util.Map;

public class n19_UnfinishedRunner {

	public static void main(String[] args) {
		String[] participant1 = {"leo", "kiki", "eden"};
		String[] completion1 = {"eden", "kiki"};
		String[] participant2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completion2 = {"josipa", "filipa", "marina", "nikola"};
		String[] participant3 = {"mislav", "stanko", "mislav", "ana"};
		String[] completion3 = {"stanko", "ana", "mislav"};

		// 추가 테스트 케이스
		String[] participant4 = {"mislav", "stanko", "mislav", "ana", "mislav"};
		String[] completion4 = {"stanko", "ana", "mislav", "mislav"};

		System.out.println(solution(participant1, completion1));
		System.out.println(solution(participant2, completion2));
		System.out.println(solution(participant3, completion3));
		System.out.println(solution(participant4, completion4));
	}

	private static String solution(String[] participant, String[] completion) {
		HashMap<String, Integer> hashMap = new HashMap<>();
		for (String s : participant) {
			hashMap.put(s, hashMap.getOrDefault(s, 0) + 1);
		}

		for (String s : completion) {
			if (hashMap.containsKey(s)) {
				hashMap.put(s, hashMap.get(s) - 1);
			}
		}

		for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
			if (entry.getValue().equals(1)) {
				return entry.getKey();
			}
		}

		return "";
	}
}
