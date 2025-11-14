package week1.yeeunSim;

import java.util.Arrays;

public class n05_MatrixMultiplication {

    public static void main(String[] args) {
        int[][] arr1_ex1 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] arr1_ex2 = {{3, 3}, {3, 3}};

        int[][] arr2_ex1 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
        int[][] arr2_ex2 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};

        System.out.println(Arrays.deepToString(solution(arr1_ex1, arr1_ex2)));
        System.out.println(Arrays.deepToString(solution(arr2_ex1, arr2_ex2)));
    }

    /**
     * 시간복잡도: O(N^3), 행렬의 크기가 N x N일 때 (N x M, M x K일 경우 O(NMK))
     */
    private static int[][] solution(int[][] arr1, int[][] arr2) {
        int r1 = arr1.length;
        int c1 = arr1[0].length;
        int c2 = arr2[0].length; // 행렬의 곱에서 첫 번째 행렬의 열과 두 번째 행렬의 행 값은 같으므로 r2 생략

        int[][] answer = new int[r1][c2];

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;
    }
}