package week4.sooyeonz;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class n23_ReportResult {

	public static void main(String[] args) {
		String[] idList1 = {"muzi", "frodo", "apeach", "neo"};
		String[] report1 = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
		int k1 = 2;
		String[] idList2 = {"con", "ryan"};
		String[] report2 = {"ryan con", "ryan con", "ryan con", "ryan con"};
		int k2 = 3;

		System.out.println(Arrays.toString(solution(idList1, report1, k1)));
		System.out.println(Arrays.toString(solution(idList2, report2, k2)));
	}

	private static int[] solution(String[] idList, String[] report, int k) {
		HashMap<String, HashSet<String>> reportMap = new HashMap<>();
		HashMap<String, Integer> count = new HashMap<>();

		for (String s : report) {
			String[] strings = s.split(" ");
			String userId = strings[0];
			String reportedId = strings[1];

			if (!reportMap.containsKey(reportedId)) {
				reportMap.put(reportedId, new HashSet<>());
			}

			reportMap.get(reportedId).add(userId);
		}

		for (Map.Entry<String, HashSet<String>> entry : reportMap.entrySet()) {
			if (entry.getValue().size() >= k) {
				for (String s : entry.getValue()) {
					count.put(s, count.getOrDefault(s, 0) + 1);
				}
			}
		}

		int[] answer = new int[idList.length];

		for (int i = 0; i < idList.length; i++) {
			answer[i] = count.getOrDefault(idList[i], 0);

		}

		return answer;
	}
}
