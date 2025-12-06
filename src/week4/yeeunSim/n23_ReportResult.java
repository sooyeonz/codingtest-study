package week4.yeeunSim;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Arrays;

public class n23_ReportResult {

    public static void main(String[] args) {
        String[] id_list1 = {"muzi", "frodo", "apeach", "neo"};
        String[] report1 = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k1 = 2;
        String[] id_list2 = {"con", "ryan"};
        String[] report2 = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k2 = 3;

        System.out.println(Arrays.toString(solution(id_list1, report1, k1)));
        System.out.println(Arrays.toString(solution(id_list2, report2, k2)));
    }

    /**
     * 시간복잡도: O(N)
     */
    private static int[] solution(String[] id_list, String[] report, int k) {
        // 신고당한 유저
        HashMap<String, HashSet<String>> reportedUser = new HashMap<>();
        // 처리 결과 메일을 받은 유저
        HashMap<String, Integer> count = new HashMap<>();

        for (String r : report) {
            String[] s = r.split(" ");
            String userId = s[0];
            String reportedId = s[1];

            if (!reportedUser.containsKey(reportedId)) { // ❷ 신고당한 기록이 없다면
                reportedUser.put(reportedId, new HashSet<>());
            }

            reportedUser.get(reportedId).add(userId);
        }

        for (Map.Entry<String, HashSet<String>> entry : reportedUser.entrySet()) {
            if (entry.getValue().size() >= k) {
                for (String uid : entry.getValue()) {
                    count.put(uid, count.getOrDefault(uid, 0) + 1);
                }
            }
        }

        int[] answer = new int[id_list.length];

        for (int i = 0; i < id_list.length; i++) {
            answer[i] = count.getOrDefault(id_list[i], 0);
        }

        return answer;
    }
}
