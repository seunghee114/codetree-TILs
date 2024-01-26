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

        // dp[i] : 무게가 i일 때, 최대 가치
        int[] dp = new int[M + 1];
        int answer = 0;
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for (int i = 1; i < N + 1; i++) {
            for (int w = M; w > 0; w--) {
                int tempW = w - items[i][0];
                if (tempW < 0 || dp[tempW] == Integer.MIN_VALUE) continue;
                dp[w] = Math.max(dp[w], dp[tempW] + items[i][1]);
                answer = Math.max(dp[w], answer);
            }
        }
        System.out.println(answer);
    }
}