package week2.sooyeonz;

import java.util.ArrayDeque;
import java.util.Deque;

public class n13_CraneDollGame {

	public static void main(String[] args) {
		int[][] board1 = {{0, 0, 0, 0, 0},
			{0, 0, 1, 0, 3},
			{0, 2, 5, 0, 1},
			{4, 2, 4, 4, 2},
			{3, 5, 1, 3, 1}};
		int[] moves1 = {1, 5, 3, 5, 1, 2, 1, 4};

		// 추가 테스트 케이스
		int[][] board2 = {
			{0, 0, 0},
			{0, 0, 0},
			{0, 0, 0}
		};
		int[] moves2 = {1, 2, 3};

		int[][] board3 = {
			{0, 0, 0, 0},
			{1, 1, 1, 1},
			{2, 2, 2, 2},
			{3, 3, 3, 3}
		};
		int[] moves3 = {1, 2, 3, 4, 1, 2, 3, 4};

		System.out.println(solution(board1, moves1));
		System.out.println(solution(board2, moves2));
		System.out.println(solution(board3, moves3));
	}

	private static int solution(int[][] board, int[] moves) {
		int answer = 0;

		Deque<Integer>[] stackLanes = new ArrayDeque[board.length];
		for (int i = 0; i < board.length; i++) {
			stackLanes[i] = new ArrayDeque<>();
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[j][i] != 0) {
					stackLanes[i].addLast(board[j][i]);
				}
			}
		}

		Deque<Integer> bucket = new ArrayDeque<>();
		for (int i = 0; i < moves.length; i++) {
			if (!stackLanes[moves[i] - 1].isEmpty()) {
				int n = stackLanes[moves[i] - 1].pop();

				if (!bucket.isEmpty() && bucket.peek().equals(n)) {
					bucket.pop();
					answer += 2;
				} else{
					bucket.push(n);
				}
			}
		}

		return answer;
	}
}
