import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M;
    static int[][] Board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inArr = br.readLine().split(" ");
        N = Integer.parseInt(inArr[0]);
        M = Integer.parseInt(inArr[1]);
        Board = new int[N + 1][M + 1];
        for (int i = 0; i < N; i++) {
            inArr = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                Board[i + 1][j + 1] = Integer.parseInt(inArr[j]);
            }
        }
        // end input
        System.out.println(DP());
    }
    static int DP() {
        int[][] dp = new int[N + 1][M + 1];

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                for (int ni = 0; ni < i; ni++) {
                    for (int nj = 0; nj < j; nj++) {
                        dp[i][j] = Math.max(dp[i][j], dp[ni][nj] + 1);
                    }
                }
            }
        }

        return maxNum(dp);
    }

    static int maxNum(int[][] dp) {
        int answer = 0;
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                answer = Math.max(answer, dp[i][j]);
            }
        }
        return answer;
    }
}