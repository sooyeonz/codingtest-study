package week2.sooyeonz;

import java.util.ArrayDeque;
import java.util.Deque;

public class n11_RemovePair {

	public static void main(String[] args) {
		String s1 = "baabaa";
		String s2 = "cdcd";

		// 추가 테스트 케이스
		String s3 = "abbacc";
		String s4 = "cdcdeedcdc";

		System.out.println(solution(s1));
		System.out.println(solution(s2));

		System.out.println(solution(s3));
		System.out.println(solution(s4));
	}

	private static int solution(String s) {
		Deque<Character> stack = new ArrayDeque<>();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if (stack.isEmpty()) {
				stack.push(ch);
			} else {
				if (ch == stack.peek()) {
					stack.pop();
				} else {
					stack.push(ch);
				}
			}
		}

		return stack.size() == 0 ? 1 : 0;
	}
}
