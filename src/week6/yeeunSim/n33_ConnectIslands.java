package week6.yeeunSim;

import java.util.Arrays;

public class n33_ConnectIslands {

    private static int[] parent;

    public static void main(String[] args) {
        int[][] costs1 = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};

        System.out.println(solution(4, costs1));
    }

    private static int find(int x) {
        if (parent[x] == x)
            return x;

        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        int root1 = find(x);
        int root2 = find(y);
        parent[root2] = root1;
    }

    private static int solution(int n, int[][] costs) {
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int answer = 0;
        int edges = 0;

        for (int[] edge : costs) {
            //  n - 1개의 다리가 연결된 경우 모든 섬이 연결됨
            if (edges == n - 1)
                break;

            // 현재 다리가 연결하는 두 섬이 이미 연결되어 있는지 확인
            if (find(edge[0]) != find(edge[1])) {
                union(edge[0], edge[1]);
                answer += edge[2];
                edges++;
            }
        }

        return answer;
    }
}

