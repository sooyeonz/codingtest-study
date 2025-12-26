package week7.sooyeonz;

public class n38_Network {

	private static boolean[] visit;
	private static int[][] computer;

	public static void main(String[] args) {
		int n1 = 3;
		int[][] computers1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		int n2 = 3;
		int[][] computers2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};

		System.out.println(solution(n1, computers1));
		System.out.println(solution(n2, computers2));
	}

	private static void dfs(int now) {
		visit[now] = true;
		for (int i = 0; i < computer[now].length; i++) {
			if (computer[now][i] == 1 && !visit[i]) {
				dfs(i);
			}
		}
	}

	private static int solution(int n, int[][] computers) {
		int answer = 0;
		computer = computers;
		visit = new boolean[n];

		for (int i = 0; i < n; i++) {
			if (!visit[i]) {
				dfs(i);
				answer++;
			}
		}

		return answer;
	}
}
