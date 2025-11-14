package week1.yeeunSim;

import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

public class n02_ArrayControl {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{4, 2, 2, 1, 3, 4})));
        System.out.println(Arrays.toString(solution(new int[]{2, 1, 1, 3, 2, 5, 4})));
    }

    /**
     * 시간복잡도: 전체 O(NlogN)
     *  - distinct()는 O(N), 정렬이 O(NlogN)이라 정렬 비용이 지배적
     *  - 예: N=1000일 때 NlogN ≈ 1000 × log₂1000 ≈ 1000 × 10 (2¹⁰=1024 ≈ 1000)
     *
     *  1. int[] → Stream으로 변환 후 → Integer 스트림(boxed)으로 변경 → distinct()로 중복 제거 O(N)
     *  2. Integer[]를 Arrays.sort() + reverseOrder()로 내림차순 정렬 O(NlogN)
     *  3. 다시 int[]로 변환해 반환
     */
    private static int[] solution(int[] arr) {
        Integer[] result = Arrays.stream(arr).boxed().distinct().toArray(Integer[]::new);
        Arrays.sort(result, Collections.reverseOrder());
        return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
    }

    // ===================== 참고용: TreeSet =====================

    // TreeSet<Integer>
    // - Set: 같은 값을 두 번 넣어도 한 번만 저장됨 → 중복 제거
    // - Tree: 값이 들어갈 때마다 자동으로 정렬된 위치에 저장됨 → 정렬 유지
    // - new TreeSet<>(Collections.reverseOrder()): 비교 기준을 내림차순으로 바꿔서 "큰 값 → 작은 값" 순서로 저장한다.

    private static int[] TreeSet(int[] arr) {
        // 중복 제거 + 내림차순 정렬을 동시에 해주는 TreeSet
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

        // 배열의 값들을 전부 set에 넣기
        for (int num : arr) {
            set.add(num);   // 자동으로 중복 제거 + 정렬
        }

        // TreeSet → int[]로 변환
        int[] result = new int[set.size()];
        int i = 0;
        for (int num : set) {
            result[i++] = num;
        }
        return result;
    }
}