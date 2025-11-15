package week1.yeeunSim;

import java.util.HashSet;

public class n07_VisitLength {
    public static void main(String[] args) {
        String dirs1 = "ULURRDLLU";
        String dirs2 = "LULLLLLLU";

        System.out.println(solution(dirs1));
        System.out.println(solution(dirs2));
    }

    public static int solution(String dirs) {
        // [x, y] 변화량을 배열로 정의: U(0,1), D(0,-1), L(-1,0), R(1,0)
        final int[][] MOVES = new int[91][]; // ASCII 'U': 85, 'D': 68, 'L': 76, 'R': 82
        MOVES['U'] = new int[]{0, 1};
        MOVES['D'] = new int[]{0, -1};
        MOVES['L'] = new int[]{-1, 0};
        MOVES['R'] = new int[]{1, 0};

        int x = 5, y = 5; // 시작 좌표 (5, 5)
        HashSet<String> visitedPaths = new HashSet<>(); // 지나간 경로를 저장할 Set

        for (char dir : dirs.toCharArray()) {
            int[] move = MOVES[dir];
            int nx = x + move[0];
            int ny = y + move[1];

            // 11x11 좌표 평면 (0~10)을 벗어나는지 확인
            if (nx < 0 || nx > 10 || ny < 0 || ny > 10) {
                continue;
            }

            // 경로를 문자열로 만들어 HashSet에 추가
            // (x1, y1) -> (x2, y2)와 (x2, y2) -> (x1, y1) 두 가지 방향을 모두 저장
            String path1 = x + "," + y + "->" + nx + "," + ny;
            String path2 = nx + "," + ny + "->" + x + "," + y;

            visitedPaths.add(path1);
            visitedPaths.add(path2);

            // 현재 좌표 업데이트
            x = nx;
            y = ny;
        }

        // 전체 저장된 경로의 개수에서 양방향 경로를 저장했으므로 2를 나눠 반환
        return visitedPaths.size() / 2;
    }
}

