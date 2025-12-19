package week6.yeeunSim;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class n31_Pokemon {

    public static void main(String[] args) {
        int[] nums1 = {3, 1, 2, 3};
        int[] nums2 = {3, 3, 3, 2, 2, 4};
        int[] nums3 = {3, 3, 3, 2, 2, 2};

        System.out.println(solution(nums1));
        System.out.println(solution(nums2));
        System.out.println(solution(nums3));
    }

    private static int solution(int[] nums) {
        // nums 리스트에서 중복을 제거한 집합(set)을 구함
        HashSet<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet::new));
        int n = nums.length;
        int k = n / 2;
        return Math.min(k, set.size());
    }
}