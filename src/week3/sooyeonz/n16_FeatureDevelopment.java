package week3.sooyeonz;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class n16_FeatureDevelopment {

	public static void main(String[] args) {
		int[] progresses1 = {93, 30, 55};
		int[] speeds1 = {1, 30, 5};
		int[] progresses2 = {95, 90, 99, 99, 80, 99};
		int[] speeds2 = {1, 1, 1, 1, 1, 1};

		System.out.println(Arrays.toString(solution(progresses1, speeds1)));
		System.out.println(Arrays.toString(solution(progresses2, speeds2)));
	}

	private static int[] solution(int[] progresses, int[] speeds) {
		Deque<Integer> answer = new ArrayDeque<>();

		int n = progresses.length;
		int[] daysLeft = new int[n];

		for (int i = 0; i < n; i++) {
			daysLeft[i] = (int)Math.ceil((100.0 - progresses[i]) / speeds[i]);
		}

		int count = 0;
		int maxDay = daysLeft[0];

		for (int i = 0; i < n; i++) {
			if (daysLeft[i] <= maxDay) {
				count++;
			} else {
				answer.add(count);
				count = 1;
				maxDay = daysLeft[i];
			}
		}

		answer.add(count);
		return answer.stream().mapToInt(Integer::intValue).toArray();
	}
}
