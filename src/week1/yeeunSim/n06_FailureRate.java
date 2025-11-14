package week1.yeeunSim;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 시간복잡도: O(L + N log N)
 * L: stages 배열의 길이 (총 사용자 수, 최대 200,000)
 * N: 스테이지의 개수 (최대 500)
 */
public class n06_FailureRate {

    public static void main(String[] args) {
        int N1 = 5;
        int[] stages1 = {2, 1, 2, 6, 2, 4, 3, 3};

        int N2 = 4;
        int[] stages2 = {4, 4, 4, 4, 4};

        System.out.println(Arrays.toString(solution(N1, stages1)));
        System.out.println(Arrays.toString(solution(N2, stages2)));
    }

    public static int[] solution(int N, int[] stages) {
        // ❶ 스테이지별 도전자 수를 구함
        int[] challenger = new int[N + 2];
        for (int i = 0; i < stages.length; i++) {
            challenger[stages[i]] += 1;
        }

        // ❷ 스테이지별 실패한 사용자 수 계산
        HashMap<Integer, Double> fails = new HashMap<>();
        double total = stages.length;

        // ❸ 각 스테이지를 순회하며, 실패율 계산
        for (int i = 1; i <= N; i++) {
            if (challenger[i] == 0) { // ❹ 도전한 사람이 없는 경우, 실패율은 0
                fails.put(i, 0.);
            } else {
                fails.put(i, challenger[i] / total); // ❺ 실패율 구함
                total -= challenger[i]; // ❻ 다음 스테이지 실패율을 구하기 위해 현재 스테이지의 인원을 뺌
            }
        }

        // ❼ 실패율이 높은 스테이지부터 내림차순으로 정렬
        return fails.entrySet().stream().sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue())).mapToInt(HashMap.Entry::getKey).toArray();
    }
}
