package week1.sooyeonz;

import java.util.Arrays;

public class n05_MatrixMultiplication {
	public static void main(String[] args) {
		int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
		int[][] arr2 = {{3, 3}, {3, 3}};

		int[][] arr3 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
		int[][] arr4 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};

		// 추가 테스트 케이스
		int[][] arr5 = {{1, 2, 3}, {4, 5, 6}};
		int[][] arr6 = {{7, 8, 9, 10}, {11, 12, 13, 14}, {15, 16, 17, 18}};

		int[][] arr7 = {{2, 1}, {3, 4}, {5, 2}, {1, 3}};
		int[][] arr8 = {{6, 7, 8}, {9, 10, 11}};

		System.out.println(Arrays.deepToString(solution(arr1, arr2)));
		System.out.println(Arrays.deepToString(solution(arr3, arr4)));
		System.out.println(Arrays.deepToString(solution(arr5, arr6)));
		System.out.println(Arrays.deepToString(solution(arr7, arr8)));
	}

	private static int[][] solution(int[][] arr1, int[][] arr2) {
		int n = arr1.length;
		int m = arr2[0].length;

		int[][] answer = new int[n][m];

		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				for(int k = 0; k < arr1[0].length; k++){
					answer[i][j] += arr1[i][k] * arr2[k][j];
				}
			}
		}

		return answer;
	}
}
