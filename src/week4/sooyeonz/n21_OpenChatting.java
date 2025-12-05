package week4.sooyeonz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class n21_OpenChatting {

	public static void main(String[] args) {
		String[] record1 = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
			"Change uid4567 Ryan"};

		// 추가 테스트 케이스
		String[] record2 = {"Enter uid1000 A",
			"Enter uid2000 B",
			"Change uid1000 C",
			"Leave uid2000",
			"Enter uid2000 D",
			"Change uid1000 E",
			"Leave uid1000"};

		System.out.println(Arrays.toString(solution(record1)));
		System.out.println(Arrays.toString(solution(record2)));
	}

	private static String[] solution(String[] record) {
		HashMap<String, String> hashMap = new HashMap<>();
		for (String s : record) {
			String[] sp = s.split(" ");
			if (sp[0].equals("Enter") || sp[0].equals("Change")) {
				hashMap.put(sp[1], sp[2]);
			}
		}

		ArrayList<String> result = new ArrayList<>();
		for (String s : record) {
			String[] sp = s.split(" ");
			if (sp[0].equals("Enter")) {
				result.add(hashMap.get(sp[1]) + "님이 들어왔습니다.");
			} else if (sp[0].equals("Leave")) {
				result.add(hashMap.get(sp[1]) + "님이 나갔습니다.");
			}
		}

		return result.toArray(new String[0]);
	}
}
