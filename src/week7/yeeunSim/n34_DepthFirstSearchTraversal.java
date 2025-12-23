package week7.yeeunSim;

import java.util.ArrayList;
import java.util.Arrays;

public class n34_DepthFirstSearchTraversal {

    private static ArrayList<Integer>[] adjList;
    private static boolean[] visited;
    private static ArrayList<Integer> answer;

    public static void main(String[] args) {
        int[][] graph1 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        int[][] graph2 = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {5, 6}};

        System.out.println(Arrays.toString(solution(graph1, 1, 5)));
        System.out.println(Arrays.toString(solution(graph2, 1, 6)));
    }

    private static int[] solution(int[][] graph, int start, int n) {
        // 노드 번호가 1부터 시작하므로, 인덱스를 맞추기 위해 n + 1 크기로 초기화
        adjList = new ArrayList[n + 1];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 그래프를 인접 리스트로 변환
        for (int[] edge : graph) {
            adjList[edge[0]].add(edge[1]);
        }

        visited = new boolean[n + 1];
        answer = new ArrayList<>();
        dfs(start);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    // DFS 탐색 (재귀)
    private static void dfs(int now) {
        visited[now] = true; // 현재 노드를 방문했으면
        answer.add(now); // 현재 노드를 결과 리스트에 추가
        // 현재 노드와 가까운 노드 순회
        for (int next : adjList[now]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
