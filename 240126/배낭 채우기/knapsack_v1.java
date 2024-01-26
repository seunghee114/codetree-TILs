import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inArr = br.readLine().split(" ");
        int N = Integer.parseInt(inArr[0]);
        int M = Integer.parseInt(inArr[1]);

        int[][] items = new int[N+1][2];

        for (int i = 0; i < N; i++) {
            inArr = br.readLine().split(" ");
            int weight = Integer.parseInt(inArr[0]);
            int value = Integer.parseInt(inArr[1]);
            items[i+1] = new int[]{weight, value};
        }
        // end input

        // dp[i][j][0] : i번 item까지 고려하고 i번 item을 꼭 사용하고, 무게가 j일 때, 최대 가치
        // dp[i][j][1] : i번 item까지 고려하고 i번 item을 사용 안 하고, 무게가 j일 때, 최대 가치
        int[][][] dp = new int[N+1][M+1][2];    
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < M + 1; j++) {
                dp[i][j] = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
            }
        }
        int answer = 0;
        for (int i = 1; i < N + 1; i++) {
            for (int weight = 1; weight < M + 1; weight++) {
                int tempW = weight - items[i][0];
                // i번 item 사용
                if (tempW >= 0) {
                    // i-1번 item 사용했을 때랑, 안했을 때 중 큰 값
                    int value = Math.max(dp[i-1][tempW][0], dp[i-1][tempW][1]);
                    if (value == Integer.MIN_VALUE) {
                        continue;
                    }
                    dp[i][weight][0] = value + items[i][1];
                }
                // i번 item 사용 안함
                dp[i][weight][1] = Math.max(dp[i - 1][weight][0], dp[i - 1][weight][1]);
            }
        }
        System.out.println(Math.max(dp[N][M][0], dp[N][M][1]));
    }
}
