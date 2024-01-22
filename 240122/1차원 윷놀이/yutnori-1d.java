import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M, K;
    static int[] select, order;
    static int Answer;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inArr = br.readLine().split(" ");
        N = Integer.parseInt(inArr[0]);     // N : 턴의 수. 최대 12
        M = Integer.parseInt(inArr[1]);     // M : 윷놀이 판의 길이. 최대 100
        K = Integer.parseInt(inArr[2]);     // K : 말의 수. 최대 4
        order = new int[N];
        inArr = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            order[i] = Integer.parseInt(inArr[i]);
        }
        // end input
        select = new int[N];
        Answer = 0;
        permutation(0);

        System.out.println(Answer);
    }

    // 말의 수^턴의 수 -> 최대 4^12 = 1700만
    static void permutation(int cnt) {
        if (cnt == N) {
            Answer = Math.max(Answer, process());
            return;
        }
        for (int i = 0; i < K; i++) {
            select[cnt] = i;
            permutation(cnt + 1);
        }
    }
    static int process() {
        // 말 움직이기
        int[] horse = new int[K];
        for (int i = 0; i < N; i++) {
            horse[select[i]] += order[i];
        }
        // m-1에 도착한 말 세기
        int cnt = 0;
        for (int i = 0; i < K; i++) {
            if (horse[i] >= M - 1) {
                cnt++;
            }
        }
        return cnt;
    }

}