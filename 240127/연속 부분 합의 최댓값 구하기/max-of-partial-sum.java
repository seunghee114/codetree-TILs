import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] Num = new int[N];
        String[] inArr = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            Num[i] = Integer.parseInt(inArr[i]);
        }
        // end input

        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = Num[0];
        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(dp[i - 1] + Num[i], Num[i]);
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}