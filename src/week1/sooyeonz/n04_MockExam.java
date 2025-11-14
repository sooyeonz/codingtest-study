package week1.sooyeonz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class n04_MockExam {
	public static void main(String[] args) {
		int[] test1 = {1, 2, 3, 4, 5};
		int[] test2 = {1, 3, 2, 4, 2};

		// 추가 테스트 케이스
		int[] test3 = {1, 1, 1, 1, 1};

		System.out.println(Arrays.toString(solution(test1)));
		System.out.println(Arrays.toString(solution(test2)));
		System.out.println(Arrays.toString(solution(test3)));
	}

	private static int[] solution(int[] answers) {
		int[][] pattern = {
			{1, 2, 3, 4, 5},
			{2, 1, 2, 3, 2, 4, 2, 5},
			{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
		};

		int[] scores = new int[3];

		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == pattern[0][i % pattern[0].length]) {
				scores[0]++;
			}
			if (answers[i] == pattern[1][i % pattern[1].length]) {
				scores[1]++;
			}
			if (answers[i] == pattern[2][i % pattern[2].length]) {
				scores[2]++;
			}
		}

		int maxScore = Arrays.stream(scores).max().getAsInt();

		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < scores.length; i++) {
			if (scores[i] == maxScore) {
				result.add(i + 1);
			}
		}

		return result.stream().mapToInt(Integer::intValue).toArray();
	}
}
