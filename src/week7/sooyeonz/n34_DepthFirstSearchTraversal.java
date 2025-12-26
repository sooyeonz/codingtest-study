package week7.sooyeonz;

import java.util.ArrayList;
import java.util.Arrays;

public class n34_DepthFirstSearchTraversal {

	private static ArrayList<Integer>[] adjList;
	private static boolean[] visited;
	private static ArrayList<Integer> answer;

	public static void main(String[] args) {
		int[][] graph1 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
		int start1 = 1;
		int n1 = 5;
		int[][] graph2 = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {5, 6}};
		int start2 = 1;
		int n2 = 6;

		System.out.println(Arrays.toString(solution(graph1, start1, n1)));
		System.out.println(Arrays.toString(solution(graph2, start2, n2)));
	}

	private static int[] solution(int[][] graph, int start, int n) {
		adjList = new ArrayList[n + 1];
		for (int i = 0; i < adjList.length; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int[] edge : graph) {
			adjList[edge[0]].add(edge[1]);
		}

		visited = new boolean[n + 1];
		answer = new ArrayList<>();
		dfs(start);

		return answer.stream().mapToInt(Integer::intValue).toArray();
	}

	private static void dfs(int now) {
		visited[now] = true;
		answer.add(now);
		for (int next : adjList[now]) {
			if (!visited[next]) {
				dfs(next);
			}
		}
	}
}
