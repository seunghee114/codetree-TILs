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

        // dp[i][j] : i번까지 고려했고, j번 무게일 때, 최대 가치
        int[][] dp = new int[N + 1][M + 1];

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                // i번 사용 안함
                dp[i][j] = dp[i-1][j];

                // i번 사용
                int tempW = j - items[i][0];
                if (tempW >= 0){
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][tempW] + items[i][1]);
                }
            }
        }
        System.out.println(dp[N][M]);
    }
}