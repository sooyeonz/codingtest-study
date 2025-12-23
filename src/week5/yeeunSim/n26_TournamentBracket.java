package week5.yeeunSim;

import com.sun.jdi.PathSearchingVirtualMachine;

public class n26_TournamentBracket {

    public static void main(String[] args) {
        System.out.println(solution(8, 4, 7));
    }

    private static int solution(int n, int a, int b) {
        int answer;

        for (answer = 0; a != b; answer++) {
            a = ( a + 1) / 2 ;
            b = (b + 1) / 2;
        }

        return answer;
    }
}


