package week3.sooyeonz;

import java.util.ArrayDeque;
import java.util.Deque;

public class n15_JosephusProblem {

	public static void main(String[] args) {
		int n1 = 5;
		int k1 = 2;

		// 추가 테스트 케이스
		int n2 = 5;
		int k2 = 3;

		System.out.println(solution(n1, k1));
		System.out.println(solution(n2, k2));
	}

	private static int solution(int n, int k) {
		Deque<Integer> people = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			people.addLast(i + 1);
		}

		while (people.size() > 1) {
			for (int i = 0; i < k - 1; i++) {
				people.addLast(people.pollFirst());
			}
			people.pollFirst();
		}

		return people.pollFirst();
	}
}
