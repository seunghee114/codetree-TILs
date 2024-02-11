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
        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coins);
        // end input

        int ans = 0;
        for (int i = N - 1; i >= 0; i--) {
            int q = K / coins[i];
            K = K % coins[i];
            ans += q;
        }
        System.out.println(ans);
    }
}