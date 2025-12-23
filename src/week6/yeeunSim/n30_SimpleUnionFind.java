package week6.yeeunSim;

import java.util.Arrays;
import java.util.ArrayList;

public class n30_SimpleUnionFind {

    private static int[] parent;

    public static void main(String[] args) {
        int[][] operations1 = {{0, 0, 1}, {0, 1, 2}, {1, 1, 2}};
        int[][] operations2 = {{0, 0, 1}, {1, 1, 2}, {0, 1, 2}, {1, 0, 2}};

        System.out.println(Arrays.toString(solution(3, operations1)));
        System.out.println(Arrays.toString(solution(4, operations2)));
    }

    private static int find(int x) {
        if (parent[x] == x)
            return x;

        parent[x] = find(parent[x]);
        return parent[x];
    }

    private static void union(int x, int y) {
        int root1 = find(x);
        int root2 = find(y);

        parent[root2] = root1;
    }

    private static Boolean[] solution(int k, int[][] operation) {
        parent = new int[k];

        for (int i = 0; i < k; i++) {
            parent[i] = i;
        }

        ArrayList<Boolean> answer = new ArrayList<>();

        for (int[] op : operation) {
            if (op[0] == 0) {
                union(op[1], op[2]);
            } else {
                answer.add(find(op[1]) == find(op[2]));
            }
        }

        return answer.toArray(new Boolean[0]);
    }
}
