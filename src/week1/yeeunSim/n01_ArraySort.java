package week1.yeeunSim;

import java.util.Arrays;

public class n01_ArraySort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, -5, 2, 4, 3})));
        System.out.println(Arrays.toString(solution(new int[]{2, 1, 1, 3, 2, 5, 4})));
        System.out.println(Arrays.toString(solution(new int[]{6, 1, 7})));
    }

    /**
     * 시간복잡도 설명
     * 문제 조건: 배열 길이 N의 최대값이 10^5라고 가정할 때
     * - O(N^2) → 10^10 연산 → 시간 초과 (3초 기준: 약 3×10^8 연산 가능)
     * - O(NlogN) → 약 10^5 × 17 ≈ 170만 연산 → 충분히 통과
     *
     * Arrays.sort()는 내부적으로 O(NlogN) 정렬 알고리즘(팀소트)을 사용한다.
     * 따라서 N이 10^5~10^6 수준이어도 코딩테스트에서 시간 초과가 발생하지 않는다.
     */
    private static int[] solution(int[] arr) {
        Arrays.sort(arr);  // 오름차순 정렬 (O(NlogN))
        return arr;
    }

    // ===================== 참고용: O(N^2) 기초 정렬들 =====================

    // 버블 정렬 (Bubble Sort) - O(N^2)
    // 인접한 두 값을 비교하여 큰 값을 뒤로 보내는 정렬.
    // 데이터 개수가 많을 때(10^5 등)는 시간 초과가 나기 때문에,
    // 실제 코딩테스트에서는 사용하지 않는다.

    private static int[] bubbleSort(int[] org) {
        int[] arr = org.clone();  // 원본 보호용 복사
        int n = arr.length;

        for (int i = 0; i < n; i++) {   // 패스 횟수
            for (int j = 0; j < n - 1 - i; j++) {   // 인접 원소 비교
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }

    // 선택 정렬 (Selection Sort) - O(N^2)
    // 매 단계마다 가장 작은 값을 선택해서 앞쪽으로 보내는 정렬.
    // 비교 횟수가 많아 N이 큰 입력에서는 역시 시간 초과가 발생한다.

    private static int[] selectionSort(int[] org) {
        int[] arr = org.clone();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int minIdx = i; // 가장 작은 값의 인덱스
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            // i 위치와 최소값 위치를 교환
            int tmp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = tmp;
        }
        return arr;
    }

    // 삽입 정렬 (Insertion Sort) - 평균 O(N^2)
    // 앞부분은 정렬되어 있다고 보고, 새 원소를 올바른 위치에 끼워 넣는 정렬.
    // 거의 정렬된 데이터에서는 빠르지만, 최악의 경우 O(N^2)이라 큰 입력에는 부적합하다.

    private static int[] insertionSort(int[] org) {
        int[] arr = org.clone();
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];   // 끼워 넣을 값
            int j = i - 1;

            // key 보다 큰 값들은 한 칸씩 뒤로 밀기
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;   // 빈 자리에 key 삽입
        }
        return arr;
    }
}