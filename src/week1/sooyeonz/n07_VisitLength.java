package week1.sooyeonz;

import java.util.HashMap;
import java.util.HashSet;

public class n07_VisitLength {

	public static void main(String[] args) {
		String dirs1 = "ULURRDLLU";
		String dirs2 = "LULLLLLLU";

		// 추가 테스트 케이스
		String dirs3 = "LLLLLRRRRR";
		String dirs4 = "UDUDUDUD";

		System.out.println(solution(dirs1));
		System.out.println(solution(dirs2));
		System.out.println(solution(dirs3));
		System.out.println(solution(dirs4));
	}

	private static int solution(String dirs) {
		HashMap<Character, int[]> location = new HashMap<>();
		location.put('U', new int[] {0, 1});
		location.put('D', new int[] {0, -1});
		location.put('L', new int[] {-1, 0});
		location.put('R', new int[] {1, 0});

		int x = 5, y = 5;
		HashSet<String> answer = new HashSet<>();
		for (int i = 0; i < dirs.length(); i++) {
			int[] offset = location.get(dirs.charAt(i));

			int nx = x + offset[0];
			int ny = y + offset[1];

			if (!isValidMove(nx, ny)) {
				continue;
			}

			answer.add(x + " " + y + " " + nx + " " + ny);
			answer.add(nx + " " + ny + " " + x + " " + y);

			x = nx;
			y = ny;
		}

		return answer.size() / 2;
	}

	private static boolean isValidMove(int nx, int ny) {
		return 0 <= nx && nx < 11 && 0 <= ny && ny < 11;
	}

}
