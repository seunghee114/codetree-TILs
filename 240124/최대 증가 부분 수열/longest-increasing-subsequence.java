import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] number = new int[N + 1];
        String[] inArr = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            number[i + 1] = Integer.parseInt(inArr[i]);
        }
        // end input

        int[] dp = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (number[i] > number[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        int answer = 0;
        for (int i = 1; i < N + 1; i++) {
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}