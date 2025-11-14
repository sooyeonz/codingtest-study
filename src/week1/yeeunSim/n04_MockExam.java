package week1.yeeunSim;

import java.util.ArrayList;
import java.util.Arrays;

public class n04_MockExam {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(solution(new int[]{1, 3, 2, 4, 2})));
    }

    /**
    * 시간복잡도: O(N), 정답 배열의 길이 N에 비례하여 연산 횟수가 증가
    */
    private static int[] solution(int[] answers) {
        int[][] pattern = { {1, 2, 3, 4, 5},
                            {2, 1, 2, 3, 2, 4, 2, 5},
                            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};

        int[] scores = new int[3];

        // 각 수포자의 패턴과 정답이 얼마나 일치하는지 확인 (한 문항마다 각 수포자의 답안과 비교)
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < pattern.length; j++) {
                if(answers[i] == pattern[j][i % pattern[j].length]) {
                    scores[j]++;
                }
            }
        }

        int maxScore = Arrays.stream(scores).max().getAsInt();

        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                answer.add(i + 1);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
