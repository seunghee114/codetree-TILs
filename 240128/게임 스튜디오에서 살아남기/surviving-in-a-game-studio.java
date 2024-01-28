import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int STANDARD = 1000000000 + 7;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // dp[n][t][b] : n일에 총 t개의 T를 받았고, 연속으로 b개의 B를 받았을 경우
        int[][][] dp = new int[N + 1][3][3];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
            }
        }
        dp[1][0][0] = 1;    // G
        dp[1][1][0] = 1;    // T
        dp[1][0][1] = 1;    // B
        for (int n = 2; n < N + 1; n++) {
            // 끝에 G 붙이기 -> 어느 경우에든 붙일 수 있음
            for (int t = 0; t < 3; t++) {
                dp[n][t][0] = 0;
                for (int b = 0; b < 3; b++) {
                    if (dp[n - 1][t][b] != Integer.MIN_VALUE) {
                        dp[n][t][0] = (dp[n][t][0] + dp[n - 1][t][b]) % STANDARD;
                    }
                }
            }
            // 끝에 B 붙이기
            for (int t = 0; t < 3; t++) {
                // 연속으로 B가 0개 있을 때, B 붙이기
                if (dp[n - 1][t][0] != Integer.MIN_VALUE) {
                    dp[n][t][1] = dp[n - 1][t][0];
                }
                // 연속으로 B가 1개 있을 때, B 붙이기
                if (dp[n - 1][t][1] != Integer.MIN_VALUE) {
                    dp[n][t][2] = dp[n - 1][t][1];
                }
            }
            // 끝에 T 붙이기
            for (int t = 1; t < 3; t++) {   // t가 2개 있을 때는 못 붙임
                for (int b = 0; b < 3; b++) {
                    if (dp[n - 1][t - 1][b] != Integer.MIN_VALUE) {
                        dp[n][t][0] = (dp[n][t][0] + dp[n - 1][t - 1][b]) % STANDARD;
                    }
                }
            }

        }

        // N일인 경우의 수 모두 더하기
        int answer = 0;
        for (int t = 0; t < 3; t++) {
            for (int b = 0; b < 3; b++) {
                if (dp[N][t][b] != Integer.MIN_VALUE) {
                    answer = (dp[N][t][b] + answer) % STANDARD;
                }
            }
        }
        System.out.println(answer);
    }
}