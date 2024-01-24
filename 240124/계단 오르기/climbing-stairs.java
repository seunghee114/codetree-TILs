import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(step(n));
    }

    static int step(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 0;
        dp[2] = 1;
        if (n == 2) return dp[n];
        dp[3] = 1;
        for (int i = 4; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 3]) % 10007;
        }
        return dp[n];
    }
}