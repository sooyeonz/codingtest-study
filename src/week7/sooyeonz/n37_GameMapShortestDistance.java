package week7.sooyeonz;

import java.util.ArrayDeque;

public class n37_GameMapShortestDistance {

	private static final int[] rx = {0, 0, 1, -1};
	private static final int[] ry = {1, -1, 0, 0};

	public static void main(String[] args) {
		int[][] maps1 = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
		int[][] maps2 = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}};

		System.out.println(solution(maps1));
		System.out.println(solution(maps2));
	}

	private static class Node {
		int r, c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	private static int solution(int[][] maps) {
		int N = maps.length;
		int M = maps[0].length;

		int[][] dist = new int[N][M];

		ArrayDeque<Node> queue = new ArrayDeque<>();

		queue.addLast(new Node(0, 0));
		dist[0][0] = 1;

		while (!queue.isEmpty()) {
			Node now = queue.pollFirst();

			for (int i = 0; i < 4; i++) {
				int nr = now.r + rx[i];
				int nc = now.c + ry[i];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
					continue;
				}

				if (maps[nr][nc] == 0) {
					continue;
				}

				if (dist[nr][nc] == 0) {
					queue.addLast(new Node(nr, nc));
					dist[nr][nc] = dist[now.r][now.c] + 1;
				}
			}
		}

		return dist[N - 1][M - 1] == 0 ? -1 : dist[N - 1][M - 1];
	}
}
