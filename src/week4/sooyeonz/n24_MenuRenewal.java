package week4.sooyeonz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class n24_MenuRenewal {

	private static HashMap<Integer, HashMap<String, Integer>> courseMap;

	public static void main(String[] args) {
		String[] orders1 = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] course1 = {2, 3, 4};
		String[] orders2 = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
		int[] course2 = {2, 3, 5};
		String[] orders3 = {"XYZ", "XWY", "WXA"};
		int[] course3 = {2, 3, 4};

		System.out.println(Arrays.toString(solution(orders1, course1)));
		System.out.println(Arrays.toString(solution(orders2, course2)));
		System.out.println(Arrays.toString(solution(orders3, course3)));
	}

	private static String[] solution(String[] orders, int[] course) {
		courseMap = new HashMap<>();
		for (int i : course) {
			courseMap.put(i, new HashMap<>());
		}

		for (String order : orders) {
			char[] orderArray = order.toCharArray();
			Arrays.sort(orderArray);
			combinations(0, orderArray, "");
		}

		ArrayList<String> answer = new ArrayList<>();

		for (HashMap<String, Integer> count : courseMap.values()) {
			count.values()
				.stream()
				.max(Comparator.comparingInt(o -> o))
				.ifPresent(cnt -> count.entrySet()
					.stream()
					.filter(entry -> cnt.equals(entry.getValue()) && cnt > 1)
					.forEach(entry -> answer.add(entry.getKey())));
		}
		Collections.sort(answer);
		return answer.toArray(new String[0]);
	}

	private static void combinations(int idx, char[] order, String result) {
		if (courseMap.containsKey(result.length())) {
			HashMap<String, Integer> map = courseMap.get(result.length());
			map.put(result, map.getOrDefault(result, 0) + 1);
		}

		for (int i = idx; i < order.length; i++) {
			combinations(i + 1, order, result + order[i]);
		}
	}
}
