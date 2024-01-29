import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static final int STANDARD = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // dp[i][j] : i 길이의 계단 수고 마지막 수가 j이다.
        int[][] dp = new int[N + 1][10];
        dp[1][0] = 0;
        for (int j = 1; j < 10; j++) {
            dp[1][j] = 1;
        }
        // end init

        // dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1] 0 <= j-1, j+1 < 10
        for (int i = 2; i < N + 1; i++) {
            for (int j = 0; j < 10; j++) {
                if (j - 1 >= 0) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (j + 1 < 10) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % STANDARD;
                }
            }
        }
        int answer = 0;
        for (int j = 0; j < 10; j++) {
            answer = (answer + dp[N][j]) % STANDARD;
        }
        System.out.println(answer);
    }
}