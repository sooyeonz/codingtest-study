package week2.sooyeonz;

import java.util.ArrayDeque;
import java.util.Deque;

public class n08_CorrectParentheses {
	public static void main(String[] args) {
		String s1 = "()()";
		String s2 = "(())()";
		String s3 = ")()(";
		String s4 = "(()(";

		// 추가 테스트 케이스
		String s5 = "())(";
		String s6 = "())(()";
		String s7 = "()(())()((()))";

		System.out.println(solution(s1));
		System.out.println(solution(s2));
		System.out.println(solution(s3));
		System.out.println(solution(s4));

		System.out.println(solution(s5));
		System.out.println(solution(s6));
		System.out.println(solution(s7));
	}

	private static boolean solution(String s) {
		Deque<Character> stack = new ArrayDeque<>();

		char[] ch = s.toCharArray();
		for (char c : ch) {
			if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				if (!stack.isEmpty()){
					stack.pop();
				}
			}
		}

		if (stack.isEmpty()) {
			return true;
		}

		return false;
	}
}
