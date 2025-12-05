package week4.sooyeonz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class n22_BestAlbum {

	public static void main(String[] args) {
		String[] genres1 = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays1 = {500, 600, 150, 800, 2500};

		// 추가 테스트 케이스
		String[] genres2 = {"rock", "rock", "rock", "jazz", "jazz", "pop"};
		int[] plays2 = {500, 500, 300, 400, 400, 700};
		String[] genres3 = {"hiphop", "classic", "hiphop", "classic", "classic", "pop", "classic", "hiphop"};
		int[] plays3 = {2000, 400, 1500, 800, 100, 3000, 900, 1800};

		System.out.println(Arrays.toString(solution(genres1, plays1)));
		System.out.println(Arrays.toString(solution(genres2, plays2)));
		System.out.println(Arrays.toString(solution(genres3, plays3)));
	}

	private static int[] solution(String[] genres, int[] plays) {
		// 1. 장르별 HashMap 만들기 (index -> plays)
		HashMap<String, HashMap<Integer, Integer>> genreMap = new HashMap<>();

		for (int i = 0; i < genres.length; i++) {
			String genre = genres[i];
			int play = plays[i];

			if (!genreMap.containsKey(genre)) {
				genreMap.put(genre, new HashMap<>());
			}

			genreMap.get(genre).put(i, play);
		}

		// 2. 장르별 총 재생 횟수 계산
		HashMap<String, Integer> genreTotalPlays = new HashMap<>();

		for (String genre : genreMap.keySet()) {
			int total = 0;
			for (int play : genreMap.get(genre).values()) {
				total += play;
			}
			genreTotalPlays.put(genre, total);
		}

		// 3. 장르를 총 재생 횟수로 정렬
		List<String> sortedGenres = new ArrayList<>(genreTotalPlays.keySet());
		sortedGenres.sort((a, b) -> genreTotalPlays.get(b) - genreTotalPlays.get(a));

		// 4. 각 장르별로 상위 2곡 선택
		List<Integer> result = new ArrayList<>();

		for (String genre : sortedGenres) {
			HashMap<Integer, Integer> songsInGenre = genreMap.get(genre);

			List<Map.Entry<Integer, Integer>> songList = new ArrayList<>(songsInGenre.entrySet());

			songList.sort((a, b) -> {
				if (b.getValue().equals(a.getValue())) {
					return a.getKey() - b.getKey();
				}
				return b.getValue() - a.getValue();
			});

			for (int i = 0; i < Math.min(2, songList.size()); i++) {
				result.add(songList.get(i).getKey());
			}
		}

		return result.stream().mapToInt(i -> i).toArray();
	}
}
