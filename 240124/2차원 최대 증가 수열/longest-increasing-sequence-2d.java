import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

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
            Arrays.fill(Board[i], Integer.MAX_VALUE);
            inArr = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                Board[i][j] = Integer.parseInt(inArr[j]);
            }
        }
        Arrays.fill(Board[N], Integer.MAX_VALUE);
        // end input
        System.out.println(DP());
    }
    static int DP() {
        // dp[i][j] : (i, j)를 마지막으로 하는 2차원 최대 감소 수열
        int[][] dp = new int[N + 1][M + 1];

        for (int i = N-1; i >= 0; i--) {
            for (int j = M-1; j >= 0; j--) {
                for (int ni = i + 1; ni < N + 1; ni++) {
                    for (int nj = j + 1; nj < M + 1; nj++) {
                        if (Board[i][j] < Board[ni][nj]) {
                            dp[i][j] = Math.max(dp[i][j], dp[ni][nj] + 1);
                        }
                    }
                }
            }
        }
        return dp[0][0];
    }
}