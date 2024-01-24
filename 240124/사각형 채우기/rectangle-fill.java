import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(rectangle(N));
    }

    static int rectangle(int N) {
        int[] dp = new int[N + 1];
        dp[1] = 1;
        if (N == 1) return dp[N];
        dp[2] = 2;
        for (int i = 3; i <= N; i++) {
            // 2 * 1 붙이는 경우의 수 + 1 * 2 2개를 붙이는 경우의 수
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }
        return dp[N];
    }
}