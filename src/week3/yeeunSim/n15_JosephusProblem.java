package week3.yeeunSim;

import java.util.ArrayDeque;

public class n15_JosephusProblem {

    public static void main(String[] args) {
        System.out.println(solution(5, 2));
    }

    /**
     * 시간복잡도: O(N*K)
     */
    private static int solution(int N, int K) {

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deque.addLast(i);
        }

        while (deque.size() > 1) {
            for (int i = 0; i < K - 1; i++) {
                deque.addLast(deque.pollFirst());
            }
            deque.pollFirst();
        }

        return deque.pollFirst();
    }
}
