import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inArr = br.readLine().split(" ");
        int N = Integer.parseInt(inArr[0]);
        int K = Integer.parseInt(inArr[1]);
        int[] number = new int[N + 1];
        inArr = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            number[i+1] = Integer.parseInt(inArr[i]);
        }
        // dp[i][j] : i번 숫자가 부분 수열의 마지막이고, j개의 음수가 부분 수열에 포함되어 있다.
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 1; i < N + 1; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        dp[0][0] = 0;
        for (int i = 1; i < N + 1; i++) {
            for (int j = 0; j < K + 1; j++) {
                if (number[i] >= 0) {    // 양수
                    if (dp[i-1][j] != Integer.MIN_VALUE) {  // 현재값을 마지막으로 하는 부분 수열
                        dp[i][j] = dp[i - 1][j] + number[i];
                    }
                    if (dp[i][0] == Integer.MIN_VALUE) {
                        dp[i][0] = number[i];   // 현재값을 시작으로 하는 부분 수열
                    } else {
                        dp[i][0] = Math.max(dp[i][0], number[i]);
                    }
                } else {    // 음수
                    if (j-1 >= 0 && dp[i-1][j-1] != Integer.MIN_VALUE) {    // 현재값을 마지막으로 하는 부분 수열
                        dp[i][j] = dp[i - 1][j - 1] + number[i];
                    }
                    if (dp[i][1] == Integer.MIN_VALUE) {    // 현재값을 시작으로 하는 부분 수열
                        dp[i][1] = number[i];
                    } else {
                        dp[i][1] = Math.max(dp[i][1], number[i]);
                    }

                }
            }
        }
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < K + 1; j++) {
                if (i == 0 ) continue;
                answer = Math.max(answer, dp[i][j]);
            }
        }
        System.out.println(answer);
    }
}