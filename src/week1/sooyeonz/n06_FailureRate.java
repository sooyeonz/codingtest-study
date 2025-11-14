package week1.sooyeonz;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class n06_FailureRate {
	public static void main(String[] args) {
		int N1 = 5;
		int[] stages1 = {2, 1, 2, 6, 2, 4, 3, 3};
		int N2 = 4;
		int[] stages2 = {4, 4, 4, 4, 4};

		// 추가 테스트 케이스
		int N3 = 3;
		int[] stages3 = {1, 1, 1, 1, 1};
		int N4 = 5;
		int[] stages4 = {1, 2, 3, 4, 5, 6, 6};

		System.out.println(Arrays.toString(solution(N1, stages1)));
		System.out.println(Arrays.toString(solution(N2, stages2)));
		System.out.println(Arrays.toString(solution(N3, stages3)));
		System.out.println(Arrays.toString(solution(N4, stages4)));
	}

	private static int[] solution(int N, int[] stages) {
		int[] challenger = new int[N + 2];
		Map<Integer, Double> rate = new HashMap<>();

		for (int i = 0; i < stages.length; i++) {
			challenger[stages[i]]++;
		}

		double people = stages.length;
		for (int i = 1; i <= N; i++) {
			if (challenger[i] == 0) {
				rate.put(i, 0.0);
			} else {
				rate.put(i, challenger[i] / people);
				people -= challenger[i];
			}
		}

		return rate.entrySet().stream()
			.sorted(Map.Entry.<Integer, Double>comparingByValue().reversed())
			.mapToInt(Map.Entry::getKey)
			.toArray();
	}
}
