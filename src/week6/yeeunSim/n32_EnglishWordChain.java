package week6.yeeunSim;

import java.util.Arrays;
import java.util.HashSet;

public class n32_EnglishWordChain {

    public static void main(String[] args) {
        String[] words1 = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        String[] words2 = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
        String[] words3 = {"hello", "one", "even", "never", "now", "world", "draw"};

        System.out.println(Arrays.toString(solution(3, words1)));
        System.out.println(Arrays.toString(solution(5, words2)));
        System.out.println(Arrays.toString(solution(2, words3)));
    }

    private static int[] solution(int n, String[] words) {
        HashSet<String> usedWords = new HashSet<>();
        char prevWord = words[0].charAt(0);

        for (int i = 0; i < words.length; i++) {
            if (usedWords.contains(words[i]) || words[i].charAt(0) != prevWord) {
                return new int[]{(i % n) + 1, (i / n) + 1};
            }
            usedWords.add(words[i]);
            prevWord = words[i].charAt(words[i].length() - 1);
        }

        return new int[]{0, 0};
    }
}
