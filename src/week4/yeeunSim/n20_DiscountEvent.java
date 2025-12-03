package week4.yeeunSim;

import java.util.HashMap;

public class n20_DiscountEvent {

    public static void main(String[] args) {
        String[] want1 = {"banana", "apple", "rice", "pork", "pot"};
        int[] number1 = {3, 2, 2, 2, 1};
        String[] discount1 = {"chicken", "apple", "apple", "banana", "rice",
                "apple", "pork", "banana", "pork", "rice", "pot",
                "banana", "apple", "banana"};

        String[] want2 = {"apple"};
        int[] number2 = {10};
        String[] discount2 = {"banana", "banana", "banana", "banana",
                "banana", "banana", "banana", "banana",
                "banana", "banana"};

        System.out.println(solution(want1, number1, discount1));
        System.out.println(solution(want2, number2, discount2));
    }

    private static int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        int answer = 0;

        for (int i = 0; i < discount.length - 9; i++) {
            HashMap<String, Integer> discount10d = new HashMap<>();

            for (int j = i; j < i + 10; j++) {
                if (wantMap.containsKey(discount[j])) {
                    discount10d.put(discount[j], discount10d.getOrDefault(discount[j], 0) + 1);
                }
            }

            if (discount10d.equals(wantMap))
                answer++;
        }

        return answer;
    }
}
