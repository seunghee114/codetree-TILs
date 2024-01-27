import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] card = new int[2][N+1];
        for (int i = 0; i < 2; i++) {
            String[] inArr = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                card[i][j+1] = Integer.parseInt(inArr[j]);
            }
        }
        // end input

        // dp[i][j] : 1번째 플레이어의 카드 더미 상단이 i번, 2번째 플레이어의 카드 더미 상단이 j번일 때, 2번째 플레이어의 최대 점수
        // 1. 이전 라운드에서 카드를 버렸을 경우, dp[i-1][j-1]
        // 2. 이전 라운드에서 1번째 플레이어가 점수를 얻었을 경우, dp[i-1][j] if card[0][i-1] < card[1][j]
        // 3. 이전 라운드에서 2번째 플레이어가 점수를 얻었을 경우, dp[i][j-1] if card[0][i] > card[1][j-1]
        int[][] dp = new int[N + 1][N + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                int before = dp[i - 1][j - 1];      // 1.
                if (i - 1 > 0 && card[0][i - 1] < card[1][j]) {     // 2.
                    before = Math.max(before, dp[i - 1][j]);
                }
                if (j - 1 > 0 && card[0][i] > card[1][j - 1]) {       // 3.
                    before = Math.max(before, dp[i][j - 1]);
                }
                dp[i][j] = before;
                // 현재 카드 상태로 2번째 플레이어가 점수 획득할 수 있으면 획득
                if (card[0][i] > card[1][j]) {
                    dp[i][j] += card[1][j];
                }
            }
        }
        int answer = 0;
        for (int i = 1; i < N + 1; i++) {
            answer = Math.max(answer, Math.max(dp[i][N], dp[N][i]));
        }
        System.out.println(answer);
    }
}