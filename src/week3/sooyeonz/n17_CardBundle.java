package week3.sooyeonz;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class n17_CardBundle {

	public static void main(String[] args) {
		String[] cards1 = {"i", "drink", "water"};
		String[] cards2 = {"want", "to"};
		String[] cards3 = {"i", "water", "drink"};
		String[] cards4 = {"want", "to"};
		String[] goal1 = {"i", "want", "to", "drink", "water"};

		// 추가 테스트 코드
		String[] cards5 = {"there", "book", "on", "the"};
		String[] cards6 = {"is", "a", "desk"};
		String[] goal2 = {"there", "is", "a", "book", "on", "the", "desk"};

		System.out.println(solution(cards1, cards2, goal1));
		System.out.println(solution(cards3, cards4, goal1));
		System.out.println(solution(cards5, cards6, goal2));
	}

	private static String solution(String[] cards1, String[] cards2, String[] goal) {
		Deque<String> cards1Deque = new ArrayDeque<>(Arrays.asList(cards1));
		Deque<String> cards2Deque = new ArrayDeque<>(Arrays.asList(cards2));
		Deque<String> goalDeque = new ArrayDeque<>(Arrays.asList(goal));

		while (!goalDeque.isEmpty()) {
			if (!cards1Deque.isEmpty() && cards1Deque.peekFirst().equals(goalDeque.peekFirst())) {
				cards1Deque.pollFirst();
				goalDeque.pollFirst();
			} else if (!cards2Deque.isEmpty() && cards2Deque.peekFirst().equals(goalDeque.peekFirst())) {
				cards2Deque.pollFirst();
				goalDeque.pollFirst();
			} else
				break;
		}

		return goalDeque.isEmpty() ? "Yes" : "No";
	}
}
