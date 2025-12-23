package week5.sooyeonz;

public class n26_PredictedBracket {

	public static void main(String[] args) {
		int n1 = 8;
		int a1 = 4;
		int b1 = 7;

		// 추가 테스트 케이스
		int n2 = 10;
		int a2 = 2;
		int b2 = 10;

		System.out.println(solution(n1, a1, b1));
		System.out.println(solution(n2, a2, b2));
	}

	private static int solution(int n, int a, int b) {
		int result;

		for (result = 0; a != b; result++) {
			a = (a + 1) / 2;
			b = (b + 1) / 2;
		}

		return result;
	}
}
